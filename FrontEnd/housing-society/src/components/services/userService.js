import { myAxios } from "./helper";

export const signUp=(user)=>{
   
    return myAxios.post('/user/signup',user)
    .then((response)=>response.data)   
}
export const signIn=(user)=>{
    const result= myAxios.post('/user/signin',user)
     .then((response)=> response.data)
    
    
 }

//  if(user.role==="SECRETARY"){
    
     
//     navigate("/loginsecreatry")
//    }
//    if(user.role==="OWNER"){
//     navigate("/loginowner")
//    }
//    if(user.role==="TENANT"){
//     navigate("/logintenant")
//    }
//    if(user.role==="ACCOUNTANT"){
//     navigate("/loginaccountant")
//    }
//    if(user.role==="MAINTAINANCE_TEAM"){
//     navigate("/loginmaintainanceteam")
//    }  