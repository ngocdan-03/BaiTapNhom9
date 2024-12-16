<%@page import="Model.bean.Entity_Order_Detail"%>
<%@page import="Model.bean.Entity_Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    /* Change the color of the table data/cells */
    .vcl{
       text-align:center;
    
    }
   body{
    background-color: #ffffff;  /* Adjust this value to change the background color */
        font-family: Arial, sans-serif;
    }
    table {
        background-color: #F0F0F0;  /* Adjust this value to change the background color */
    }
    /* Change the color of the table header */
    th {
        background-color: #B0B0B0;  /* Adjust this value to change the background color */
    }
    .c{
        color: #6068e4;
        font-size: 20px;
    }
</style>

<title>Insert title here</title>
</head>
<body>
     <table align=center border="1" width="70%">
        <caption class="c"> <h1>Chi tiết hóa đơn</h1> </caption>
        <tr>
           <th>ID Hóa đơn</th>
           <th>ID Tài khoản</th>
           <th>Người tạo</th>
           <th>Ngày tạo</th>
           <th>Tổng tiền</th>
          </tr>
     <% 
          ArrayList<Entity_Order> OrderArray=(ArrayList<Entity_Order>)request.getAttribute("OrderArray2");   
          for(Entity_Order sv : OrderArray){
      %>
          <tr>
           <td class="vcl"><%=sv.getIdOrder() %></td>
           <td class="vcl"><%=sv.getIdAccount() %></td>
           <td class="vcl"><%=sv.getName() %></td>
           <td class="vcl"><%=sv.getdate() %></td>
           <td class="vcl"><%=sv.getTotal() %></td>
           
          </tr>
      <%} %>
     </table>
     
     <table align=center border="1" width="70%">
        <br><br><br><caption> <h2>Các sản phẩm có trong hóa đơn</h2> </caption>
        <tr>
           <th>Tên sản phẩm</th>
           <th>Số lượng</th>
           <th>Tổng tiền</th>
          </tr>
     <% 
          ArrayList<Entity_Order_Detail> DetailArray=(ArrayList<Entity_Order_Detail>)request.getAttribute("OrderDetail");   
          for(Entity_Order_Detail sv1 : DetailArray){
      %>
          <tr>
           <td class="vcl"><%=sv1.getPhoneName() %></td>
           <td class="vcl"><%=sv1.getQuantity() %></td>
           <td class="vcl"><%=sv1.getPrice() %></td>
           
          </tr>
      <%} %>
     </table>
</body>
</html>