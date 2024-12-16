package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import Model.bean.*;
import Model.bo.*;
@WebServlet("/QLLogin")
public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,
		       HttpServletResponse response) throws ServletException,IOException{
	  doPost(request,response);
}
	protected void doPost(HttpServletRequest request,
		       HttpServletResponse response) throws ServletException,IOException{
	      String user=request.getParameter("user");
	      String pass=request.getParameter("pass");
	//      String mod = request.getParameter("mod");
	      SellPhoneBO bo =new SellPhoneBO();
	      model_bo model_bo = new model_bo();
			ArrayList<product> listproduct = new ArrayList<>();
			String destination=null;
	      account ac=bo.Login(user, pass);    	     
	      if(user != null && pass != null) {
	      if(user == "" || pass == "") {
	    	  String notification="Hãy nhập đầy đủ thông tin!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
	    	  rd.forward(request, response);      
	      }else if(ac!=null) {	    	  
	    	  HttpSession session = request.getSession();
	    	  String notification="Đăng nhập thành công!!!";
	    	  request.setAttribute("notification", notification);
	    	  
	    	  
	    	  inforaccount info=bo.getInforById(ac.getIdAccount());
	    	  session.setAttribute("info", info);
	    	  account acc = bo.getAccById(info.getIdAccount());
	    	  request.setAttribute("account",acc);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/GUI.jsp");
	    	  rd.forward(request, response);
	      }else {
	    	  String notification="Đăng nhập không thành công!!!";
	    	  request.setAttribute("notification", notification);
	    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
	    	  rd.forward(request, response);
	      }
	      }
	    
	      
}
}
