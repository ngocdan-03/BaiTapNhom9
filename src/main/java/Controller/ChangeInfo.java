package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import Model.bo.*;
@WebServlet("/QLChangeInfo")
public class ChangeInfo extends HttpServlet{
   protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
	   doPost(request,response);
   }
   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	   request.setCharacterEncoding("UTF-8");
	  String idAccount = request.getParameter("idAccount");
	  String Name = request.getParameter("Name");
	  String Age = request.getParameter("Age");
	  String Address = request.getParameter("Address");
	  String SDT = request.getParameter("SDT");
	  String Username=request.getParameter("Username");	 
	   String OutPassword=request.getParameter("OutPassword");
	   String NewPassword=request.getParameter("NewPassword");
	   String NewPasswordAgain=request.getParameter("NewPasswordAgain");
	  
	  HttpSession session = request.getSession();
	   SellPhoneBO bo =new SellPhoneBO();
	   if(idAccount != null && Name != null && Age != null && Address != null && SDT != null) {
	   if(!idAccount.equals("") && !Name.equals("") && !Age.equals("") && !Address.equals("") && !SDT.equals("")) {	
	    	  bo.ChangeInfo(idAccount, Name, Integer.parseInt(Age), Address, SDT); 
	    	  session.setAttribute("info",bo.getInforById(idAccount));
	    	  String notification="Thay đổi thông tin thành công!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
	    	  rd.forward(request, response);  
	   }else {
		      String notification="Hãy nhập đầy đủ thông tin!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
	    	  rd.forward(request, response);    
	   }
	   }else if(bo.CheckPass(OutPassword) && !Username.equals("") && !OutPassword.equals("") && !NewPasswordAgain.equals("") && !NewPassword.equals("") ){
		    if(NewPassword.equals(NewPasswordAgain)) {
		   bo.ChangePass(idAccount, Username, OutPassword);
		      String notification="Thay đổi thông tin đăng nhập thành công!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
	    	  rd.forward(request, response); 
	    	  
		    }else {
		    	 String notification="Mật khẩu mới và mật khẩu mới nhập lại không giống nhau!!!";
		    	  request.setAttribute("notification", notification);
		    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
		    	  rd.forward(request, response); 
		    	
		    }
	   }else if(!bo.CheckPass(OutPassword) && Username !="" && OutPassword !="" && NewPasswordAgain !="" && NewPassword !=""){
		   String notification="Mật khẩu cũ không đúng!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
	    	  rd.forward(request, response); 
	   }else {
		      String notification="Hãy nhập đầy đủ thông tin!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal_Infor.jsp");
	    	  rd.forward(request, response);    
	   }
   }
}
