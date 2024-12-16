package Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.bean.*;
public class SellPhoneDAO {
  public Connection getConnection() {
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		 String url="jdbc:mysql://localhost:3307/btnhom9";
		  Connection conn=DriverManager.getConnection(url,"root","");
		  return conn;
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return null;
  }
  public account Login(String user,String pass){ 
	  account ac =null;
	try {
		 Connection conn=getConnection();
		  String url="SELECT * FROM account WHERE Username=? AND Password=?";
		  PreparedStatement pst = conn.prepareStatement(url);
		  pst.setString(1, user);
		  pst.setString(2,pass);
		  ResultSet kq = pst.executeQuery();		 
		  while(kq.next()) {
			  ac = new account();
			  ac.setIdAccount(kq.getString(1));
			  ac.setUsername(kq.getString(2));
			  ac.setPassword(kq.getString(3));
			  ac.setPQ(kq.getBoolean(4));
			  ac.setStatus(kq.getBoolean(5));			  
		  }
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
	  return ac;
  }
  public void SignUp( String idAccount,String Name ,int Age ,String Address,String SDT,String Username,String Password) {
	  PreparedStatement pst;
	  String url;
	  try {
			 Connection conn=getConnection();
			   url="INSERT INTO account(idAccount,Username,Password,PQ,Status) VALUES (?,?,?,?,?)";
			   pst = conn.prepareStatement(url);
			  pst.setString(1, idAccount);
			  pst.setString(2,Username);
			  pst.setString(3,Password);
			  pst.setInt(4,0);
			  pst.setInt(5,1);			
			  pst.executeUpdate();		
			  url="INSERT INTO inforaccount(IdAccount,Name,Age,Address,SDT) VALUES (?,?,?,?,?)";
			   pst = conn.prepareStatement(url);
			   pst.setString(1, idAccount);
			   pst.setString(2, Name);
			   pst.setInt(3, Age);
			   pst.setString(4, Address);
			   pst.setString(5, SDT);
			   pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
  }
  public inforaccount getInforById(String id){
	  Connection conn=getConnection();
	  inforaccount infor = null;
	  try {
		  
	  String query="SELECT * FROM inforaccount WHERE IdAccount=?";
	  PreparedStatement pst = conn.prepareStatement(query);
	  pst.setString(1, id);
	  ResultSet kq = pst.executeQuery();
	  while(kq.next()) {
		  infor = new inforaccount();
		  infor.setIdAccount(id);
		  infor.setName(kq.getString(2));
		  infor.setAge(kq.getInt(3));
		  infor.setAddress(kq.getString(4));
		  infor.setSDT(kq.getString(5));
	  }
	  return infor;
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return infor;
  }
  public account getAccById(String id){
	  Connection conn=getConnection();
	  account acc = null;
	  try {
		  
	  String query="SELECT * FROM account WHERE IdAccount=?";
	  PreparedStatement pst = conn.prepareStatement(query);
	  pst.setString(1, id);
	  ResultSet kq = pst.executeQuery();
	  while(kq.next()) {
		  acc = new account();
		  acc.setIdAccount(id);
		  acc.setUsername(kq.getString(2));
		  acc.setPassword(kq.getString(3));
		  acc.setPQ(kq.getBoolean(4));
		  acc.setStatus(kq.getBoolean(5));
	  }
	  return acc;
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return acc;
  }
  public void ChangeInfo(String idAccount,String Name,int Age,String Address,String SDT) {
	  Connection conn=getConnection();
	  try {
		  
	  String query="UPDATE inforaccount SET Name=?,Age=?,Address=?,SDT=? WHERE IdAccount=?";
	  PreparedStatement pst = conn.prepareStatement(query);	  
	  pst.setString(1,Name);
	  pst.setInt(2,Age);
	  pst.setString(3,Address);
	  pst.setString(4,SDT);
	  pst.setString(5,idAccount);
	  pst.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  	
  }
  public void ChangePass(String id,String user,String pass) {
	  Connection conn=getConnection();
	  try {
		  
	  String query="UPDATE account SET Username=?,Password=? WHERE idAccount=?";
	  PreparedStatement pst = conn.prepareStatement(query);	  
	  pst.setString(1,user);
	  pst.setString(2,pass);
	  pst.setString(3,id);
	  pst.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  public Boolean CheckPass(String Pass) {
	  Connection conn=getConnection();
	  try {
		  
	  String query="SELECT * FROM account WHERE Password=?";
	  PreparedStatement pst = conn.prepareStatement(query);	  
	  pst.setString(1,Pass);
	  ResultSet kq=pst.executeQuery();
	  int rowCount = 0;
	  while (kq.next()) {
	      rowCount++;
	  }
	  if(rowCount == 1) return true;
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }
}
