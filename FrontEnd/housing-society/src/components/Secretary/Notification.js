import axios from "axios";
import React, { useState } from "react";
import sign1 from '../../images/complaint2.jpg'; 

import { useParams } from "react-router-dom";


const Notification = () => {

  let id = useParams();
  let numberid = parseInt(id.id);
  let user;

  const [notice, setNotice] = useState({
  });

  let name, value;

  const handleChange = (e) => {
    name = e.target.name;
    value = e.target.value;
    setNotice({ ...notice, [name]: value });
    console.log(notice);
  };
  const handleclick = (e) => {
    e.preventDefault();
    console.log(notice);
    axios
      .post(
        `http://localhost:8080/secretary/notification/add/${numberid}`,
        notice
      )
      .then((res) => console.log("succes"))
      .catch((error) => console.log(error));
  };

  return (
    <div className="col-md-12 text-center display-2" style={{backgroundImage: `url(${sign1})` , backgroundSize:"cover" ,height:500}}>
      <h1>Add New Notification</h1>
      <div className="form-outline mx-auto col-10 col-md-10 col-sm-10 ">
        <textarea
          className="form-control"
          id="description"
          rows="4"
          name="description"
          value={notice.description}
          onChange={handleChange}
          style={{backgroundColor:"lightblue"}}
          
        ></textarea>
        <label className="form-label" htmlfor="description"></label>
        <button
          type="button"
          className="btn btn-warning btn-sm"
          onClick={handleclick}
        >
          Add Notification
        </button>
      </div>
    </div>
  );
};
export default Notification;
