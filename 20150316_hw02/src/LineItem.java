
public class LineItem {
	private int amount;
	private Product theProduct;
	
	public LineItem(Product pro, int amo){
		theProduct = pro;
		amount = amo;
	}
	public double getTotalPrice(){			//�^�ǰӫ~�`���
		return theProduct.getPrice()*amount;
	}
	public String format(){					//��ܰӫ~��T
		return String.format("%-6s\t%8.2f%5d%10.2f",
				theProduct.getDescription(),theProduct.getPrice(),amount,this.getTotalPrice()); 
	}
	public String getProDes(){				//�^�ǰӫ~�W
		return theProduct.getDescription();
	}
	public void setAmount(int amo){			//�g�J�ӫ~�ƶq
		amount = amo;
	}
	public void setProDes(String des){		//�g�J�ӫ~�W��
		theProduct.setDescription(des);
	}
	public void setProPri(double pri){		//�g�J�ӫ~����
		theProduct.setPrice(pri);
	}
}
