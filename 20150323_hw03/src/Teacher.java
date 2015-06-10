import java.util.ArrayList;

public class Teacher extends Person{
	private ArrayList<Course> arrCourse = new ArrayList<Course>();
	private String research, degree;
	public Teacher(){
		super();
	}
	public Teacher(String name1, String id1){
		super(name1,id1);
	}
	public void setResearch(String sResearch){ research = sResearch;}	//設定研究領域
	public void setDegree(String sDegree){ degree = sDegree;}			//設定學位
	public void addCourse(String cName,String cID,int cNum){			//新增課程
		Course cou1 = new Course(cName, cID);
		cou1.setNum(cNum);
		arrCourse.add(cou1);
	}
	public void show(){
		super.show();
		System.out.println("-----------Course------------");
		for(Course c:arrCourse){
			c.show();
		}
	}
	class Course{
		private String cName, cID;
		private int cNum;
		public Course(){}
		public Course(String name, String id){
			cName = name;
			cID = id;
		}
		public void setName(String theName){cName = theName;}	//設定課程說明
		public void setNum(int theNum){cNum = theNum;}			//設定修課人數
		public void show(){
			String cc = cName+"("+cID+")";
			System.out.println(String.format("%10s", cc)+"\t修課人數:"+cNum);
		}
	}
}
