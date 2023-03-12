import React, { useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

const PayMaintainanceOwner = () => {

    let id =useParams();
  let numberid= parseInt(id.id);
  console.log(numberid);
  let user;

  const [user7, setUser7] = useState({
    description:"",
    amount:"",
  });

  let name, value;

  const handleChange = (e) => {
    name = e.target.name;
    value = e.target.value;
    setUser7({ ...user7, [name]: value });
  };

  const handleclick = (e) => {
    e.preventDefault();
    console.log(user7);
    axios
      .post(
        `http://localhost:8080/owner/paymaintainance/${numberid}`,
       user7
      )
      .then((res) => console.log("succes"))
      .catch((error) => console.log(error));
  };

return (
   <div>
    <form className="mx-auto col-8 col-md-6 col-lg-6 fw-bold" style={{marginLeft: "200px"}} >
      <div className="form-group col-md-6">
        <label htmlFor="description" className="text-dark fw-bold ">Description</label>
        <input
          type="text"
          className="form-control"
          id="description"
          name="description"
        value={user7.description}
         onChange={handleChange}
        />
      </div>
      <div className="form-group col-md-6">
        <label htmlFor="amount">Amount</label>
        <input
          type="text"
          className="form-control"
          id="amount"
          name="amount" 
          value={user7.amount}
          onChange={handleChange}
        />
      </div>
      <button type="submit" className="btn btn-primary"  onClick={handleclick} >
        Submit
      </button>
    </form>
    </div>
  );
};
export default PayMaintainanceOwner;
