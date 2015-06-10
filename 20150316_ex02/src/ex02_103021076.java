/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/16
 * 	Uses: 發票程式(多張發票輸入)
 *  Java JDK: 1.8
 */
import java.util.Scanner;
import java.util.ArrayList;

public class ex02_103021076 {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Invoice> invList = new ArrayList<Invoice>();
		boolean tt = true;
		int invNum = 0;
		while(tt){
			invList.add(creatInvoice(scanner,++invNum));
			System.out.print("請問是否繼續輸入發票(y/n)?");
			String str = scanner.next();
			tt = (str.equals("y")||str.equals("Y"))?true:false;
			System.out.println();
		}
		invNum = 0;
		for(Invoice inv:invList){
			inv.show(++invNum);
		}
	}
	public static String getStr(Scanner s){
		String input = "";
		while(input.equals("")){
			input = s.nextLine();
		}
		return input;
	}
	public static String getPhoneNum(Scanner s){
		String input = "";
		boolean tt = true;
		while(tt){
			input = s.nextLine();
			if(input.matches("[0-9]{2}-[0-9]{8}||[0-9]{4}-[0-9]{6}")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("格式錯誤，請重新輸入");
			}
		}
		return input;
	}
	public static Invoice creatInvoice(Scanner scn,int invNumber){
		String s1,s2,s3,s4,s5,desc;
		int numOfItems,qty;
		double price;
		System.out.println("=========<第"+invNumber+"張發票>=========");
		System.out.println("請輸入店名(ex.亞洲資工站):");
		s1 = getStr(scn);
		System.out.println("請輸入地址(ex.柳豐路500號):");
		s2 = getStr(scn);
		System.out.println("請輸入市,區,郵遞區號(ex.霧峰區, 台中市  41354):");
		s3 = getStr(scn);
		System.out.println("請輸入電話號碼(ex.04-12345678,0912-345678):");
		s4 = getPhoneNum(scn);
		System.out.println("請輸入傳真號碼(ex.04-12345678,0912-345678):");
		s5 = getPhoneNum(scn);
		Address add1 = new Address(s1,s2,s3,s4,s5);
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
		return inv1;
	}
}

