
public class Teacher extends Person{
	private String Degree,Experience,Seniority,Salary;
	//學歷,經歷,年資,月薪
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
	
	public void show(){
		System.out.println("Name:"+name+"\t("+id+")"
						+"\nAddress:"+address
						+"\nTel:"+tel
						+"\n---------------------"
						+"\nDegree:"+Degree
						+"\nExperience:"+Experience
						+"\nSeniority:"+Seniority
						+"\nSalary:"+Salary);
	}
}
