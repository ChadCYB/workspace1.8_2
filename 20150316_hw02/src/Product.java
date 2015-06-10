
public class Product {
	private String description;
	private double price;

	public Product(String des, double pri){
		description = des;
		price = pri;
	}
	public String getDescription(){				//回傳商品說明
		return description;
	}
	public double getPrice(){					//回傳商品價格
		return price;
	}
	public void setDescription(String des){		//寫入商品名稱
		description = des;
	}
	public void setPrice(double pri){			//寫入商品價格
		price = pri;
	}
}
