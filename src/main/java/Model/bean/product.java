package Model.bean;

public class product {
   private int IdProduct;
   private String Name;
   private int Price;
   private byte[] Image;
   private byte Status;
   public product() {
	   
   }
   public product(int idproduct,String name,int price,byte[] image,byte status) {
	   this.IdProduct=idproduct;
	   this.Name = name;
	   this.Price = price;
	   this.Image = image;
	   this.Status= status;
	   
   }
   public void SetIdProduct(int idproduct) {
	   this.IdProduct = idproduct;
   }
   public void SetName(String name) {
	   this.Name = name;
   }
   public void SetPrice(int price) {
	   this.Price = price;
   }
   public void SetImage(byte[] image) {
	   this.Image = image;
   }
   public void SetStatus(byte status) {
	   this.Status = status;
   }
   public int GetIdProduct() {
	   return this.IdProduct;
   }
   
   public String GetName() {
	   return this.Name;
   }
   public int GetPrice() {
	   return this.Price;
   }
   public byte[] GetImage() {
	   return this.Image;
   } 
   public byte GetStatus() {
	   return this.Status;
   }
}

