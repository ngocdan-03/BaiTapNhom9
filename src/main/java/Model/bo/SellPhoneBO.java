package Model.bo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.bean.*;
import Model.dao.SellPhoneDAO;

public class SellPhoneBO {
    SellPhoneDAO dao = new SellPhoneDAO();
    public account Login(String user,String pass){   
			return dao.Login(user, pass);

    }
    public void SignUp( String idAccount,String Name ,int Age ,String Address,String SDT,String Username,String Password) {
    	dao.SignUp(idAccount, Name, Age, Address, SDT, Username, Password);
    }
    public inforaccount getInforById(String id) {
    	return dao.getInforById(id);
    	
    }
    public void ChangeInfo(String idAccount,String Name,int Age,String Address,String SDT) {
    	
    	dao.ChangeInfo(idAccount, Name,Age, Address, SDT);
    }
    public void ChangePass(String id,String user,String pass) {
    	dao.ChangePass(id,user,pass);
    }
    public Boolean CheckPass(String Pass) {
    	return dao.CheckPass(Pass);
    }
    public account getAccById(String id){
         return dao.getAccById(id);
    }
}
