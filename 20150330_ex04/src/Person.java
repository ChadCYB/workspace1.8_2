
public abstract class Person {
	protected String name, id, address, tel;
	
	public void setName(String sName){name = sName;}
	public void setID(String sID){id = sID;}
	public void setAddress(String sAdd){address = sAdd;}
	public void setTel(String sTel){tel = sTel;}
	
	public String getName(){return name;}
	public String getID(){return id;}
	public String getAddress(){return address;}
	public String getTel(){return tel;}
	
	public abstract void show();	//©â¶H¤èªk
}
