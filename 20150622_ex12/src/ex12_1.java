/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/06/22
 * 	Uses: �쵲��C�m��
 * 	Java JDK: 1.8
 */
import java.util.Scanner;
public class ex12_1 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.println("�п�J: �m�W ����(0 0������J)");
		System.out.println("�m�W ����");
		Link link = new Link(scn.next(),scn.nextInt());
		while(true){
			try{
				String n = scn.next();
				int h = scn.nextInt();
				if(n.equals("0") && h==0) break;
				link.addLast(n,h);
			}catch(Exception ee){
				System.out.println("��J���~�A�{������");
				break;
			}
		}
		System.out.println("\n�m�W\t����");
		link.showData();
	}
}
