<%@page import="Model.bean.inforaccount"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
  .text{
    font-size:14px;
    padding:7px;
    border-radius:10px;
    width:300px;
    border: 1px solid #ccc;
    margin-bottom:10px;
   }
   label{
    font-size:18px;
     margin-right:10px;
   }
   .button-SignUp{
   font-size:20px;
   font: 20px Roboto,Sans-srif;
   margin-left: 97px;
     width:410px;
     padding:7px;
     border: 0px solid #ccc;
     Color:#FFFFFF;
     background-color:#DD4B39;
     border-radius:5px;  
     cursor: pointer;  
   }
   .button-ChangeInfo{
    font-size:20px;
   font: 20px Roboto,Sans-srif;
   margin-left: 97px;
   margin-bottom:10px;
     width:410px;
     padding:7px;
     border: 0px solid #ccc;
     Color:#FFFFFF;
     background-color:#04AA6D;
     border-radius:5px; 
     cursor: pointer;
   }
   .div_change{
   margin-top:60px;
   margin-left:30%;
    width:40%;
    height:450px;
    border-radius: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
   }
    .box{
     position:absolute;
    }
      .alert {
  padding: 20px;
  width:600px;
  background-color: #f44336;
  color: white;
  opacity: 1;
  margin-bottom: 15px;
  display:none;
   animation: show 0.3s ease 1 forwards 
}
    @keyframes show{
        0%{
            transform: translateX(0%);
        }
        40%{
            transform: translateX(135%);
        }
        80%{
            transform: translateX(130%);
        }
        100%{
            transform: translateX(135%);
        }
    }
.alert.success {background-color: #04AA6D;}
.alert.info {background-color: #2196F3;}
.alert.warning {background-color: #ff9800;}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
 
}  
  }
.closebtn:hover {
  color: black;
}
 .overlay {
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.7); /* Màu nền tối với độ trong suốt */
      z-index: 2; /* Đảm bảo nó nằm trên tất cả các phần tử khác */
         display: none;
    }

    .form-container {
      background-color: white;
      left:35%;
      top:10%;
      width: 30%; 
      height: 70%;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Đổ bóng cho form */
      z-index: 3; /* Đảm bảo nó nằm trên overlay */
      border-radius:30px;
         display: none;
    }
      .button-ChangePass{
   font-size:20px;
   font: 20px Roboto,Sans-srif;
   margin: 0px 0px 10px 30px;
     width:400px;
     padding:7px;
     border: 0px solid #ccc;
     Color:#FFFFFF;
     background-color:#DD4B39;
     border-radius:5px;
   }
   .button-CanCell{
     font-size:20px;
     font: 20px Roboto,Sans-srif;
   margin: 0px 50px 10px 30px;
    width:400px;
     padding:7px;
     border: 0px solid #ccc;
     Color:#FFFFFF;
     background-color:#54D4B3;
     border-radius:5px;
   }
    .text{
    font-size:14px;
    padding:7px;
    border-radius:10px;
    width:300px;
    border: 1px solid #ccc;
    margin-bottom:10px;
   }
</style>
</head>
<body>
<div class="box alert info">
  <span class="closebtn">&times;</span>  
  <strong>Info!</strong> <%=(String)request.getAttribute("notification")%>
</div>

<div class="box alert success">
  <span class="closebtn">&times;</span>  
  <strong>Success!</strong> <%=(String)request.getAttribute("notification")%>
</div>
   <%inforaccount info = (inforaccount) session.getAttribute("info"); %>
    <div class="box div_change">
    <form action="QLChangeInfo" method="post">
      <table class="form" align=center border="0">
       <caption><h1>Thông tin cá nhân</h1></caption>
       
        <tr>
          <td> <label>IDAccount</label> </td>
            <td><input type="text"  class="text" name="idAccount" readonly value="<%=info.getIdAccount()%>"><td>
            </tr>
            
             <tr>
          <td> <label>Name</label> </td>
            <td><input type="text"  class="text" name="Name" value="<%=info.getName()%>"><td>
            </tr>
            
               <tr>
          <td> <label>Age</label> </td>
            <td><input type="text"  class="text" name="Age" value="<%=info.getAge()%>"><td>
            </tr>
            
               <tr>
          <td> <label>Address</label> </td>
            <td><input type="text"  class="text" name="Address" value="<%=info.getAddress()%>"><td>
            </tr>          
               <tr>
          <td> <label>Phone</label> </td>
            <td><input type="text"  class="text" name="SDT" value="<%=info.getSDT()%>"><td>
            </tr>
                    
      </table>
        <input type="submit" class="button-ChangeInfo" name="ChangeInfo" value="Cập nhật">                           
    </form>
    <input type="submit" class="button-SignUp" name="SignUp" value="Đổi mật khẩu" onClick="showSignupForm()">  
    </div>
       <div class="box overlay" id="overlay"></div>
   <div class="box form-container" id="form-container">
    <form action="QLChangeInfo?idAccount=<%=info.getIdAccount()%>" method="post">
      <table align=center border="0">
       <caption><h1>Đổi mật khẩu</h1></caption>
        
            <tr>
            <td><label>Username</label></td>
              <td><input type="text"  class="text" name="Username" placeholder="Enter username" /> </td>      
      </tr>
       <tr>
          <td> <label>Out Pass</label> </td>
            <td><input type="password" class="text" name="OutPassword" placeholder="Enter your out password"><td>
            </tr>
            
            <tr>
             <td> <label>New Pass</label> </td>
            <td><input type="password" class="text" name="NewPassword" placeholder="Enter your new password"><td>
            </tr>
            
            <tr>
            <td> <label>New Pass</label> </td>
            <td><input type="password" class="text" name="NewPasswordAgain" placeholder="Enter your new password again"><td>
            </tr>
         
      </table>
        <input type="submit" class="button-ChangePass" name="ChangePass" value="Thay đổi">            
            <input type="button" class="button-CanCell" name="CanCell" value="CanCell" onClick="hireSignUp()">
    </form>
  </div>
    <script>
    function showSignupForm() {
        document.getElementById('overlay').style.display = 'block';
        document.getElementById('form-container').style.display = 'block';
      }
      function hireSignUp(){
        document.getElementById('overlay').style.display='none';
        document.getElementById('form-container').style.display ='none';
      }
    var notification = "<%= request.getAttribute("notification") %>";
    var alerts = document.getElementsByClassName("alert");    
   if(notification == "Thay đổi thông tin thành công!!!" || notification == "Thay đổi thông tin đăng nhập thành công!!!"){
        alerts[1].style.display = 'block';           
        }else if(notification == "Hãy nhập đầy đủ thông tin!!!" || notification == "Mật khẩu mới và mật khẩu mới nhập lại không giống nhau!!!" || notification == "Mật khẩu cũ không đúng!!!"){
        	alerts[0].style.display = 'block'; 
        }
   var close = document.getElementsByClassName("closebtn");
   var i;
   for (i = 0; i < close.length; i++) {
     close[i].onclick = function(){
       var div = this.parentElement;
       div.style.opacity = "0";
       setTimeout(function(){ div.style.display = "none"; }, 1);
     }
   }
    </script>
</body>
</html>