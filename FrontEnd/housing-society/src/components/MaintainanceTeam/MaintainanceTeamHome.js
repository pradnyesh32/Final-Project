
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import apt from '../../images/apt.jpg'

const MaintainanceTeamHome=()=>{
    let id = useParams();
    let numberid = parseInt(id.id);
    console.log(numberid);

    return(
    
        <div class="col-md-12 text-center display-2" style={{backgroundImage: `url(${apt})`,backgroundSize:"cover" ,backgroundPosition:"center",width:1200,height:500 }}>
        <div>
        <Link to={`/maintainancecomplaintshow/${numberid}`}>
          <button type="button" className="btn btn-secondary btn-lg ">
         Show Complaint
          </button>
        </Link>
         </div>

        </div>

    );
    
}
export default MaintainanceTeamHome;