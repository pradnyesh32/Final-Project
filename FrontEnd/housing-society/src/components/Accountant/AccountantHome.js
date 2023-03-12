
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import apt from '../../images/apt.jpg'
const AccountantHome=()=>{
    let id = useParams();
    let numberid = parseInt(id.id);
    console.log(numberid);

   return(
    <div className="col-md-12 text-center display-2" style={{backgroundImage: `url(${apt})`,height: "100%" ,backgroundPosition:"center",width:1150, }}>
         <div>
        <Link to={`/addmaintainanceacc/${numberid}`}>
          <button type="button" className="btn btn-secondary btn-lg ">
          Add Maintainance
          </button>
        </Link>
      </div>
      <div>
        <Link to={`/getdataacc/${numberid}`}>
          <button type="button" className="btn btn-secondary btn-lg ">
          Get Information
          </button>
        </Link>
      </div>

    </div>
   );
}
export default AccountantHome;