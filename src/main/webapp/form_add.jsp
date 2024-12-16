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
<form action="product_controller?mod=6" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" required><label>vnđ</label><br>
    
    <img id="previewImage" src="" alt=""><br>
    
    <label for="newimg">Image:</label>
    <input type="file" id="newimg" name="newimg" accept="image/*" onchange="previewFile()"><br>   
    <input type="submit" value="add">

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
        
        
            reader.readAsDataURL(file);
       
    }

    function validateForm() {
        // Kiểm tra các trường không được rỗng
        var name = document.getElementById('name').value;
        var price = document.getElementById('price').value;
        var fileInput = document.getElementById('newimg');
        var file = fileInput.files[0];

        if (name.trim() === '' || price.trim() === '') {
            alert('Vui lòng điền đầy đủ thông tin.');
            return false; // Ngăn chặn việc submit form nếu có trường rỗng
        }

        if (!file) {
            alert('Vui lòng chọn một hình ảnh.');
            return false; // Ngăn chặn việc submit form nếu không có file được chọn
        }

        // Các kiểm tra khác nếu cần
        return true; // Cho phép submit form nếu các điều kiện đều đúng
    }
</script>
</body>
</html>
