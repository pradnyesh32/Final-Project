import React from "react";
import Pradnyesh from "./Pradnyesh";
import Abhijit from "./Abhijit";
const AboutUs=()=>{

    return (
        <div>
         <div className="col-md-12 text-center display-2">
            <br></br>
           <h2 style={{ backgroundColor: "yellowgreen" ,borderRadius:20, borderStyle:"solid"}}> About Us</h2><br/><hr/>
           <h4 style={{ backgroundColor: "lightblue" ,borderRadius:20, borderStyle:"solid" }}>Housing Society Portal is one web application platform solution for day to day housing society operations . The
project includes technologies like React, Spring Boot , MySQL . The frontend of project includes technology like
react , axios , JSX. The backend mainly made using spring boot , spring data jpa , MySql Driver , Hibernate ,
Lombok , Model Mapper , Spring Security using JWT . The DBMS used is MySql and is normalised to 3-NF . The
It has five entities Secretary , Owner ,Tenants , Accountant and Maintainance Team. It includes Functionality like
getting notifications and notices from secretary. Sign up and Sign in for these Users . Checking Maintainance status
, inserting complaints and resolvng them, Checking overall status of maintainance payment And many more.</h4>
            <h1>DEVELOPERS : </h1>
            <table>
            <tr>
                <td>
            <Pradnyesh/>
            </td>
            <td>
            <Abhijit/>
            </td>
            </tr>
            </table>
           
            </div>
           
        </div>
    );
}

export default AboutUs;