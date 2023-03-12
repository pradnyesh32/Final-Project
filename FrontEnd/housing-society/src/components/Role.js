import { Link } from "react-router-dom";
import Register from "./Forms/SecretaryRegister";
import roles from '../images/Role2.jpg';

const Role = () => {
  return (
    <div style={{backgroundImage: `url(${roles})`  }}>
      <h1 style={{marginLeft:300}}>Choose Your Role</h1>
      <div className="col-md-12 text-center display-2" style={{backgroundColor: "greenyellow" , width:400,height:500,marginLeft:300,borderRadius:30}}>
        <div>
          <Link to={"/signupsecretary"}>
            <button
              type="button"
              className="btn btn-primary btn-lg "
              onClick={() => <Register />}
            >
              Secretary
            </button>
          </Link>
        </div>
        <div>
          <Link to={"/signupowner"}>
            <button type="button" className="btn btn-primary btn-lg ">
              Owner
            </button>
          </Link>
        </div>
        <div>
          <Link to={"/signuptenant"}>
            <button type="button" className="btn btn-primary btn-lg">
              Tenant
            </button>
          </Link>
        </div>
        <div>
          <Link to={"/signupAccountant"}>
            <button type="button" className="btn btn-primary btn-lg">
              Accountant
            </button>
          </Link>
        </div>
        <div>
          {" "}
          <Link to={"/signupmaintainanceteam"}>
            <button type="button" className="btn btn-primary btn-lg">
              Maintainance Team
            </button>{" "}
          </Link>
        </div>
      </div>
    </div>
  );
};
export default Role;
