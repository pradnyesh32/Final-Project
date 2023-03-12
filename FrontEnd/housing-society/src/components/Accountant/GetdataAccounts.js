import axios from "axios";
import { useEffect, useState  } from "react";
import { useParams } from "react-router-dom"; 
import { Link } from "react-router-dom";


const GetdataAccounts=()=>{
  let id =useParams();
  let numberid= parseInt(id.id);
  console.log(numberid);
  let user;

const [user7, setUser7] = useState([])



  useEffect(() => {
    user = axios.get(`http://localhost:8080/accountant/getdata/${numberid}`).then((res)=>{
    console.log(res)
      setUser7(res.data)
      console.log(user7)
      
  })
  }, [])
    
  return(
<div>
  <table className="table">
  <tr>
        <th scope="col">Id</th>
        <th scope="col">Paid</th>
        <th scope="col">Total Maintainance</th>
        <th scope="col">Due Date</th>
        <th scope="col">Assign Date</th>
        <th scope="col">Description</th>
    </tr>
{
  user7.map((current)=>{
    return(
      <>
      <tr>
      <td> {current.id}</td>
      <td> {current.paid}</td>
      <td> {current.totalMaintainance}</td>
      <td> {current.dueDate}</td>
      <td> {current.assignDate}</td>
      <td>{current.description}</td>
      </tr> 
      </>
    )
  })
}
     
</table>
</div>
  )
}
export default GetdataAccounts;