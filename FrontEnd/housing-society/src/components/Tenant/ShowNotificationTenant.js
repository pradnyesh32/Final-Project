import axios from "axios";
import { useEffect, useState  } from "react";
import { useParams } from "react-router-dom";

const ShowNotificationTenant=()=>{
  let id =useParams();
  let numberid= parseInt(id.id);
  console.log(numberid);


const [notice, setNotice] = useState([])

  useEffect(() => {
    axios.get(`http://localhost:8080/secretary/notifications/show/${numberid}`).then((res)=>{
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
        <th scope="col">Assign Date</th>
        <th scope="col">End Date</th>
        <th scope="col">Discription</th>
    </tr>
    </thead>
{
  notice.map((current)=>{
    return(
      <>
      <tr scope="row">
      <td> {current.notificationId}</td>
      <td> {current.assignDate}</td>
      <td> {current.endDate}</td>
      <td> {current.description}</td>
      </tr> 
      </>
    )
  })
}
     
</table>
</div>


  )
}
export default ShowNotificationTenant;