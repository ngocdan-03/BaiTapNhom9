package Model.bean;

import java.sql.Timestamp;


public class Entity_Order {
private int IdOrder;
private String IdAccount;
private String Name;
private Timestamp date;
private int Total;


public int getIdOrder() {
	return IdOrder;
}
public void setIdOrder(int IdOrder) {
	this.IdOrder = IdOrder;
}

public String getIdAccount() {
	return IdAccount;
}
public void setIdAccount(String IdAccount) {
	this.IdAccount = IdAccount;
}

public Timestamp getdate() {
	return date;
}
public void setdate(Timestamp date) {
	this.date = date;
}

public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}

public int getTotal() {
	return Total;
}
public void setTotal(int Total) {
	this.Total = Total;
}

}
