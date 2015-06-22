/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/06/22
 * 	Uses: 鏈結串列練習
 * 	Java JDK: 1.8
 */
import java.util.Scanner;
public class ex12_1 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.println("請輸入: 姓名 身高(0 0結束輸入)");
		System.out.println("姓名 身高");
		Link link = new Link(scn.next(),scn.nextInt());
		while(true){
			try{
				String n = scn.next();
				int h = scn.nextInt();
				if(n.equals("0") && h==0) break;
				link.addLast(n,h);
			}catch(Exception ee){
				System.out.println("輸入錯誤，程式結束");
				break;
			}
		}
		System.out.println("\n姓名\t身高");
		link.showData();
	}
}
