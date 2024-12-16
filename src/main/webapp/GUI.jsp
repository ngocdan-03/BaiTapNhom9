<%@page import="Model.bean.account"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang chủ</title>
</head>
  <%account ac =(account)request.getAttribute("account");%>
    <frameset Border = 0 Rows="150,*">
        <frame name = T1 src="./T1.jsp?notification=<%=(String)request.getAttribute("notification")%>&PQ=<%=ac.isPQ()%>">
                <frame name =Personal_Infor src="Personal_Infor.jsp"> 
    </frameset>
</html>