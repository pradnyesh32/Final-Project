import React from "react";
import Abhi2 from '../images/Abhi2.jpg';

const Abhijit=()=>{

    return(
        <div>
            <div className="person-profile">
      <div className="profile-image">
        <img src={Abhi2} alt="img22" width={200} height={200}/>
      </div>
      <div className= "profile-details ">
        <h2>Abhijit Patil</h2>
        <h3><p>Age: "22"</p>
        <p>"Developer at IACSD</p></h3>
      </div>
    </div>
  

        </div>
    );
}
export default Abhijit;