/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/09
 * 	Uses: 發票程式(單張發票商品輸入)
 *  Java JDK: 1.8
 */
import java.util.Scanner;

public class hw01_103021076 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		String s1,s2,s3,desc;
		int numOfItems,qty;
		double price;
		System.out.println("請輸入店名(ex.亞洲資工站):");
		s1 = getStr(scn);
		System.out.println("請輸入地址(ex.柳豐路500號):");
		s2 = getStr(scn);
		System.out.println("請輸入市,區,郵遞區號(ex.霧峰區, 台中市  41354):");
		s3 = getStr(scn);
		Address add1 = new Address(s1,s2,s3);
		Invoice inv1 = new Invoice(add1);
		System.out.println(inv1.showLine(32, "-"));
		System.out.print("請輸入商品總項數:");
		numOfItems = scn.nextInt();
		for(int i=0 ; i<numOfItems ; i++){
			System.out.println("<商品"+(i+1)+">");
			System.out.print("商品說明:");
			desc = getStr(scn);
			System.out.print("商品單價:");
			price = scn.nextDouble();
			System.out.print("商品數量:");
			qty = scn.nextInt();
			inv1.add(new Product(desc,price), qty);
			System.out.println(inv1.showLine(32, "*"));
		}
		System.out.println();
		inv1.show();
	}
	public static String getStr(Scanner s){
		String input = "";
		while(input.equals("")){
			input = s.nextLine();
		}
		return input;
	}
}

//inv1.add(new Product("乾坤袋",100.20), 3);
//inv1.add(new Product("雷神斧",1112.30), 2);
//inv1.add(new Product("惡鬼槌",93.50), 1);
//inv1.add(new Product("破魔劍",130.40), 5);
//inv1.add(new Product("極光盾",210.11), 2);
//inv1.add(new Product("打狗棒",88.88), 6);
//inv1.add(new Product("魔之淚",140.80), 10);
