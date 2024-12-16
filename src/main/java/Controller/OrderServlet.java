package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.bean.inforaccount;
import Model.bo.BO_ORDER;
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	   doPost(request,response);
   }
   public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	   String choose = request.getParameter("choose");	  
	   if(choose.equals("viewOrders")) {
		  BO_ORDER DisplayBO = new BO_ORDER();
		  request.setAttribute("OrderArray", DisplayBO.getAllOrder());
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/DisplayOrder.jsp");
		  rd.forward(request, response);
	   }
	   //xem lich su mua hang
	   else if(choose.equals("viewOrdersHistory")) {
		   HttpSession session = request.getSession();
		   inforaccount info = (inforaccount) session.getAttribute("info");
		   
		   BO_ORDER DisplayBO = new BO_ORDER();
		   request.setAttribute("OrderHistory", DisplayBO.getOrderHistory(info.getIdAccount()));
		   RequestDispatcher rd = getServletContext().getRequestDispatcher("/DisplayOrderHistory.jsp");
	       rd.forward(request, response);
	   }
	   //them vao gio hang
	   else if(choose.equals("addToCart")) {
		   String tf = request.getParameter("textfield");
		   String num = request.getParameter("yourNumber");
		   int quant = Integer.parseInt(tf);
		   int id = Integer.parseInt(num);
		   BO_ORDER ExecuteOnly = new BO_ORDER();
		   ExecuteOnly.addToCartTable(quant, id);
		   
		   // Now you have the text field value, you can process it.
	   }
	   
	   //xem gio hang
	   else if(choose.equals("viewCart")) {
		   BO_ORDER DisplayBO = new BO_ORDER();
		   request.setAttribute("CartArray", DisplayBO.viewCart());
		   RequestDispatcher rd = getServletContext().getRequestDispatcher("/DisplayCart.jsp");
		   rd.forward(request, response);
		   
		   // Now you have the text field value, you can process it.
	   }
	   //thanh toan
	   else if(choose.equals("pay")) {
		   HttpSession session = request.getSession();
		   inforaccount info = (inforaccount) session.getAttribute("info");
		   String id = info.getIdAccount();
		   BO_ORDER PayBO = new BO_ORDER();
		   PayBO.pay(id);
	   }
	   //huy thanh toan
	   else if(choose.equals("NOpay")) {
		   BO_ORDER NoPayBO = new BO_ORDER();
		   NoPayBO.nopay();
	   }
	   //Chi tiet hoa don
	   else {
		   BO_ORDER DisplayBO = new BO_ORDER();
			  request.setAttribute("OrderArray2", DisplayBO.getAllOrder2(choose));
			  request.setAttribute("OrderDetail", DisplayBO.getOrderDetail(choose));
			  RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/OrderDetail.jsp");
			  rd2.forward(request, response);
	   }
   }
}
