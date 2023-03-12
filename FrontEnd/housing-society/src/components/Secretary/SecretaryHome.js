

import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import apt from '../../images/apt.jpg'
const SecretaryHome = () => {
  let id = useParams();
  let numberid = parseInt(id.id);
  console.log(numberid);



  return (
    <div class="col-md-12 text-center display-2" style={{backgroundImage: `url(${apt})`,height: "100%" ,backgroundPosition:"center" ,width:1150,height:500 }}>
      <div>
        <Link to={`/pendingrequest/${numberid}`}>
          <button type="button" className="btn btn-primary btn-lg ">
            Pending Request
          </button>
        </Link>
      </div>
      <div>
        <Link to={`/addnotification/${numberid}`}>
          <button type="button" className="btn btn-secondary btn-lg ">
            Add Notification
          </button>
        </Link>
      </div>
      <div>
        <Link to={`/shownotification/${numberid}`}>
          <button type="button" className="btn btn-secondary btn-lg ">
          Show Notification
          </button>
        </Link>
      </div>

    </div>
  );
};
export default SecretaryHome;
