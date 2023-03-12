import axios from "axios";
import React, { useState } from "react";
import { useParams } from "react-router-dom";


const AddcomplaintOwner = () => {
  let id = useParams();
  let numberid = parseInt(id.id);
  let user;

  const [notice, setNotice] = useState({
    descriptions: "",
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
        `http://localhost:8080/owner/complaint/add/${numberid}`,
        notice
      )
      .then((res) => console.log("succes"))
      .catch((error) => console.log(error));
  };

  return (
    <>
    <div className="col-md-12 text-center display-2">
      <div className="form-outline mx-auto col-10 col-md-10 col-sm-10 ">
        <textarea
          className="form-control"
          id="description"
          rows="4"
          name="description"
          value={notice.description}
          onChange={handleChange}
        ></textarea>
        <label className="form-label" htmlfor="description"></label>
        <button
          type="button"
          className="btn btn-secondary btn-sm"
          onClick={handleclick}
        >
          Add Complaint
        </button>
      </div>
    </div>
    </>
  );
};
export default AddcomplaintOwner;
