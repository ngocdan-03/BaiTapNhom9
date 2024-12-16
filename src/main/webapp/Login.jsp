<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Website mua bán điện thoại di động</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-9aU2lBzDT16+x8Z7ODuId5Qz02uQs74qdbdP7VYZxd2NDSuZGFQZFdBpMQ6fp9FfVhANxM1hmte2G/F7DowXQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
 <style>
 body{
  background-image: url('https://cdn.pixabay.com/photo/2016/10/29/01/36/abstract-1779608__480.png'); 
  background-size: cover; 
  background-repeat: no-repeat; 
  background-attachment: fixed;
  
 }
     .box{
     position:absolute;
    }
   .flex-container{
    display:flex;
    z-index:1;
   }
   .form-login{
    position:relative;
    top:100px;
    left:50px;
   }
   .text{
    font-size:14px;
    padding:7px;
    border-radius:10px;
    width:300px;
    border: 1px solid #ccc;
    margin-bottom:10px;
    text-indent: 30px;
    background-repeat: no-repeat;
   }
   label{
    font-size:18px;
     margin-right:10px;
   }
   .button-login{
     width:150px;
     padding:7px;
      border: 0px solid #ccc;
      Color:#FFFFFF;
     background-color:#3B71CA;
    border-radius:10px;
   }
   .button-SignUp{
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
   .link{
    font:16px Roboto, sans-serif;
    margin-left:10px;
    Color:#DC4C64;
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
.password-container {
  position: relative;
}
.password-icon {
  position: absolute;
  left: 10px;
  top: 15%;
  width: 30px; /* Điều chỉnh kích thước của hình ảnh */
  height: 30px; /* Điều chỉnh kích thước của hình ảnh */
  background-image: url('./Image/username.png'); /* Đường dẫn đến hình ảnh của bạn */
  background-size: cover; /* Đảm bảo hình ảnh vừa với kích thước đã đặt */
}
.id{
 background-image: url('./Image/id.png');
 background-position:1px;
 background-size: 35px;
}
.name{
 background-image: url('./Image/name.png');
 background-position:8px;
 background-size: 20px;
}
.age{
 background-image: url('./Image/age.png');
 background-position:8px;
 background-size: 20px;
}
.address{
 background-image: url('./Image/address.png');
 background-position:8px;
 background-size: 20px;
}
.phone{
 background-image: url('./Image/phone number.png');
 background-position:8px;
 background-size: 20px;
}
.user{
 background-image: url('./Image/username.png');
 background-position:-8px;
 background-size: 50px;
}
.pass{
 background-image: url('./Image/password.png');
 background-position:8px;
 background-size: 20px;
}
 </style>

</head>
<body>
      <div class="box alert">
  <span class="closebtn">&times;</span>  
  <strong>Error!</strong> <%=(String)request.getAttribute("notification")%>
</div>

<div class="box alert info">
  <span class="closebtn">&times;</span>  
  <strong>Info!</strong> <%=(String)request.getAttribute("notification")%>
</div>

<div class="box alert success">
  <span class="closebtn">&times;</span>  
  <strong>Success!</strong> <%=(String)request.getAttribute("notification")%>
</div>
      <div class="box flex-container">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp">
      <form class="form-login" action="QLLogin" method="post">
      <table align="center" border="0">
      <caption><h1>Login</h1></caption>
      <tr>
          <td> <label>Username</label> </td>
            <td><input type="text"  class="text name" name="user" placeholder="Enter Username"><td>
            </tr>
            <tr>
            <td><label>Password</label></td>
              <td><input type="password"  class="text pass" name="pass" placeholder="Enter password" /> </td>      
      </tr>
      <tr>
      <td></td>
       <td><input type="submit" class="button-login" value="Login">        
       </td>
      </tr>
      </table>
             <p>Don't have an account?<a href="#" onclick="showSignupForm()">Register</a></p>            
            
      </form>
            </div>
            
   <div class="box overlay" id="overlay"></div>
   <div class="box form-container" id="form-container">
    <form action="QLSignUp" method="post">
      <table align=center border="0">
       <caption><h1>Sign up</h1></caption>
         <tr>
          <td> <label>IDAccount</label> </td>
            <td><input type="text"  class="text id" name="idAccount" placeholder="Enter IDAccount"><td>
            </tr>
            
             <tr>
          <td> <label>Name</label> </td>
            <td><input type="text"  class="text name" name="Name" placeholder="Enter your name"><td>
            </tr>
            
               <tr>
          <td> <label>Age</label> </td>
            <td><input type="text"  class="text age" name="Age" placeholder="Enter your age"><td>
            </tr>
            
               <tr>
          <td> <label>Address</label> </td>
            <td><input type="text"  class="text address" name="Address" placeholder="Enter your address"><td>
            </tr>
            
               <tr>
          <td> <label>Phone</label> </td>
            <td><input type="text"  class="text phone" name="SDT" placeholder="Enter your phone"><td>
            </tr>
            
            <tr>
            <td><label>UserName</label></td>            
              <td>
    <input type="text" class="text user" name="Username" placeholder="Enter your password">
</td>      
      </tr>
       <tr>
          <td> <label>Password</label> </td>
            <td><input type="password" class="text pass" name="Password" placeholder="Enter your password"><td>
            </tr>
         
      </table>
        <input type="submit" class="button-SignUp" name="SignUp" value="Sign Up">            
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
       if(notification == "Đăng nhập không thành công!!!"){
            alerts[0].style.display = 'block';           
            }else if(notification == "Hãy nhập đầy đủ thông tin!!!"){
            	alerts[1].style.display = 'block'; 
            }else if(notification == "Đăng kí thành công!!!"){
            	alerts[2].style.display = 'block'; 
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