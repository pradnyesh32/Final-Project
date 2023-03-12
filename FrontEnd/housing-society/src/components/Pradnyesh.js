import React from "react";
import img2 from '../images/me.jpg';

const Pradnyesh=()=>{

    return(
        <div>
            <div className="person-profile">
      <div className="profile-image">
        <img src={img2} alt="img23" width={200} height={200} />
      </div>
      <div className="profile-details ">
        <h2>Pradnyesh Kadam</h2>
        <h3> <p> Age: 23 </p>
        <p>"Developer at Iacsd</p></h3>
      </div>
    </div>

        </div>
    );
}
export default Pradnyesh;