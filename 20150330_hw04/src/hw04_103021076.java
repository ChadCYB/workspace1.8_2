/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/30
 * 	Uses: 抽象類別練習(學務系統)
 * 	Java JDK: 1.8
 */
import java.util.ArrayList;
public class hw04_103021076 {
	public static void main(String[] args) {
		ArrayList<Teacher> teaArr = new ArrayList<Teacher>();
		ArrayList<Student> stuArr = new ArrayList<Student>();
		teaArr.add(new Teacher("李四","8463150"));
		teaArr.get(0).setAddress("台中市逢甲路");
		teaArr.get(0).setTel("0945214542");
		teaArr.get(0).addCourse("計算機概論", "56412354", "I213", "31", "教授計算機科學的基礎技術及知識");
		Teacher tea1 = new Teacher("張三","8463150");
		tea1.setAddress("台中市英才路");
		tea1.setTel("0912354213");
		tea1.setDegree("博士");
		tea1.setExperience("台大");
		tea1.setSeniority("500k");
		tea1.setSalary("50k");
		teaArr.add(tea1);
		Course cou1 = new Course("程式設計一","23345666","H103","45","Java程式設計");
		tea1.addCourse(cou1);
		tea1.addCourse("行動裝置程式設計", "19945721", "I311", "20", "APP行動裝置應用");
		tea1.addCourse("演算法", "19945721", "I526", "20", "將解決問題裹成具體並以明確的步驟詳述執行過程");

		Student stu1 = new Student("小明","1032104");
		stu1.setCollege("資工");
		stu1.setTel("0921871834");
		Class cla1 = new Class("程式設計一","23345666","3","90","Mon 13:10-16:00");
		stu1.addClass(cla1);
		stu1.addClass("計算機概論", "56412354", "2", "85", "Thu 10:10-12:00");
		stu1.addClass("演算法", "19945721", "2", "80", "Fri 15:10-17:00");
		stuArr.add(stu1);
		
		showTea(teaArr);
		showStu(stuArr);
	}
	public static void showTea(ArrayList<Teacher> arr){
		System.out.println("<<老師資訊>>");
		for(Teacher t:arr){
			System.out.println("============================");
			t.show();
			System.out.println("============================\n");
		}
	}
	public static void showStu(ArrayList<Student> arr){
		System.out.println("<<學生資訊>>");
		for(Student s:arr){
			System.out.println("============================");
			s.show();
			System.out.println("============================\n");
		}
	}
}
