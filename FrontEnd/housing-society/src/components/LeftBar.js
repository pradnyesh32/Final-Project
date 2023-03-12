import React from "react";
import "../css/LeftBar.css";


const LeftBar = () => {
  return (
    <div style={{fontSize: 20 , marginLeft: "40px" , width:300}}>
      <br/>
      <br/>
    <div style={{ backgroundColor: "lightblue" ,borderRadius:20, borderStyle:"solid" }}>
      <b style={{ color: "green",textAlign:"center"}}>
        We provide one platform solution for your day to day Housing society
        operations.<br></br>Register your society here as a Secretary and get
        free acess to our services.Housing Society Portal provide you with.
        </b>
        
        <br />
        <ul
          style={{
            color: "black",
            backgroundColor: "lightblue",
            width:250,
            marginLeft:25,
            marginBottom:25,
           
            borderStyle:"solid",
            borderColor:"black",
            borderWidth:10,
            borderRadius:30
           
          }}
        >
          <li>Owner management services.</li>
          <li>Tenant Management Services</li>
          <li>Society Complaint Management</li>
          <li>Maintainance Payment And Tracker System</li>
          <li>Sending Notifications To All Residents</li>
        </ul>
        </div>
      
    </div>
  );
};
export default LeftBar;
