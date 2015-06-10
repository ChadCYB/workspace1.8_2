
public class LineItem {
	private int amount;
	private Product theProduct;
	
	public LineItem(Product pro, int amo){
		theProduct = pro;
		amount = amo;
	}
	public double getTotalPrice(){
		return theProduct.getPrice()*amount;
	}
	public String format(){
		return String.format("%-10s\t%8.2f%5d%10.2f",
				theProduct.getDescription(),theProduct.getPrice(),amount,this.getTotalPrice()); 
	}
}
