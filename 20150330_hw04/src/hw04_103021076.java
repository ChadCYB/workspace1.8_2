/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/30
 * 	Uses: ��H���O�m��(�ǰȨt��)
 * 	Java JDK: 1.8
 */
import java.util.ArrayList;
public class hw04_103021076 {
	public static void main(String[] args) {
		ArrayList<Teacher> teaArr = new ArrayList<Teacher>();
		ArrayList<Student> stuArr = new ArrayList<Student>();
		teaArr.add(new Teacher("���|","8463150"));
		teaArr.get(0).setAddress("�x�����{�Ҹ�");
		teaArr.get(0).setTel("0945214542");
		teaArr.get(0).addCourse("�p�������", "56412354", "I213", "31", "�б­p�����Ǫ���¦�޳N�Ϊ���");
		Teacher tea1 = new Teacher("�i�T","8463150");
		tea1.setAddress("�x�����^�~��");
		tea1.setTel("0912354213");
		tea1.setDegree("�դh");
		tea1.setExperience("�x�j");
		tea1.setSeniority("500k");
		tea1.setSalary("50k");
		teaArr.add(tea1);
		Course cou1 = new Course("�{���]�p�@","23345666","H103","45","Java�{���]�p");
		tea1.addCourse(cou1);
		tea1.addCourse("��ʸ˸m�{���]�p", "19945721", "I311", "20", "APP��ʸ˸m����");
		tea1.addCourse("�t��k", "19945721", "I526", "20", "�N�ѨM���D�q������åH���T���B�J�ԭz����L�{");

		Student stu1 = new Student("�p��","1032104");
		stu1.setCollege("��u");
		stu1.setTel("0921871834");
		Class cla1 = new Class("�{���]�p�@","23345666","3","90","Mon 13:10-16:00");
		stu1.addClass(cla1);
		stu1.addClass("�p�������", "56412354", "2", "85", "Thu 10:10-12:00");
		stu1.addClass("�t��k", "19945721", "2", "80", "Fri 15:10-17:00");
		stuArr.add(stu1);
		
		showTea(teaArr);
		showStu(stuArr);
	}
	public static void showTea(ArrayList<Teacher> arr){
		System.out.println("<<�Ѯv��T>>");
		for(Teacher t:arr){
			System.out.println("============================");
			t.show();
			System.out.println("============================\n");
		}
	}
	public static void showStu(ArrayList<Student> arr){
		System.out.println("<<�ǥ͸�T>>");
		for(Student s:arr){
			System.out.println("============================");
			s.show();
			System.out.println("============================\n");
		}
	}
}
