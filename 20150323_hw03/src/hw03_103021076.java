/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/23
 * 	Uses: �~�ӽm��(�Юv�ҵ{�t��)
 * 	Java JDK: 1.8
 */
import java.util.Scanner;
import java.util.ArrayList;

public class hw03_103021076 {
	public static void main(String avgs[]){
		Scanner scn = new Scanner(System.in);
		ArrayList<Teacher> tArr = new ArrayList<Teacher>();
		String tName, tID, tResearch, tDegree, yn;
		while(true){
			System.out.println("=============================\n<��J�Юv���>");
			System.out.print("�п�J�Юv�m�W:");
			tName = scn.next();
			System.out.print("�п�J�ЮvID:");
			tID = scn.next();
			System.out.print("�п�J��s���:");
			tResearch = scn.next();
			System.out.print("�п�J�Ǧ�:");
			tDegree = scn.next();
			Teacher tea1 = new Teacher(tName, tID);
			tea1.setDegree(tDegree);
			tea1.setResearch(tResearch);
			tArr.add(tea1);
			System.out.println("=============================\n<��J�ҵ{���>");
			while(true){
				teacherCourseAdd(tea1,scn);
				System.out.print("�O�_�~���J�ҵ{(y/n)?");
				yn = scn.next();
				if(!(yn.equals("Y")||yn.equals("y"))) break;
				System.out.println("-----------------------------");
			}
			System.out.println("=============================");
			System.out.print("�O�_�~���J�Юv���(y/n)?");
			yn = scn.next();
			if(!(yn.equals("Y")||yn.equals("y"))) break;
		}
		System.out.println();
		for(Teacher t:tArr){
			System.out.println("*****************************");
			t.show();
			System.out.println("-----------------------------\n");
		}
	}
	public static void teacherCourseAdd(Teacher tea, Scanner scn){
		System.out.print("�п�J�ҵ{�W��:");
		String cName = scn.next();
		System.out.print("�п�J�ҵ{�s��:");
		String cID = scn.next();
		System.out.print("�п�J�½ҤH��:");
		int cNum = scn.nextInt();
		tea.addCourse(cName, cID, cNum);
	}
}
