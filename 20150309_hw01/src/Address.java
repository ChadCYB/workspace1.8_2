
public class Address {
	private String Station;
	private String Address1;
	private String Address2;
	
	public Address(String sta, String add1, String add2){
		Station = sta;
		Address1 = add1;
		Address2 = add2;
	}
	public String getAllAddress(){
		return (Station+"\n"+Address1+"\n"+Address2);
	}
}
