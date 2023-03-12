import React from "react";
import {Link } from "react-router-dom";

class Navbar extends React.Component {
  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark sticky-top" >
        <Link className="navbar-brand" to="#" style={{color:"	yellowgreen", marginLeft: "20px" }}>
         Housing Society Portal
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item active">
              <Link className="nav-link" to="/" style={{color:"	yellowgreen"}}>
                Home <span className="sr-only" ></span>
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/signup" style={{color:"	yellowgreen"}}>
                Sign Up
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/login" style={{color:"	yellowgreen"}}>
                Sign In
              </Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/aboutus" style={{color:"	yellowgreen"}}>
                About Us
              </Link>
            </li>

          
       
          </ul>
        </div>
      </nav>
    );
  }
}

export default Navbar;
