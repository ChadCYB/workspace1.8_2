
public class Product {
	private String description;
	private double price;

	public Product(String des, double pri){
		description = des;
		price = pri;
	}
	public String getDescription(){				//�^�ǰӫ~����
		return description;
	}
	public double getPrice(){					//�^�ǰӫ~����
		return price;
	}
	public void setDescription(String des){		//�g�J�ӫ~�W��
		description = des;
	}
	public void setPrice(double pri){			//�g�J�ӫ~����
		price = pri;
	}
}
