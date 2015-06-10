/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/04/13
 * 	Uses: 介面及抽象類別練習(小考系統)
 * 	Java JDK: 1.8
 */
import java.util.Scanner;
public class ex05_103021076 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Quiz q1 = new Quiz();
		q1.addQuestion("implements 的中文?","實作");
		q1.addQuestion("extend 的中文?", "擴展");
		q1.setComplexity(0,1);
		q1.setComplexity(1,2);
		
		String input;
		int qNum = q1.getNum(), CorrectNum = 0;
		for(int i=0 ; i<qNum ; i++){
			System.out.println("第"+(i+1)+"題: "+q1.getQuestion(i));
			System.out.print("答案: ");
			input = scn.nextLine();
			if(q1.checkAns(i, input)){
				System.out.println("恭喜你答對了!");
				CorrectNum ++;
			}else{
				System.out.println("Oops~你答錯了!(正確答案:"+q1.getAnswer(i)+")");
			}
		}
		System.out.println("------------------");
		System.out.println("本次測驗共"+qNum+"題，答對了"+CorrectNum+"題");

	}
}
