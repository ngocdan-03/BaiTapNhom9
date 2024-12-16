package Model.dao;
import Model.bean.Entity_Order;
import Model.bean.Entity_Order_Detail;
import Model.bean.Entity_Cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO_ORDER {
  public Connection getConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3307/btnhom9";
		  Connection conn=DriverManager.getConnection(url, "root", "");
		  return conn;
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	  return null;
	  
  }
  public ArrayList<Entity_Order> getAllOrder(){
	  Connection conn = getConnection();
	  ArrayList<Entity_Order> OrderArray = new ArrayList<Entity_Order>();
	  try {
		Statement st = conn.createStatement();
		String query="SELECT `order`.IdOrder, `order`.IdAccount, inforaccount.Name, `order`.Date, `order`.Total FROM `order`, inforaccount WHERE `order`.`IdAccount`=inforaccount.IdAccount";
		ResultSet kq = st.executeQuery(query);
		 while(kq.next()) {
			 Entity_Order order = new Entity_Order();
			 order.setIdOrder(kq.getInt(1));
			 order.setIdAccount(kq.getString(2));
			 order.setName(kq.getString(3));
			 order.setdate(kq.getTimestamp(4));
			 order.setTotal(kq.getInt(5));
			 OrderArray.add(order);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return OrderArray;
  }
  public ArrayList<Entity_Order> getOrderHistory(String idX){
	  Connection conn = getConnection();
	  ArrayList<Entity_Order> OrderArray = new ArrayList<Entity_Order>();
	  try {
		Statement st = conn.createStatement();
		String query="SELECT `order`.IdOrder, `order`.IdAccount, inforaccount.Name, `order`.Date, `order`.Total FROM `order`, inforaccount WHERE `order`.`IdAccount`=inforaccount.IdAccount AND `order`.IdAccount='" + idX +"'";
		ResultSet kq = st.executeQuery(query);
		 while(kq.next()) {
			 Entity_Order order = new Entity_Order();
			 order.setIdOrder(kq.getInt(1));
			 order.setIdAccount(kq.getString(2));
			 order.setName(kq.getString(3));
			 order.setdate(kq.getTimestamp(4));
			 order.setTotal(kq.getInt(5));
			 OrderArray.add(order);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return OrderArray;
  }
  
  
  public ArrayList<Entity_Order> getAllOrder2(String idX){
	  int id = Integer.parseInt(idX);
	  Connection conn = getConnection();
	  ArrayList<Entity_Order> OrderArray = new ArrayList<Entity_Order>();
	  try {
		Statement st = conn.createStatement();
		String query="SELECT `order`.IdOrder, `order`.IdAccount, inforaccount.Name, `order`.Date, `order`.Total FROM `order`, inforaccount WHERE `order`.`IdAccount`=inforaccount.IdAccount AND `order`.IdOrder=" + id;
		ResultSet kq=st.executeQuery(query);
		 while(kq.next()) {
			 Entity_Order order = new Entity_Order();
			 order.setIdOrder(kq.getInt(1));
			 order.setIdAccount(kq.getString(2));
			 order.setName(kq.getString(3));
			 order.setdate(kq.getTimestamp(4));
			 order.setTotal(kq.getInt(5));
			 OrderArray.add(order);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return OrderArray;
  }
  
  public ArrayList<Entity_Order_Detail> getOrderDetail(String idX) {
	  int id = Integer.parseInt(idX);
	  Connection conn = getConnection();
	  ArrayList<Entity_Order_Detail> order = new ArrayList<Entity_Order_Detail>();
	  try {
			Statement st = conn.createStatement();
			String query="SELECT p.Name, o.Quantity, o.Price FROM orderdetail AS o, product AS p WHERE o.IdProduct=p.IdProduct AND o.IdOrder=" + id;
			ResultSet kq = st.executeQuery(query);
			 while(kq.next()) {
				 Entity_Order_Detail detail = new Entity_Order_Detail();
				 detail.setPhoneName(kq.getString(1));
				 detail.setQuantity(kq.getInt(2));
				 detail.setPrice(kq.getInt(3));
				 order.add(detail);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  
	  return order;
  } 
  
  public void addToCartTable(int quant, int id) {
	  Connection conn = getConnection();
	  try {
			Statement st = conn.createStatement();
			//id chính là idproduct để thêm vào giỏ hàng
			
			//kiem tra xem san pham da co trong cart hay chua
			String query = "SELECT COUNT(*) FROM cart WHERE IdProduct=" + id;
			ResultSet check = st.executeQuery(query);
			while (check.next()) {
			    int count = check.getInt(1);
			    if (count > 0) {
			    	//da co trong cart
			    	int price;
					int quantity = quant;
					//lay price
					String query1 = "SELECT Price FROM product WHERE IdProduct=" + id;
					ResultSet kq = st.executeQuery(query1);
					 while(kq.next()) {
						 price = kq.getInt(1);
						 int total = price * quantity;
						 // cap nhat so luong va tong tien vao bang cart
						 String query2 = "UPDATE cart SET Quantity=" + quantity + ", " + "Total=" + total + " WHERE IdProduct=" + id;
						 st.executeUpdate(query2);
					 }
			        
			    } else {
			    	//chua co trong cart
			    	int price;
					int quantity = quant;
					//lay price
					String query1 = "SELECT Price FROM product WHERE IdProduct=" + id;
					ResultSet kq = st.executeQuery(query1);
					 while(kq.next()) {
						 price = kq.getInt(1);
						 int total = price * quantity;
						 // them vao bang cart
						 String query2 = "INSERT INTO cart (IdProduct, Price, Quantity, Total) VALUES (" + id + ", " + price + ", " + quantity + ", " + total + ")";
						 st.executeUpdate(query2);
					 }
			    }
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
  }
  
  public ArrayList<Entity_Cart> viewCart() {
	  Connection conn = getConnection();
	  ArrayList<Entity_Cart> CartArray = new ArrayList<Entity_Cart>();
	  try {
		Statement st = conn.createStatement();
		String query = "SELECT p.Name, c.Price, c.Quantity, c.Total FROM cart as c, product as p WHERE c.IdProduct=p.IdProduct";
		ResultSet kq = st.executeQuery(query);
		 while(kq.next()) {
			 Entity_Cart cart = new Entity_Cart();
			 cart.setName(kq.getString(1));
			 cart.setPrice(kq.getInt(2));
			 cart.setQuantity(kq.getInt(3));
			 cart.setTotal(kq.getInt(4));
			 CartArray.add(cart);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return CartArray;
  }
  
  public void pay(String IdAccount) {
	    Connection conn = getConnection();
	    //String IdAccount = "user01";
	    java.sql.Timestamp Dateee = new java.sql.Timestamp(System.currentTimeMillis());
	    int Total = 0;
	    int IdOrder = 0;
	    try {
	        Statement st = conn.createStatement();
	        ResultSet kq = st.executeQuery("SELECT SUM(Total) FROM cart");
	        while(kq.next()) {
	            Total = kq.getInt(1);
	        }
	        //them vao bang order
	        String query2 = "INSERT INTO `order` (IdAccount, Date, Total) VALUES (?, ?, ?)";
	        PreparedStatement pstmt2 = conn.prepareStatement(query2);
	        pstmt2.setString(1, IdAccount);
	        pstmt2.setString(2, Dateee.toString());
	        pstmt2.setInt(3, Total);
	        pstmt2.executeUpdate();
	        //lay ra idorder moi nhat
	        String queryX = "SELECT IdOrder FROM `order` ORDER BY IdOrder DESC LIMIT 1";
	        ResultSet kqX = st.executeQuery(queryX);
	        while(kqX.next()) {
	        	 IdOrder = kqX.getInt(1);
	        }
	        //them vao bang orderdetail
	        ResultSet kq2 = st.executeQuery("SELECT IdProduct, Quantity, Total FROM cart");
	        while(kq2.next()) {
	            String query4 = "INSERT INTO orderdetail (IdProduct, IdOrder, Quantity, Price) VALUES (?, ?, ?, ?)";
	            PreparedStatement pstmt4 = conn.prepareStatement(query4);
	            pstmt4.setInt(1, kq2.getInt(1));
	            pstmt4.setInt(2, IdOrder);
	            pstmt4.setInt(3, kq2.getInt(2));
	            pstmt4.setInt(4, kq2.getInt(3));
	            pstmt4.executeUpdate();
	        }
	        //xoa het du lieu bang cart khi da xong viec
	        st.executeUpdate("DELETE FROM cart");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
  public void nopay() {
	  Connection conn = getConnection();
	  try {
		  Statement st = conn.createStatement();
	      st.executeUpdate("DELETE FROM cart");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
  }

}
