<%@page import="Model.bean.inforaccount"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Hiệu ứng chuyển động với CSS Animation</title>
    <style>
        /* CSS cho văn bản */
        .animated-text {
            font-size: 30px;
            animation: changeColor1 30s linear infinite;
        }

        /* Định nghĩa keyframes không cần màu sắc */
        @keyframes changeColor1 {
            0% {
                transform: translateX(-120%);
            }
            100% {
                transform: translateX(140%);
            }
        }

        .image1 {
            width: 143px;
            height: 143px;
        position:relative;
        top:-10px;
        right:520px;
        }
        .image2 {
            width: 140px;
            height: 110px;
           position:relative;
           top:10px;
           left:720px;
        }
        .box{
         position:absolute;
        }
        .greet{
         display:flex;
        }
  .alert {
  padding: 20px;
  width:600px;
  background-color: #04AA6D;
  color: white;
  margin-bottom: 15px;
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
  .text{
            text-decoration: none; 
            color:white;
                         
        }
        .choose{
        text-align:center;
            border: none;
        }     
       
       table{
         position:relative;
         top:110px;
       }
         .img3{
        width:150px;
        height:100px;
        position: absolute;
        top: 0px;
        animation: phuthuybay 30s linear infinite;
        
    }
    @keyframes phuthuybay{
        from{
            transform: translateX(-100%);
        }
        to{
            transform:translateX(1000%);
        }
    }
    </style>
</head>
<body style="overflow: hidden; background-color: aquamarine;">
    <div class="box greet">
        <p class="animated-text" id="changingText"><B>CHÀO MỪNG ĐẾN VỚI Phone Shop<3</B></p>
        <img  class="img3" src="https://cdn.pixabay.com/animation/2023/08/10/21/14/21-14-12-148_512.gif">
        <img class="image1" src="./Image/daumeo-removebg-preview.png">       
        <img class="image2" src="./Image/sieunhangao-removebg-preview.png">
        
    </div>
    <script>
        var textElement = document.getElementById("changingText");
        var colors = ['red', 'blue', 'orange' , 'black'];
        let currentIndex = 0;
    
        function changeColor() {
            textElement.style.color = colors[currentIndex];
            currentIndex = (currentIndex + 1) % colors.length;
        }
    
       setInterval(changeColor,200);
    
    </script>
      <body>
         <div class="box alert">
  <span class="closebtn">&times;</span>  
  <strong>Success!</strong> <%=(String)request.getParameter("notification")%> 
</div>
 <table align="center" border="0" width="65%">
         <tr><td class="choose"><a  class="text" href="Personal_Infor.jsp" target="Personal_Infor"><b>Thông tin cá nhân</b></a></td>
         <td class="choose"><a  class="text" href="controller?mod=1" target="Personal_Infor"><b>Sản phẩm</b></a></td>
          <td class="choose"><a  class="text" href="OrderServlet?choose=viewCart" target="Personal_Infor"><b>Giỏ Hàng</b></a></td>
           <td class="choose"><a  class="text" href="OrderServlet?choose=viewOrdersHistory" target="Personal_Infor"><b>Lịch sử mua hàng</b></a></td>  
          <% 
          String PQ=(String)request.getParameter("PQ"); 
            
           if(PQ.equals("true")){
        	    
        	 
          %>  
                        
            <td class="choose"><a  class="text" href="OrderServlet?choose=viewOrders" target="Personal_Infor"><b>Danh sách hóa đơn</b></a></td>
             <td class="choose"><a  class="text" href="controller?mod=1&mod2=1" target="Personal_Infor"><b>Danh sách sản phẩm</b></a></td>
            
             <% } %>
              <td class="choose"><a  class="text" href="Login.jsp" target="GUI.jsp"><b>Đăng xuất</b></a></td></tr>
        </table>
<script >
     var close = document.getElementsByClassName("closebtn");
     var i ;
     for(i=0 ; i<close.length ; i++){
    	 close[i].onclick = function(){
    		   var div = this.parentElement;
               setTimeout(function(){ div.style.display = "none"; }, 1);
    	 }
    	 
     }
</script>
    </body>
</body>
</html>