package Controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Model.bean.account;
import Model.bean.inforaccount;
import Model.bean.product;
import Model.bo.SellPhoneBO;
import Model.bo.model_bo;
@WebServlet("/controller")
public class Controller_main extends HttpServlet {
		private static final long serialVersionUID=1L;
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
		}
		protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			int mod = Integer.parseInt(request.getParameter("mod"));
			 String mod2 = (String)request.getParameter("mod2");
			model_bo model_bo = new model_bo();
			ArrayList<product> listproduct = new ArrayList<>();
			String destination=null;
			RequestDispatcher rd;

			switch (mod) {
		    case 1:
		    	HttpSession session = request.getSession();
		  inforaccount info = (inforaccount)session.getAttribute("info");
		  SellPhoneBO bo = new SellPhoneBO();
		  System.out.println("vcl");
		  System.out.println(info.getIdAccount());
		  account user=bo.getAccById(info.getIdAccount());
		       if(user!=null) {
		    	   request.setAttribute("user", user);
		    	   listproduct=model_bo.BoGetallproduct();
		    	   request.setAttribute("listproduct", listproduct);
		    	   if(mod2!=null) {
		    		   destination="/crud_product.jsp";
		    	   }else {
		    		   destination="/customer_interface_product.jsp";
		    	   }
		    	   
		       }
		        break;
		    case 2:
		    	
		       
		    	 
		        break;
	        case 3:
	        	
		        break;
	        case 4:
	        	
	        	break;
	        case 5:
	        	
	        	break;
		    default:
		       	}
			 rd = getServletContext().getRequestDispatcher(destination);
		     rd.forward(request, response);
			
			
		}
	}


