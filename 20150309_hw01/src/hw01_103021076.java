/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/09
 * 	Uses: �o���{��(��i�o���ӫ~��J)
 *  Java JDK: 1.8
 */
import java.util.Scanner;

public class hw01_103021076 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		String s1,s2,s3,desc;
		int numOfItems,qty;
		double price;
		System.out.println("�п�J���W(ex.�Ȭw��u��):");
		s1 = getStr(scn);
		System.out.println("�п�J�a�}(ex.�h�׸�500��):");
		s2 = getStr(scn);
		System.out.println("�п�J��,��,�l���ϸ�(ex.���p��, �x����  41354):");
		s3 = getStr(scn);
		Address add1 = new Address(s1,s2,s3);
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

//inv1.add(new Product("���[�U",100.20), 3);
//inv1.add(new Product("�p����",1112.30), 2);
//inv1.add(new Product("�c���l",93.50), 1);
//inv1.add(new Product("�}�]�C",130.40), 5);
//inv1.add(new Product("������",210.11), 2);
//inv1.add(new Product("������",88.88), 6);
//inv1.add(new Product("�]���\",140.80), 10);
