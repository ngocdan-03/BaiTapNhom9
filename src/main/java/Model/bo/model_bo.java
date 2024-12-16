package Model.bo;

import java.util.ArrayList;

import Model.bean.product;
import Model.dao.model_dao;

public class model_bo {
model_dao model_dao = new model_dao();

public ArrayList<product> BoGetallproduct(){
	return model_dao.DaoGetallproduct();
}
public ArrayList<product> Bosearchproduct(String Name){
	return model_dao.Daosearchproduct(Name);
}
public product Bogetproductbyid(int id) {
	return model_dao.Daogetproductbyid(id);
}
public boolean BoUpdateProduct(product updatedProduct) {
	return model_dao.DaoUpdateProduct(updatedProduct);
}
public boolean BoUpdateProductnoimg(product updatedProduct) {
	return model_dao.DaoUpdateProductnoimg(updatedProduct);
}
public boolean BoAddProduct(String name,int price,byte[] img,byte status) {
	return model_dao.DaoAddProduct(name,price,img,status);
}
public boolean BoDeleteProductbyId(int id) {
	return model_dao.DaoDeleteProductById(id);
}
}
