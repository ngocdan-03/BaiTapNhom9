package Model.bo;

import java.util.ArrayList;

import Model.bean.Entity_Cart;
import Model.bean.Entity_Order;
import Model.bean.Entity_Order_Detail;
import Model.dao.DAO_ORDER;
public class BO_ORDER {
      DAO_ORDER OrderDAO = new DAO_ORDER();
      public ArrayList<Entity_Order> getAllOrder() {
    	 return OrderDAO.getAllOrder();
      }
      public ArrayList<Entity_Order> getOrderHistory(String idX) {
    	  return OrderDAO.getOrderHistory(idX);
      }
      
      public ArrayList<Entity_Order> getAllOrder2(String id) {
     	 return OrderDAO.getAllOrder2(id);
       }
      
      public ArrayList<Entity_Order_Detail> getOrderDetail(String id) {
      	 return OrderDAO.getOrderDetail(id);
        }
      public void addToCartTable(int quant, int id) {
    	  OrderDAO.addToCartTable(quant, id);
      }
      
      public ArrayList<Entity_Cart> viewCart() {
    	  return OrderDAO.viewCart();
      }
      
      public void pay(String IdAccount) {
    	  OrderDAO.pay(IdAccount);
      }
      
      public void nopay() {
    	  OrderDAO.nopay();
      }
      
}
