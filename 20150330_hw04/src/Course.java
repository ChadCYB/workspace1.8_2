
public class Course extends Subject {
	private String Class,Num,Description;	//�W�ұЫ�,�W�ҤH��,�ҵ{����
	
	public Course(){}
	public Course(String name,String id,String sClass, String sNum, String sDes){
		Name = name; ID = id;
		Class = sClass;
		Num = sNum;
		Description = sDes;
	}
	
	public void setClassPlace(String sClass){Class = sClass;}
	public void setNum(String sNum){Num = sNum;}
	public void setDescription(String sDes){Description = sDes;}
	public String getClassPlace(){return Class;}
	public String getNum(){return Num;}
	public String getDescription(){return Description;}
	
	public String getName() { return Name;}
	public String getID() { return ID;}
	public void show() {
		System.out.println("�ҵ{�W��:"+Name+" (id:"+ID+")"
						+"\n�W�ұЫ�:"+Class
						+"\n�W�ҤH��:"+Num
						+"\n�ҵ{����:"+Description);
	}
}
