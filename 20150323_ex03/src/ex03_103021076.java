/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/23
 * 	Uses: 繼承練習(學生課程系統)
 * 	Java JDK: 1.8
 */
import java.util.ArrayList;
import java.util.Scanner;
public class ex03_103021076 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<Student> stuArr = new ArrayList<Student>();
		stuArr.add(new Student("Tommy","103001"));
		stuArr.get(0).setHeight(167);
		stuArr.get(0).setWeight(60);
		stuArr.get(0).addCourse("Advanced English", "E021", 3, 80);
		stuArr.get(0).addCourse("Program Design", "P002", 5, 44);
		
		Student stu = new Student("Jack","103002");
		stu.setHeight(175);
		stu.setWeight(80);
		stuArr.add(stu);
		stuArr.get(1).addCourse("Image Modeling", "H001", 1, 95);
		
		for(Student i:stuArr){
			i.show();
			System.out.println("===========================\n");
		}
	}	
}
