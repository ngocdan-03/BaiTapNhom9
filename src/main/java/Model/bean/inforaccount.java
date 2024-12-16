package Model.bean;


public class inforaccount{
	 private String IdAccount;
	 private String Name;
	 private int Age;
	 private String Address;
    public String getIdAccount() {
		return IdAccount;
	}
	public void setIdAccount(String idAccount) {
		IdAccount = idAccount;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	private String SDT;	 
}