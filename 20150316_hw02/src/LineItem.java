
public class LineItem {
	private int amount;
	private Product theProduct;
	
	public LineItem(Product pro, int amo){
		theProduct = pro;
		amount = amo;
	}
	public double getTotalPrice(){			//回傳商品總單價
		return theProduct.getPrice()*amount;
	}
	public String format(){					//顯示商品資訊
		return String.format("%-6s\t%8.2f%5d%10.2f",
				theProduct.getDescription(),theProduct.getPrice(),amount,this.getTotalPrice()); 
	}
	public String getProDes(){				//回傳商品名
		return theProduct.getDescription();
	}
	public void setAmount(int amo){			//寫入商品數量
		amount = amo;
	}
	public void setProDes(String des){		//寫入商品名稱
		theProduct.setDescription(des);
	}
	public void setProPri(double pri){		//寫入商品價格
		theProduct.setPrice(pri);
	}
}
