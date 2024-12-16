package Model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.bean.product;

public class model_dao {
	private Connection conn;
	public Connection connect()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/btnhom9", "root", "");
	        return conn;	
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void close() {
		try {
			if(conn!=null&&conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<product> DaoGetallproduct(){
		ArrayList<product> listproduct = new ArrayList();
		try {
			Connection conn = connect();
			if(conn!=null) {
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery("select * from product where status='1'");
			while(resultset.next()) {
				int idproduct = resultset.getInt("IdProduct");
				String name = resultset.getString("Name");
				int price = resultset.getInt("Price");
				byte[] image = resultset.getBytes("Image");
				byte status = resultset.getByte("Status");
				product product = new product(idproduct, name, price, image, status);
				listproduct.add(product);
			}return listproduct ;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
		
	}
	public ArrayList<product> Daosearchproduct(String Name) {
	    ArrayList<product> listproduct = new ArrayList();
	    try {
	        Connection conn = connect();
	        Statement statement = conn.createStatement();
	        String sql = "SELECT * FROM product WHERE Name LIKE ?";
	        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
	            preparedStatement.setString(1, "%" + Name + "%");

	            ResultSet resultset = preparedStatement.executeQuery();
	            while (resultset.next()) {
	            	int idproduct = resultset.getInt("IdProduct");
					String name = resultset.getString("Name");
					int price = resultset.getInt("Price");
					byte[] image = resultset.getBytes("Image");
					byte status = resultset.getByte("Status");
					product product = new product(idproduct, name, price, image, status);
					listproduct.add(product);
	            }
	            return listproduct;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return null;
	}
	public product Daogetproductbyid(int id) {
		ArrayList<product> listproduct = DaoGetallproduct();
		for(product item : listproduct) {
			if(item.GetIdProduct()==id) {
				return item;
			}
		}
		return null;
	}
	public boolean DaoUpdateProduct(product updatedProduct) {
	    try {
	        Connection conn = connect();
	        if (conn != null) {
	            String query = "UPDATE product SET Name = ?, Price = ?, Image = ?, Status = ? WHERE IdProduct = ?";
	            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	                preparedStatement.setString(1, updatedProduct.GetName());
	                preparedStatement.setInt(2, updatedProduct.GetPrice());
	                preparedStatement.setBytes(3, updatedProduct.GetImage());
	                preparedStatement.setByte(4, updatedProduct.GetStatus());
	                preparedStatement.setInt(5, updatedProduct.GetIdProduct());

	                int rowsAffected = preparedStatement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return false;
	}
	public boolean DaoUpdateProductnoimg(product updatedProduct) {
	    try {
	        Connection conn = connect();
	        if (conn != null) {
	            String query = "UPDATE product SET Name = ?, Price = ?,Status = ? WHERE IdProduct = ?";
	            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	                preparedStatement.setString(1, updatedProduct.GetName());
	                preparedStatement.setInt(2, updatedProduct.GetPrice());
	                preparedStatement.setByte(3, updatedProduct.GetStatus());
	                preparedStatement.setInt(4, updatedProduct.GetIdProduct());

	                int rowsAffected = preparedStatement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return false;
	}
	public boolean DaoAddProduct(String name,int price,byte[] img,byte status) {
	    try {
	        Connection conn = connect();
	        if (conn != null) {
	            String query = "INSERT INTO product (Name, Price, Image, Status) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	                preparedStatement.setString(1, name);
	                preparedStatement.setInt(2, price);
	                preparedStatement.setBytes(3,img);
	                preparedStatement.setByte(4, status);

	                int rowsAffected = preparedStatement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return false;
	}
	public boolean DaoDeleteProductById(int productId) {
	    try {
	        Connection conn = connect();
	        if (conn != null) {
	            String query = "UPDATE product SET Status = 0 WHERE IdProduct = ?";
	            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	                preparedStatement.setInt(1, productId);

	                int rowsAffected = preparedStatement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return false;
	}


	
}
