/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/16
 * 	Uses: �o���{��(�h�i�o����J)
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
			System.out.print("�аݬO�_�~���J�o��(y/n)?");
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
				System.out.println("�榡���~�A�Э��s��J");
			}
		}
		return input;
	}
	public static Invoice creatInvoice(Scanner scn,int invNumber){
		String s1,s2,s3,s4,s5,desc;
		int numOfItems,qty;
		double price;
		System.out.println("=========<��"+invNumber+"�i�o��>=========");
		System.out.println("�п�J���W(ex.�Ȭw��u��):");
		s1 = getStr(scn);
		System.out.println("�п�J�a�}(ex.�h�׸�500��):");
		s2 = getStr(scn);
		System.out.println("�п�J��,��,�l���ϸ�(ex.���p��, �x����  41354):");
		s3 = getStr(scn);
		System.out.println("�п�J�q�ܸ��X(ex.04-12345678,0912-345678):");
		s4 = getPhoneNum(scn);
		System.out.println("�п�J�ǯu���X(ex.04-12345678,0912-345678):");
		s5 = getPhoneNum(scn);
		Address add1 = new Address(s1,s2,s3,s4,s5);
		Invoice inv1 = new Invoice(add1);
		System.out.println(inv1.showLine(32, "-"));
		System.out.print("�п�J�ӫ~�`����:");
		numOfItems = scn.nextInt();
		for(int i=0 ; i<numOfItems ; i++){
			System.out.println("<�ӫ~"+(i+1)+">");
			System.out.print("�ӫ~����:");
			desc = getStr(scn);
			System.out.print("�ӫ~���:");
			price = scn.nextDouble();
			System.out.print("�ӫ~�ƶq:");
			qty = scn.nextInt();
			inv1.add(new Product(desc,price), qty);
			System.out.println(inv1.showLine(32, "*"));
		}
		System.out.println();
		return inv1;
	}
}

