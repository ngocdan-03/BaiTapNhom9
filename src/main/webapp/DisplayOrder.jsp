<%@page import="Model.bean.Entity_Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
    /* Change the color of the table data/cells */
    .vcl{
       text-align:center;
       
    
    }
    body{
    background-color: #ffffff;  /* Adjust this value to change the background color */
        font-family: Arial, sans-serif;
    }
    /* Change the background color of the table */
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
    .vc2 a{
        display: block;
        text-align:center;
        color: #ec1c24;
    }
</style>
<title>Insert title here</title>
</head>
<body>
     <table align=center border="1" width="70%">
        <caption class="c"> <h1>Danh sách hóa đơn</h1> </caption>
        <tr>
           <th>ID Hóa đơn</th>
           <th>ID Tài khoản</th>
           <th>Người tạo</th>
           <th>Ngày tạo</th>
           <th>Tổng tiền</th>
          </tr>
     <% 
          ArrayList<Entity_Order> OrderArray=(ArrayList<Entity_Order>)request.getAttribute("OrderArray");   
          for(Entity_Order sv : OrderArray){
      %>
          <tr>
           <td class="vc2"><a href="OrderServlet?choose=<%=sv.getIdOrder() %>"><%=sv.getIdOrder() %></td>
           <td class="vcl"><%=sv.getIdAccount() %></td>
           <td class="vcl"><%=sv.getName() %></td>
           <td class="vcl"><%=sv.getdate() %></td>
           <td class="vcl"><%=sv.getTotal() %></td>
           
          </tr>
      <%} %>
     </table>
</body>
</html>