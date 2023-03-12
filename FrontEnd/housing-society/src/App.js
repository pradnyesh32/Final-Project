import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from 'react';
import Navbar from './components/Navbar';
import Login from './components/Forms/Login';
import Role from './components/Role'
import SecretaryRegister from './components/Forms/SecretaryRegister';
import OwnerRegister from './components/Forms/OwnerRegister';
import MaintainanceTeamRegister from './components/Forms/MaintainanceTeamRegister';
import AccountantRegister from './components/Forms/AccountantRegister';
import TenantRegister from './components/Forms/TenantRegister';
import SecretaryHome from './components/Secretary/SecretaryHome';
import OwnerHome from './components/Owner/OwnerHome';
import AccountantHome from './components/Accountant/AccountantHome';
import TenantHome from './components/Tenant/TenantHome';
import MaintainanceTeamHome from './components/MaintainanceTeam/MaintainanceTeamHome';
import PendingRequest from './components/Secretary/PendingRequest';
import Notification from './components/Secretary/Notification'
import ShowNotification from './components/Secretary/ShowNotification';
import Home from './components/Home';
import AboutUs from './components/AboutUs';
import PendingRequestOwner from './components/Owner/PendingRequestOwner';
import AddcomplaintOwner from './components/Owner/AddcomplaintOwner';
import ShowComplaintOwner from './components/Owner/ShowComplaintOwner';
import PayMaintainanceOwner from './components/Owner/PayMaintainanceOwner';
import AddmainatainanceByAccountant from './components/Accountant/AddmainatainanceByAccountant';
import GetdataAccounts from './components/Accountant/GetdataAccounts'
import AddcomplaintTenant from './components/Tenant/AddComplaintTenant';
import ShowComplaintTenant from './components/Tenant/ShowComplaintTenant';
import ShowComplaintsMaintainanceTeam from './components/MaintainanceTeam/ShowComplaintsMaintainanceTeam';
import SecretaryOtp from './components/Forms/SecretaryOtp';
import TenantOtp from './components/Forms/TenantOtp';
import OwnerOtp from './components/Forms/OwnerOtp';
import AccountantOtp from './components/Forms/AccountantOtp.js';
import MTeamOtp from './components/Forms/MTeamOtp';
import ShowNotificationTenant from './components/Tenant/ShowNotificationTenant';
function App() {
const [user, setUser] = useState({
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  mobileNumber: "",
  societyName: "",
  role: "SECRETARY",
});

const [usert, setUsert] = useState({
  firstName:"",
    lastName:"",
    flatNo:"",
    email: "",
    password:"",
    mobileNumber:"",
    societyName:"",
    role:"TENANT",
});

const [usero, setUsero] = useState({
  firstName: "",
  lastName: "",
  flatNo: "",
  email: "",
  password: "",
  mobileNumber: "",
  societyName: "",
  role: "OWNER",
});

const [usera, setUsera] = useState({
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  mobileNumber: "",
  societyName: "",
  role: "ACCOUNTANT",
});

const [userm, setUserm] = useState({
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  mobileNumber: "",
  societyName: "",
  role: "MAINTAINANCE_TEAM",
  department: "",
});





  const secotp=(user1)=>{
    setUser(user1);
    
    
   
  }

  const tenantotp=(user2)=>{
    setUsert(user2);
    
    
  }

  const ownerotp=(user3)=>{
    setUsero(user3);
   
    
  }

  const accotp=(user4)=>{
    setUsera(user4);
    
    
  }

  const mtotp=(user5)=>{
    setUserm(user5);
   
    
  }

  

  return (
  <>
  <BrowserRouter>
      <Navbar sticky="top" />
      <Routes>
          <Route exact path="/" element={<Home/>} /> 
          <Route exact path="/aboutus" element={<AboutUs/>} /> 
          <Route exact path="/signup" element={<Role/>} /> 
          <Route exact path="/login" element={<Login />} /> 
          <Route exact path="/signupsecretary" element={<SecretaryRegister secotp={secotp}/>} /> 
          <Route exact path="/signupowner" element={<OwnerRegister ownerotp={ownerotp}/>} /> 
          <Route exact path="/signupAccountant" element={<AccountantRegister accotp={accotp}/>} /> 
          <Route exact path="/signupmaintainanceteam" element={<MaintainanceTeamRegister mtotp={mtotp}/>} /> 
          <Route exact path="/signuptenant" element={<TenantRegister tenantotp={tenantotp}/>} /> 
          <Route exact path="/loginsecreatry/:id"  element={<SecretaryHome /> }/> 
          <Route exact path="/loginowner/:id" element={<OwnerHome />} /> 
          <Route exact path="/logintenant/:id" element={<TenantHome/> }/> 
          <Route exact path="/loginaccountant/:id" element={< AccountantHome/> }/> 
          <Route exact path="/loginmaintainanceteam/:id" element={<MaintainanceTeamHome />} /> 
          <Route exact path="/pendingrequest/:id" element= {< PendingRequest/>}/>
          <Route exact path="/addnotification/:id" element= {<Notification/>}/>
          <Route exact path="/shownotification/:id" element= {<ShowNotification/>}/>
          <Route exact path="/pendingrequestowner/:id" element= {<PendingRequestOwner/>}/>
          <Route exact path="/addcomplaintowner/:id" element= {<AddcomplaintOwner/>}/>
          <Route exact path="/showcomplaintowner/:id" element= {<ShowComplaintOwner/>}/>
          <Route exact path="/paymaintainanceowner/:id" element= {<PayMaintainanceOwner/>}/>
          <Route exact path="/addmaintainanceacc/:id" element= {<AddmainatainanceByAccountant/>}/>
          <Route exact path="/getdataacc/:id" element= {<GetdataAccounts/>}/>
          <Route exact path="/addcomplainttenant/:id" element= {<AddcomplaintTenant/>}/>
          <Route path="/maintainancecomplaintshow/:id" element= {<ShowComplaintsMaintainanceTeam/>}/>
          <Route exact path="/showcomplainttenant/:id" element= {<ShowComplaintTenant/>}/>
          <Route exact path="/secotp" element= {<SecretaryOtp userc={user}/>}/>
          <Route exact path="/tenantotp" element= {<TenantOtp userc={usert}/>}/>
          <Route exact path="/ownerotp" element= {<OwnerOtp userc={usero}/>}/>
          <Route exact path="/accotp" element= {<AccountantOtp userc={usera}/>}/>
          <Route exact path="/mtotp" element= {<MTeamOtp userc={userm}/>}/>
          <Route path="/shownotificationtenant/:id" element= {<ShowNotificationTenant/>}/>
      </Routes>
    </BrowserRouter>
    
  </>
  );
}

export default App;
