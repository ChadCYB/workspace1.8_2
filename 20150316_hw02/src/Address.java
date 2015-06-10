
public class Address {
	private String Station;
	private String Address1;
	private String PhoneNum;
	private String FaxNum;
	
	public Address(String sta, String add1, String phone, String fax){
		Station = sta;
		Address1 = add1;
		PhoneNum = phone;
		FaxNum = fax;
	}
	public String getAllAddress(){
		return ("Station: "+Station+"\n"+"Address: "
				+Address1+"\nPhoneNum: "+PhoneNum+"\nFaxNum: "+FaxNum);
	}
}
