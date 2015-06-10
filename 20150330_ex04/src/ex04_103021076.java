/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/30
 * 	Uses: 抽象類別練習(學務系統)
 * 	Java JDK: 1.6
 */
import java.util.ArrayList;
public class ex04_103021076 {
	public static void main(String[] args) {
		ArrayList<Teacher> teaArr = new ArrayList<Teacher>();
		
		teaArr.add(new Teacher("王老","1284054"));
		Teacher tea1 = new Teacher("張三","8463150");
		tea1.setAddress("台中市英才路");
		tea1.setTel("0912354213");
		tea1.setDegree("博士");
		tea1.setExperience("台大");
		tea1.setSeniority("500k");
		tea1.setSalary("50k");
		teaArr.add(tea1);
		
		for(Teacher t:teaArr){
			t.show();
			System.out.println("=====================");
		}
		
		Student stu1 = new Student("小明","1032104");
		stu1.show();
		System.out.println("=====================");
		stu1.setCollege("資工");
		stu1.show();
	}
}
