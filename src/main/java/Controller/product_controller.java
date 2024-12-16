package Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;

import Model.bean.account;
import Model.bean.product;
import Model.bo.model_bo;
@MultipartConfig(maxFileSize=16*1024*1024)
@WebServlet("/product_controller")
public class product_controller extends HttpServlet {
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
		// acction view and search
	    case 1:
	    	String Name=null;
	       if(mod2!=null) {
	    	    Name = request.getParameter("tbSearch");
	    	    if("all".equals(Name)) {
	    	    	listproduct = model_bo.BoGetallproduct();
		 	    	   request.setAttribute("listproduct", listproduct);
		 	    	   destination="/crud_product.jsp";
	    	    	
	    	    }else {
	    	    	listproduct = model_bo.Bosearchproduct(Name);
	 	    	   request.setAttribute("listproduct", listproduct);
	 	    	   destination="/crud_product.jsp";
				}
	    	   
	       }else {
	    	    Name = request.getParameter("tb_search");
	    	    if("all".equals(Name)) {
	    	    	listproduct = model_bo.BoGetallproduct();
		 	    	   request.setAttribute("listproduct", listproduct);
		 	    	   destination="/customer_interface_product.jsp";
	    	    }else {
	    	    	listproduct = model_bo.Bosearchproduct(Name);
	 	    	   request.setAttribute("listproduct", listproduct);
	 	    	   destination="/customer_interface_product.jsp";
				}
	    	   
		}
	       
	        break;
	        // acction view detail_peoduct
	    case 2:
	    	int id = Integer.parseInt(request.getParameter("id"));
	        product product = model_bo.Bogetproductbyid(id);
	        request.setAttribute("product", product);
	    	 destination="/detail_product.jsp";
	        break;
	        //acction update 
        case 3:
        	int _id = Integer.parseInt(request.getParameter("id"));
	        product _product = model_bo.Bogetproductbyid(_id);
	        request.setAttribute("product", _product);
	    	 destination="/form_update.jsp";
	        break;
        case 4:
        	int idToUpdate = Integer.parseInt(request.getParameter("id"));
        	String nameToUpdate = request.getParameter("name");
        	int priceToUpdate = Integer.parseInt(request.getParameter("price"));
        	byte statusToUpdate = Byte.parseByte(request.getParameter("status")); 

        	// Xử lý file ảnh
        	Part filePart = request.getPart("newimg");

        	// Kiểm tra xem filePart có tồn tại không
        	if (filePart != null && filePart.getSize() > 0) {
        	    // Nếu có file, chuyển đổi InputStream của filePart thành mảng byte
        	    InputStream inputStream = filePart.getInputStream();
        	    ByteArrayOutputStream image_data = new ByteArrayOutputStream();
        	    byte[] buffer = new byte[1024];
        	    int byteread;

        	    while ((byteread = inputStream.read(buffer)) != -1) {
        	        image_data.write(buffer, 0, byteread);
        	    }

        	    byte[] imageBytes = image_data.toByteArray();

        	    // Tạo đối tượng product để cập nhật
        	    product updatedProduct = new product(idToUpdate, nameToUpdate, priceToUpdate, imageBytes, statusToUpdate);

        	    // Gọi hàm cập nhật trong model_bo
        	    boolean success = model_bo.BoUpdateProduct(updatedProduct);

        	    if (success) {
        	    	listproduct = model_bo.BoGetallproduct();
		 	    	   request.setAttribute("listproduct", listproduct);
		 	    	   destination="/crud_product.jsp";
        	    } 
        	} else {
        	    product updatedProduct = new product(idToUpdate, nameToUpdate, priceToUpdate, null, statusToUpdate);
        	    boolean success = model_bo.BoUpdateProductnoimg(updatedProduct);

        	    if (success) {
        	    	listproduct = model_bo.BoGetallproduct();
		 	    	   request.setAttribute("listproduct", listproduct);
		 	    	   destination="/crud_product.jsp";
        	    } 
        	}

        	        
            break;
        case 5:
        	destination="/form_add.jsp";
        	break;
        case 6:
        	String nameToUpdate_ = request.getParameter("name");
        	int priceToUpdate_ = Integer.parseInt(request.getParameter("price"));
        	byte statusToUpdate_ = 1; 

        	// Xử lý file ảnh
        	Part filePart_ = request.getPart("newimg");

        	// Kiểm tra xem filePart có tồn tại không
        	
        	    // Nếu có file, chuyển đổi InputStream của filePart thành mảng byte
        	    InputStream inputStream = filePart_.getInputStream();
        	    ByteArrayOutputStream image_data = new ByteArrayOutputStream();
        	    byte[] buffer = new byte[1024];
        	    int byteread;

        	    while ((byteread = inputStream.read(buffer)) != -1) {
        	        image_data.write(buffer, 0, byteread);
        	    }

        	    byte[] imageBytes = image_data.toByteArray();

        	    // Gọi hàm add trong model_bo
        	    boolean success = model_bo.BoAddProduct(nameToUpdate_, priceToUpdate_, imageBytes, statusToUpdate_);

        	    if (success) {
        	    	listproduct = model_bo.BoGetallproduct();
		 	    	   request.setAttribute("listproduct", listproduct);
		 	    	   destination="/crud_product.jsp";
        	    } 
        

        	break;
        case 7:
	  listproduct = model_bo.BoGetallproduct();
	  for(product item : listproduct) {
		  int id_delete = item.GetIdProduct();
		  if(request.getParameter(Integer.toString(id_delete))!=null) {
			  
			  model_bo.BoDeleteProductbyId(id_delete);
			  
		  }
	  }
	  listproduct = model_bo.BoGetallproduct();
	   request.setAttribute("listproduct", listproduct);
	   destination="/crud_product.jsp";
	break;
	    default:
	       	}
		 rd = getServletContext().getRequestDispatcher(destination);
	     rd.forward(request, response);
		
		
	}
}
