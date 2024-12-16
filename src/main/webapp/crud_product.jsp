<%@page import="Model.bean.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.bean.account"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <style>
    table {
        width: 100%;
        margin-top: 50px; /* Khoảng cách phía trên */
        margin-bottom: 50px; /* Khoảng cách phía dưới */
    }

    th, td {
        padding: 15px;
        text-align: center;
    }

    th {
        font-weight: bold;
        color: #007bff; /* Màu xanh */
        background-color: #f2f2f2; /* Màu nền xám nhạt */
    }

    img {
        display: block;
        margin: 0 auto;
        object-fit: cover; /* Đảm bảo hình ảnh không bị biến đổi tỷ lệ */
    }

    .icon-container {
        display: flex;
        justify-content: space-around;
    }
</style>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" >
</head>

<title>Insert title here</title>
</head>
<body>
<%
account user = (account)request.getAttribute("user");
ArrayList<product> listproduct = (ArrayList<product>)request.getAttribute("listproduct");
%>
<form action="product_controller?mod=1&mod2=1" method="post">
<input type="text" name="tbSearch" placeholder="input name product" size="15"/>
<input type="submit" value="search">
</form>
<button><a href="./product_controller?mod=5">add</a></button><br>
<form action="product_controller?mod=7"method="post">
<table border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Image</th>
            <th>Price</th>
            <th>Status</th>
            <th>Feature</th>
        </tr>
    </thead>
    <tbody>
        <%
            for(int i = 0; i < listproduct.size(); i++) {
                product currentProduct = listproduct.get(i);
                String encodedImage = Base64.getEncoder().encodeToString(currentProduct.GetImage());
        %>
        <tr>
            <td><%= currentProduct.GetName() %></td>
            <td><img src="data:image/jpg;base64,<%= encodedImage %>" alt="<%= currentProduct.GetName() %>" width="70" height="70"></td>
            <td><%= currentProduct.GetPrice() %>vnđ</td>
            <td><%= currentProduct.GetStatus() == 1 ? "In stock" : "Out of stock" %></td>
            <td>
               <a href="./product_controller?mod=3&id=<%=currentProduct.GetIdProduct()%>"><i class="fa-solid fa-file-pen"></i></a>
               <input type="checkbox" name="<%=currentProduct.GetIdProduct() %>" value="<%=currentProduct.GetIdProduct() %>">
            </td>

            
        </tr>
        <% } %>
    </tbody>
</table>
<input type="submit" value="delete">
</form>

</body>
</html>