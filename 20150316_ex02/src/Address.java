
public class Address {
	private String Station;
	private String Address1;
	private String Address2;
	private String PhoneNum;
	private String FaxNum;
	
	public Address(String sta, String add1, String add2, String phone, String fax){
		Station = sta;
		Address1 = add1;
		Address2 = add2;
		PhoneNum = phone;
		FaxNum = fax;
	}
	public String getAllAddress(){
		return (Station+"\n"+Address1+"\n"+Address2+PhoneNum+"\n"+FaxNum);
	}
}
