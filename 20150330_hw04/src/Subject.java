
public abstract class Subject {
	protected String Name, ID;
	
	public void setName(String cName){Name = cName;}
	public void setID(String cID){ID = cID;}
	
	public abstract void show();
	public abstract String getName();
	public abstract String getID();
}
