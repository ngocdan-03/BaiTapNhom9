<%@page import="java.util.Base64"%>
<%@page import="Model.bean.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="cssdetail_product.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
    <title>Document</title>
    <style>
    button {
    background-color: rgba(0, 0, 0, 0);
    border:0px solid;
    }
    i{
    color: #fff;
    cursor:pointer;
    font-size:20px;
    margin-top:5px;
    }
    #textfield{
      border-radius:7px;
      border:1px solid;
      margin-bottom:5px;
    }
    body {
    background-image: url('./Image/backgroud.jpg'); 
    background-size: cover; /* Đảm bảo hình ảnh nền phủ toàn bộ phần nội dung */
    background-repeat: no-repeat; /* Không lặp lại hình ảnh */
}

.container{
 display: flex;
 align-items: center;
}
.image img{
  height:300px;
  width:200px;
}
.text{
 color: #fff;
}
    </style>
</head>
<body>
<%
product product = (product)request.getAttribute("product");
String image = Base64.getEncoder().encodeToString(product.GetImage());
%>
    <div class="container">
        <div class="image">
             <img src="data:image/jpg;base64,<%=image %>" alt="">
        </div>
        <div class="text">
          <h3><%=product.GetName() %></h3>
          <p><%=product.GetPrice() %> vnđ</p>
        </div>
    </div>
          <form action="OrderServlet" method="POST">
      <input type="text" id="textfield" name="textfield" />
      <input type="hidden" name="choose" value="addToCart" />
      <input type="hidden" name="yourNumber" value="<%=product.GetIdProduct()%>" />  
      <button type="submit"><i class="fa-solid fa-cart-arrow-down"></i> </button><br><br>
      </form>  
</body>
</html>