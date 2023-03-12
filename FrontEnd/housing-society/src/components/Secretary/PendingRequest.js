import axios from "axios";
import { useEffect, useState  } from "react";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";


const PendingRequest=()=>{
  let id =useParams();
  let numberid= parseInt(id.id);
  console.log(numberid);
  let user;

const [user7, setUser7] = useState([])


  useEffect(() => {
    user = axios.get(`http://localhost:8080/secretary/pendingrequest/${numberid}`).then((res)=>{
    console.log(res)
      setUser7(res.data)
      console.log(user7)
  })
  }, [])

  

    function remove(data){
      console.log("in remove");
      console.log(data);
      axios.post('http://localhost:8080/secretary/deleterequest',data).then((res)=>console.log("succes")).catch(()=>console.log("error"))
      window.location.reload(false);
    }
    
    
    function Save(data){
      console.log("in save");
      axios.post(`http://localhost:8080/secretary/addrequest/${numberid}`,data).then((res)=>console.log("success")).catch(()=>console.log("error"));
    
    axios.post('http://localhost:8080/secretary/deleterequest',data).then((res)=>console.log("succes")).catch(()=>console.log("error"));
    window.location.reload(false);
    }
    
  
  return(
<div>
  <table className="table" style={{border:"solid"}}>
  <tr style={{border:"solid"}}>
        <th scope="col" style={{border:"solid"}}>FirstName</th>
        <th scope="col" style={{border:"solid"}}>LastName</th>
        <th scope="col" style={{border:"solid"}}>Email</th>
        <th scope="col" style={{border:"solid"}}>Mobile No.</th>
        <th scope="col" style={{border:"solid"}}>Role</th>
        <th scope="col" style={{border:"solid"}}>Society Name</th>
    </tr>
{
  user7.map((current)=>{
    return(
      <>
      <tr>
      <td style={{border:"solid"}}> {current.firstName}</td>
      <td style={{border:"solid"}}> {current.lastName}</td>
      <td style={{border:"solid"}}> {current.email}</td>
      <td style={{border:"solid"}}> {current.mobileNumber}</td>
      <td style={{border:"solid"}}> {current.role}</td>
      <td style={{border:"solid"}}> {current.societyName}</td>
      <td style={{border:"solid"}}><button type="button"  style={{backgroundColor:"yellowgreen"}} onClick={()=>Save(current)}>Save</button></td>
      <td style={{border:"solid"}}><button  type="button" style={{backgroundColor:"red"}} onClick={()=>remove(current)} >Delete</button></td>
      
      </tr> 
      </>
    )
  })
}
     
</table>
</div>


  )
}
export default PendingRequest;