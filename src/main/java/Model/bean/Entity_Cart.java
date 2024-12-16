package Model.bean;

public class Entity_Cart {
	private String Name;
	private int Price;
	private int Quantity;
	private int Total;
	
	//
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	//
	public int getPrice() {
		return Price;
	}
	public void setPrice(int Price) {
		this.Price = Price;
	}
	//
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	//
	public int getTotal() {
		return Total;
	}
	public void setTotal(int Total) {
		this.Total = Total;
	}

}
