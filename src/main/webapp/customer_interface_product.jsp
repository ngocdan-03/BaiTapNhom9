<%@page import="java.util.Base64"%>
<%@page import="Model.bean.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.bean.account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
    <title>Document</title>
</head>
<body>
  <%
  account user=(account)request.getAttribute("user");
  ArrayList<product> listproduct=(ArrayList<product>)request.getAttribute("listproduct");
  %>
    <section class="slide__body">
        <div class="container">
            <div class="container_slide">
                <div class="slides">
                    <div class="item">
                        <img src="./Image/logo1.png" alt="">
                    </div>
                    <div class="item">
                        <img src="./Image/logo2.png" alt="">
                    </div>
                    <div class="item">
                        <img src="./Image/logo3.png" alt="">
                    </div>
                </div>
                <div class="next"><i class="fa-solid fa-chevron-right"></i></i></div>
                <div class="prev"><i class="fa-solid fa-angle-left"></i></i></div>
            </div>
        </div>
    </section>
    <!--search-->
    <form action="product_controller?mod=1" method="post">
    <div class="container_search">
      <div class="image_logo"><img src="./Image/logoweb.jpg" alt=""></div>
      <div class="search">
        <input type="text" name="tb_search" size="35" placeholder="search....">
        <button  type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
      </div> 
    </div>
     </form>
    <!--end search-->
    <!--product-->
    
    <section class="body_product">
        <div class="container">
            <div class="title"><h3>Sản phẩm</h3></div>
            <div class="show_product">
            <%
            for(int i=0;i<listproduct.size();i++){
            	product currentProduct = listproduct.get(i);
            	String image = Base64.getEncoder().encodeToString(currentProduct.GetImage());
            	
            
            %>
                <div class="card">
                    <div class="items">
                        <div class="image">
                            <img src="data:image/jpg;base64,<%=image %>" alt="">
                        </div>
                        <div class="text">
                            <h3><%=currentProduct.GetName() %> </h3>
                            <p><%=currentProduct.GetPrice() %> vnđ</p>
                        </div>
                       <div class="button">
                        <a href="./product_controller?mod=2&id=<%=currentProduct.GetIdProduct()%>"><i class="fa-solid fa-eye"></i></a>
                       </div>
                    </div>
                </div>
               <%} %>
                
            </div>
        </div>
    </section>

 <script src="jsproduct.js"></script>
</body>
</html>