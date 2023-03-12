import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Navigate } from "react-router-dom";
const TenantOtp = (props) => {

  const navigate = useNavigate();
  let name, value, users, result;
  
  const [user, setUser] = useState({
    otp:""
  });

  const handleChange = (e) => {
    name = e.target.name;
    value = e.target.value;
    setUser({ ...user, [name]: value });
    
  };

  const handleclick = (e) => {
    result = axios
      .post("http://localhost:8080/user/verify/"+user.otp, props.userc)
      .then((res) => {
        users = res.data;
        alert("Email Verified");
        navigate("/");
      });
  };

  return (
    <div >
    <form className="mx-auto col-6 col-md-10 col-lg-6 text-dark fw-bold">
      <h3 style={{ color: "white" }}>Authenticate Email</h3>

      <div className="mb-3 col-md-9">
        <label >Email address</label>
        <input
          type="email"
          className="form-control"
          placeholder="Enter email"
          required
          id="email"
          name="email"
          value={user.email}
          onChange={handleChange}
        />
      </div>
      <div className="mb-3 col-md-9">
        <label>OTP</label>
        <input
          type="password"
          className="form-control"
          placeholder="Enter OTP"
          required
          id="otp"
          name="otp"
          value={user.otp}
          onChange={handleChange}
        />
      </div>
      
       
      
      <div >
        <button
          type="button"
          className="btn btn-danger "
          onClick={handleclick}
        >
          Submit
        </button>
      </div>
    </form>
    </div>
  );
};

export default TenantOtp;