import java.util.ArrayList;

public class Student extends Person{
	private ArrayList<Course> arrCourse = new ArrayList<Course>();
	public Student(){
		super();
	}
	public Student(String name1, String id1){
		super(name1,id1);
	}
	public void addCourse(String cName,String cID,int point,int score){
		Course cou1 = new Course(cName, cID);
		cou1.setPoint(point);
		cou1.setScore(score);
		arrCourse.add(cou1);
	}
	public void show(){
		super.show();
		System.out.println("----------Course-----------");
		for(Course c:arrCourse){
			c.show();
		}
	}
	class Course{
		private String cName,cID;
		private int scorePoint, score;
		public Course(){}
		public Course(String name, String id){
			cName = name;
			cID = id;
		}
		public void setPoint(int thePoint){scorePoint = thePoint;}
		public void setScore(int theScore){score = theScore;}
		public int getScore(){return score;}
		public void show(){
			System.out.println(cName
			+"("+cID+")\t學分:"+scorePoint+"\t分數:"+score);
			
		}
	}
}
