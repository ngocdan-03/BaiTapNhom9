<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

      <h1>Chức năng</h1>
         
  
      <form action="OrderServlet" method="GET">
      <input type="hidden" name="choose" value="viewOrders" />
      <input type="submit" value="xem danh sách hóa đơn" /><br><br>
      </form>
      <form action="OrderServlet" method="GET">
      <input type="hidden" name="choose" value="viewOrdersHistory" />
      <input type="hidden" name="yourUserID" value="user02" />  <!-- Add this line -->
      <input type="submit" value="xem lịch sử mua hàng" /><br><br>
      </form>
      <form action="OrderServlet" method="POST">
      <input type="text" id="textfield" name="textfield" />
      <input type="hidden" name="choose" value="addToCart" />
      <input type="hidden" name="yourNumber" value="1" />  <!-- Add this line -->
      <input type="submit" value="thêm vào giỏ hàng" /><br><br>
      </form>
      </form>

      
</body>
</html>