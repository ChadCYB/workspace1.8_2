/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/23
 * 	Uses: 繼承練習(教師課程系統)
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
			System.out.println("=============================\n<輸入教師資料>");
			System.out.print("請輸入教師姓名:");
			tName = scn.next();
			System.out.print("請輸入教師ID:");
			tID = scn.next();
			System.out.print("請輸入研究領域:");
			tResearch = scn.next();
			System.out.print("請輸入學位:");
			tDegree = scn.next();
			Teacher tea1 = new Teacher(tName, tID);
			tea1.setDegree(tDegree);
			tea1.setResearch(tResearch);
			tArr.add(tea1);
			System.out.println("=============================\n<輸入課程資料>");
			while(true){
				teacherCourseAdd(tea1,scn);
				System.out.print("是否繼續輸入課程(y/n)?");
				yn = scn.next();
				if(!(yn.equals("Y")||yn.equals("y"))) break;
				System.out.println("-----------------------------");
			}
			System.out.println("=============================");
			System.out.print("是否繼續輸入教師資料(y/n)?");
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
		System.out.print("請輸入課程名稱:");
		String cName = scn.next();
		System.out.print("請輸入課程編號:");
		String cID = scn.next();
		System.out.print("請輸入授課人數:");
		int cNum = scn.nextInt();
		tea.addCourse(cName, cID, cNum);
	}
}
