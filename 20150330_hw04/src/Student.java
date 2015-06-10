import java.util.ArrayList;

public class Student extends Person{
	private ArrayList<Class> arrClass = new ArrayList<Class>();
	private String College, Department, Program, Grade;	//學院,系所,畢業學程,年級

	public Student(){}
	public Student(String sName,String sID){
		name = sName;
		id = sID;
	}
	
	public void setCollege(String sCol){College = sCol;}
	public void setDepartment(String sDept){Department = sDept;}
	public void setProgram(String sProgram){Program = sProgram;}
	public void setGrade(String sGrade){Grade = sGrade;}
	public String getCollege(){return College;}
	public String getDepartment(){return Department;}
	public String getProgram(){return Program;}
	public String getGrade(){return Grade;}
	
	public void addClass(Class c){ arrClass.add(c);}
	public void addClass(String cName,String cID, String tCredit, String tScore, String tTime){
		arrClass.add(new Class(cName,cID,tCredit,tScore,tTime));
	}
	public void show(){
		System.out.println("Name:"+name+"\t("+id+")"
						+"\nAddress:"+address+" Tel:"+tel
						+"\nCollege:"+College
						+"\nDepartment:"+Department
						+"\nProgram:"+Program
						+"\nGrade:"+Grade);
		for(Class i: arrClass){
			System.out.println("---------------------");
			i.show();
		}
	}
}
