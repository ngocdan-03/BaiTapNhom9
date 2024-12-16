<%@page import="Model.bean.Entity_Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    .vcl{
       text-align:center;
    
    }
    .c{
     color: #6068e4;
     font-size:20px;
    }
    body{
    background-color: #ffffff;  /* Adjust this value to change the background color */
        font-family: Arial, sans-serif;
    }
    .total{
      margin-left:1125px;
      font-size:20px;
    }
    .form{
    display:flex;
    justify-content:center;
    }
    .button-thanhtoan{
    display:flex;
    background-color: rgba(0, 0, 0, 0);
    cursor:pointer;
    background-color: #04AA6D;
    border-radius:5px;
    border-radius:5px;
    }
    .button-huy{
     display:flex;
    background-color: rgba(0, 0, 0, 0);
    cursor:pointer;
    background-color:red;
    border-radius:5px;
    border-radius:5px;
    }
    table {
        background-color: #F0F0F0;  /* Adjust this value to change the background color */
    }
    /* Change the color of the table header */
    th {
        background-color: #B0B0B0;  /* Adjust this value to change the background color */
    }
</style>
<title>Insert title here</title>
</head>
<body>
<table align=center border="1" width="70%">
        <caption class="c"> <h1>Giỏ hàng</h1> </caption>
        <tr>
           <th>Tên sản phẩm</th>
           <th>Giá tiền</th>
           <th>Số lượng</th>
           <th>Tổng tiền</th>
          </tr>
     <% 
          ArrayList<Entity_Cart> CartArray=(ArrayList<Entity_Cart>)request.getAttribute("CartArray");
          int tongtien = 0;
          for(Entity_Cart sp : CartArray){
      %>
          <tr>
           <td class="vcl"><%=sp.getName() %></td>
           <td class="vcl"><%=sp.getPrice() %></td>
           <td class="vcl"><%=sp.getQuantity() %></td>
           <td class="vcl"><%=sp.getTotal() %></td>
           <% tongtien += sp.getTotal(); %>
           
          </tr>
      <%} %>
     </table>
     <label class="total">Tổng tiền:<%= tongtien %></label> 
     
     
            <form  class="form" action="OrderServlet" method="POST">
      <input type="hidden" name="choose" value="pay" />
       <button class="button-thanhtoan" type="submit"><image src="./Image/thanhtoan.png"></image><h3>Thanh Toán</h3></button><br><br>
        <input type="hidden" name="choose" value="NOpay" />
      <button class="button-huy" type="submit"><image src="./Image/no pay.png"></image><h4>Hủy thanh toán</h4></button><br><br>
      </form>
</body>
</html>