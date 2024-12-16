<%@page import="java.util.Base64"%>
<%@page import="Model.bean.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    product product = (product)request.getAttribute("product");
    String image = Base64.getEncoder().encodeToString(product.GetImage());
%>
<form action="product_controller?mod=4" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
     <label for="id">Id:</label>
    <input type="text" id="id" name="id" value="<%=product.GetIdProduct() %>" readonly="readonly" required><br>
    
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%=product.GetName() %>" required><br>
    
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="<%=product.GetPrice() %>" required><label>vnđ</label><br>
    
    <img id="previewImage" src="data:image/jpg;base64,<%=image %>" alt=""><br>
    
    <label for="newimg">New Image:</label>
    <input type="file" id="newimg" name="newimg" accept="image/*" onchange="previewFile()"><br>
    
    <label>Status:</label><br>
    <input type="radio" id="status1" name="status" value="1" <%= product.GetStatus() == 1 ? "checked" : "" %> required>
    <label for="status1">In stock</label><br>
    
    <input type="radio" id="status0" name="status" value="0" <%= product.GetStatus() == 0 ? "checked" : "" %> required>
    <label for="status0">Out of stock</label><br>
    
    <input type="submit" value="update">

</form>

<script>
    function previewFile() {
        var preview = document.getElementById('previewImage');
        var fileInput = document.getElementById('newimg');
        var file = fileInput.files[0];
        
        var reader = new FileReader();
        
        reader.onloadend = function () {
            preview.src = reader.result;
        };
        
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "data:image/jpg;base64,<%=image %>";
        }
    }

    function validateForm() {
        // Kiểm tra các trường không được rỗng
        var name = document.getElementById('name').value;
        var price = document.getElementById('price').value;

        if (name.trim() === '' || price.trim() === '') {
            alert('Vui lòng điền đầy đủ thông tin.');
            return false; // Ngăn chặn việc submit form nếu có trường rỗng
        }

        // Các kiểm tra khác nếu cần
        return true; // Cho phép submit form nếu các điều kiện đều đúng
    }
</script>
</body>
</html>
