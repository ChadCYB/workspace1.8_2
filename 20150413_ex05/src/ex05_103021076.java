/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/04/13
 * 	Uses: �����Ω�H���O�m��(�p�Ҩt��)
 * 	Java JDK: 1.8
 */
import java.util.Scanner;
public class ex05_103021076 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Quiz q1 = new Quiz();
		q1.addQuestion("implements ������?","��@");
		q1.addQuestion("extend ������?", "�X�i");
		q1.setComplexity(0,1);
		q1.setComplexity(1,2);
		
		String input;
		int qNum = q1.getNum(), CorrectNum = 0;
		for(int i=0 ; i<qNum ; i++){
			System.out.println("��"+(i+1)+"�D: "+q1.getQuestion(i));
			System.out.print("����: ");
			input = scn.nextLine();
			if(q1.checkAns(i, input)){
				System.out.println("���ߧA����F!");
				CorrectNum ++;
			}else{
				System.out.println("Oops~�A�����F!(���T����:"+q1.getAnswer(i)+")");
			}
		}
		System.out.println("------------------");
		System.out.println("��������@"+qNum+"�D�A����F"+CorrectNum+"�D");

	}
}
