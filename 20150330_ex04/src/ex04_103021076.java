/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/30
 * 	Uses: ��H���O�m��(�ǰȨt��)
 * 	Java JDK: 1.6
 */
import java.util.ArrayList;
public class ex04_103021076 {
	public static void main(String[] args) {
		ArrayList<Teacher> teaArr = new ArrayList<Teacher>();
		
		teaArr.add(new Teacher("����","1284054"));
		Teacher tea1 = new Teacher("�i�T","8463150");
		tea1.setAddress("�x�����^�~��");
		tea1.setTel("0912354213");
		tea1.setDegree("�դh");
		tea1.setExperience("�x�j");
		tea1.setSeniority("500k");
		tea1.setSalary("50k");
		teaArr.add(tea1);
		
		for(Teacher t:teaArr){
			t.show();
			System.out.println("=====================");
		}
		
		Student stu1 = new Student("�p��","1032104");
		stu1.show();
		System.out.println("=====================");
		stu1.setCollege("��u");
		stu1.show();
	}
}
