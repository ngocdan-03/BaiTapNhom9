<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
 <style>
       img{
        width:150px;
        height:140px;
        position: absolute;
        bottom: -25px;
        animation: phuthuybay 20s linear infinite;       
    }
    @keyframes phuthuybay{
        from{
            transform: translateX(-100%);
        }
        to{
            transform:translateX(1000%);
        }
    }
 </style>
    </head>
    <body style="background-color: aquamarine; overflow:hidden;">
    <img  src="https://cdn.pixabay.com/animation/2023/08/10/21/14/21-14-12-148_512.gif">
    </body>

</html>