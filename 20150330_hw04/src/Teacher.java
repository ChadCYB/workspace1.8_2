import java.util.ArrayList;

public class Teacher extends Person{
	private ArrayList<Course> arrCourse = new ArrayList<Course>();
	private String Degree,Experience,Seniority,Salary;	//學歷,經歷,年資,月薪

	public Teacher(){}
	public Teacher(String sName,String sID){
		name = sName;
		id = sID;
	}
	
	public void setDegree(String tDegree){Degree = tDegree;}
	public void setExperience(String tExp){Experience = tExp;}
	public void setSeniority(String tSen){Seniority = tSen;}
	public void setSalary(String sSalary){Salary = sSalary;}
	public String getDegree(){return Degree;}
	public String getExperience(){return Experience;}
	public String getSeniority(){return Seniority;}
	public String getSalary(){return Salary;}
	
	public void addCourse(String cName, String cID, String sClass, String sNum, String sDes){
		arrCourse.add(new Course(cName,cID,sClass,sNum,sDes));
	}
	public void addCourse(Course c){ arrCourse.add(c);}
	public void show(){
		System.out.println("Name:"+name+"\t("+id+")"
						+"\nAddress:"+address+", Tel:"+tel
						+"\nDegree:"+Degree
						+"\nExperience:"+Experience
						+"\nSeniority:"+Seniority
						+"\nSalary:"+Salary);
		for(Course i: arrCourse){
			System.out.println("---------------------");
			i.show();
		}
	}
}
