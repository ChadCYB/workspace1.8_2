
public class Product {
	private String description;
	private double price;

	public Product(String des, double pri){
		description = des;
		price = pri;
	}
	public String getDescription(){
		return description;
	}
	public double getPrice(){
		return price;
	}
}
