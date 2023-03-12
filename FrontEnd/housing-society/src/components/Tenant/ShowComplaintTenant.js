import axios from "axios";
import { useEffect, useState  } from "react";
import { useParams } from "react-router-dom";



const ShowComplaintTenant=()=>{
  let id =useParams();
  let numberid= parseInt(id.id);
  console.log(numberid);


const [notice, setNotice] = useState([])

  useEffect(() => {
    axios.get(`http://localhost:8080/tenant/complaint/show/${numberid}`).then((res)=>{
    console.log(res)
      setNotice(res.data)
  })
  }, [])

  return(
<div>
  <table className="table table-striped">
  <thead class="thead-dark">
  <tr>
        <th scope="col">ID</th>
        <th scope="col">Complaint  Date</th>
        <th scope="col"> Description</th>
        <th scope="col">status</th>
        <th scope="col">Resolve Date</th>
    </tr>
    </thead>
{
  notice.map((current)=>{
    return(
      <>
      <tr scope="row">
      <td> {current.cid}</td>
      <td> {current.complaintDate}</td>
      <td> {current.descriptions}</td>
      <td> {current.status}</td>
      <td> {current.resolveDate}</td>
      </tr> 
      </>
    )
  })
}
     
</table>
</div>


  )
}
export default ShowComplaintTenant;