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
	public void setResearch(String sResearch){ research = sResearch;}	//�]�w��s���
	public void setDegree(String sDegree){ degree = sDegree;}			//�]�w�Ǧ�
	public void addCourse(String cName,String cID,int cNum){			//�s�W�ҵ{
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
		public void setName(String theName){cName = theName;}	//�]�w�ҵ{����
		public void setNum(int theNum){cNum = theNum;}			//�]�w�׽ҤH��
		public void show(){
			String cc = cName+"("+cID+")";
			System.out.println(String.format("%10s", cc)+"\t�׽ҤH��:"+cNum);
		}
	}
}
