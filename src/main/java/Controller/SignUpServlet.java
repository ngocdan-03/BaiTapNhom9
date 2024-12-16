package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpServlet;
import Model.bean.*;
import Model.bo.*;
@WebServlet("/QLSignUp")
public class SignUpServlet extends HttpServlet{
   protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
	   doPost(request,response);
   }
   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	   request.setCharacterEncoding("UTF-8");
	   String idAccount=request.getParameter("idAccount");
	   String Name=request.getParameter("Name");
	   String Age=request.getParameter("Age");
	   String Address=request.getParameter("Address");
	   String SDT=request.getParameter("SDT");
	   String Username=request.getParameter("Username");
	   String Password=request.getParameter("Password");
	   SellPhoneBO bo =new SellPhoneBO();
	   if(idAccount == "" || Name == "" || Age == "" || Address == "" || SDT == "" || Username == "" || Password == "") {
		   String notification="Hãy nhập đầy đủ thông tin!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
	    	  rd.forward(request, response);    
	   }else {
	bo.SignUp(idAccount, Name, Integer.parseInt(Age), Address, SDT, Username, Password);
	  String notification="Đăng kí thành công!!!";
	  request.setAttribute("notification", notification);
	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
	  rd.forward(request, response);    
	   }
   }
}
