
public class Person{
	private String name,id;
	private float height,weight;
	public Person(){}
	public Person(String stName,String stID){
		name = stName;
		id = stID;
	}
	public String getName(){return name;}
	public String getID(){return id;}
	public float getHeight(){return height;}
	public float getWeight(){return weight;}
	public void setName(String theName){name = theName;}
	public void setID(String theID){id = theID;}
	public void setHeight(float H){height = H;}
	public void setWeight(float W){weight = W;}
	public void show(){
		System.out.println("Name:"+name+"\nID:"+id);
	}
}
