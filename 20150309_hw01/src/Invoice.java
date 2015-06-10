import java.util.ArrayList;

public class Invoice {
	private Address dataAddress;
	private ArrayList<LineItem> items;
	
	public Invoice(Address add){
		dataAddress = add;
		items = new ArrayList<LineItem>();
	}
	public void add(Product pro,int amount){
		LineItem theItem = new LineItem(pro,amount);
		items.add(theItem);
	}
	public String productFormat(){
		String r=String.format("%-20s%15s%10s%25s\n","說明","單價","數量","小計");
		for(LineItem i:items){
			r += i.format()+"\n";
		}
		return r;
	}
	public double getAllPrice(){
		double allPrice=0;
		for(LineItem i:items){
			allPrice += i.getTotalPrice();
		}
		return allPrice;
	}
	public void show(){
		System.out.println(this.showLine(32,"="));
		System.out.println(this.showLine(13," ")+"<發 票>\n"+this.showLine(32,"-"));
		System.out.println(dataAddress.getAllAddress()+"\n"+this.showLine(32,"-"));
		System.out.println(this.productFormat()+this.showLine(32,"-"));
		System.out.println(String.format("%55s%15.2f", "總金額",this.getAllPrice()));
		System.out.println(this.showLine(32,"="));
	}
	public String showLine(int count,String str){
		String outStr="";
		for(int i=0;i<count;i++) outStr += str;
		return outStr;
	}
}
