/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/03/16
 * 	Uses: �o���{��(�h�i�o����J�A�o��,�ӫ~ �s�W�R���\��A�d�ߥ\��)
 *  Java JDK: 1.8
 */
import java.util.Scanner;
import java.util.ArrayList;

public class hw02_103021076 {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Invoice> invList = new ArrayList<Invoice>();
		System.out.println("      >>>�o����ƿ�J<<<");
		FucAddInvoice(invList,scanner);		//�o����ƿ�J
		boolean tt = true;
		while(tt){
			System.out.println("********************************");
			System.out.print("(1)�s�W�o�� (2)�ק�o���ΰӫ~ (3)�R���o���ΰӫ~\n(4)�d�߰ӫ~ (5)��ܵo�� (6)���}\n�п�ܼҦ�:");
			String mode = scanner.next();
			System.out.println("********************************\n");
			switch(mode){
				case "1":	//�s�W�o��
					System.out.println("      >>>�s�W�o��<<<");
					FucAddInvoice(invList,scanner);
					break;
				case "2":	//�ק�o��
					if(invList.size()==0){	//���L�o���P�_
						System.out.println("�S���o���F!");
					}else{
						System.out.println("      >>>�ק�o��<<<");
						FucSetInvoice(invList,scanner);
					}
					break;
				case "3":	//�R���o��
					System.out.println("      >>>�R���o��<<<");
					FucDelInvoice(invList,scanner);
					break;
				case "4":	//�d�ߵo��
					if(invList.size()==0){	//���L�o���P�_
						System.out.println("�S���o���F!");
					}else{
						System.out.println("      >>>�d�ߵo��<<<");
						FucSearchInvoice(invList,scanner);
					}
					break;
				case "5":	//��ܵo��
					if(invList.size()==0){	//���L�o���P�_
						System.out.println("�S���o���F!");
					}else{
						FucShowInvoice(invList);
					}
					break;
				case "6":	//���}
					tt = false;
					break;
				default:
					System.out.println("�S�����ﶵ!!");
			}
			System.out.println();
		}
		System.out.print("Bye Bye!");
	}

	public static void FucAddInvoice(ArrayList<Invoice> invList, Scanner scn){		//�s�W�o���\��
		boolean tt = true;
		int invNum = invList.size();
		while(tt){
			invList.add(creatInvoice(scn,++invNum));
			System.out.print("�аݬO�_�~���J�o��(y/n)?");
			String str = scn.next();
			tt = (str.equals("y")||str.equals("Y"))?true:false;
			System.out.println();
		}
	}
	public static void FucSetInvoice(ArrayList<Invoice> invList, Scanner scn){		//�ק�o���\��
		Invoice inv1;
		boolean t1 = true;
		String desc,mode1;
		double price;
		int invNum, qty;
		int invSize = invList.size();										//�o���ƶq
		while(t1){
			System.out.print("�п�J�\��(1)�s�W�ӫ~(2)�ק�ӫ~(3)��^:");
			mode1 = scn.next();
			switch (mode1){
				case "1":		//�s�W�ӫ~
					FucShowInvoice(invList);								//��ܵo��
					System.out.print("�п�J�n�ק�ĴX�i�o��(1~"+invSize+"):");
					invNum = getRangeNum(scn,invSize)-1;					//��ܵo��
					inv1 = invList.get(invNum);								//�o������
					System.out.println(inv1.showLine(32, "="));
					System.out.print("�~���W��:");
					desc = getStr(scn);
					System.out.print("�ӫ~���:");
					price = getNum(scn);
					System.out.print("�ӫ~�ƶq:");
					qty = getIntNum(scn);
					inv1.add(new Product(desc,price), qty);
					System.out.println("�s�W���\!");
					System.out.print(inv1.productFormat());			//��ܰӫ~
					System.out.println(inv1.showLine(32, "="));
					break;
				case "2":		//�ק�ӫ~
					FucShowInvoice(invList);								//��ܵo��
					System.out.print("�п�J�n�ק�ĴX�i�o��(1~"+invSize+"):");
					invNum = getRangeNum(scn,invSize)-1;					//��ܵo��
					inv1 = invList.get(invNum);								//�o������
					System.out.println(inv1.showLine(32, "="));
					boolean t2 = true;
					while(t2){
						int proSize = inv1.getProductSize();				//�ӫ~�ƶq
						if(proSize == 0){									//���L�ӫ~
							System.out.println("�S���ӫ~�F!");
							break;
						}else{
							System.out.print(inv1.productFormat());			//��ܰӫ~
							System.out.println(inv1.showLine(32, "-"));
							System.out.print("�п�J�n�ק�ĴX���ӫ~(1~"+proSize+"):");
							int proNum = getRangeNum(scn,proSize)-1;		//��ܰӫ~
							System.out.print("�Эn�ק�ﶵ(1)�ӫ~����(2)�ӫ~���(3)�ӫ~�ƶq(4)��^:");
							switch (scn.next()){
								case "1":	//�ӫ~����
									System.out.print("�ӫ~����:");
									inv1.getProduct(proNum).setProDes(getStr(scn));
									System.out.println("�ק令�\!");
									break;
								case "2":	//�ӫ~���
									System.out.print("�ӫ~���:");
									inv1.getProduct(proNum).setProPri(getNum(scn));
									System.out.println("�ק令�\!");
									break;
								case "3":	//�ӫ~�ƶq
									System.out.print("�ӫ~�ƶq:");
									inv1.getProduct(proNum).setAmount(getIntNum(scn));
									System.out.println("�ק令�\!");
									break;
								case "4":	//��^
									t2 = false;
									break;
								default:
									System.out.println("�S�����ﶵ!");
							}
							invList.get(0).showLine(32, "-");
						}
					}
					break;
				case "3":		//��^
					t1 = false;
					break;
				default:
					System.out.println("�S�����ﶵ!");
			}
		}
	}
	public static void FucDelInvoice(ArrayList<Invoice> invList, Scanner scn){		//�R���o���\��
		boolean tt = true;
		int invNum;
		while(tt){
			if(invList.size()==0){	//���L�o���P�_
				System.out.println("�S���o���F!");
				break;
			}else{
				System.out.print("�п�ܥ\��(1)�R���o��(2)�R���ӫ~(3)��^:");
				switch (scn.next()){
					case "1":		//�R���o��
						FucShowInvoice(invList);										//��ܵo��
						System.out.print("�п�J�n�R���ĴX�i�o��(1~"+invList.size()+"):");
						invNum = getRangeNum(scn,invList.size())-1;						//��ܵo��
						invList.remove(invNum);											//�R����i�o��
						System.out.println("�o���R�����\!");
						break;
					case "2":		//�R���ӫ~
						FucShowInvoice(invList);										//��ܵo��
						System.out.print("�п�ܭn�ĴX�i�o��(1~"+invList.size()+"):");
						invNum = getRangeNum(scn,invList.size())-1;						//��ܵo��
						int proSize = invList.get(invNum).getProductSize();				//�ӫ~�ƶq
						if(proSize == 0){
							System.out.println("�S���ӫ~�F!");
							break;
						}else{
							System.out.println(invList.get(invNum).productFormat());		//��ܰӫ~
							System.out.print("�п�J�n�R���ĴX���ӫ~(1~"+proSize+"):");
							int proNum = getRangeNum(scn,proSize)-1;
							invList.get(invNum).removeProduct(proNum);						//�R���ӫ~
							System.out.println("�ӫ~�R�����\!");
							System.out.println("--------------------------------");
							System.out.println(invList.get(invNum).productFormat()+"\n");	//��ܰӫ~
						}
						break;
					case "3":		//��^
						tt = false;
						break;
					default:
						System.out.println("�S�����ﶵ!");
				}
			}
		}
	}
	public static void FucSearchInvoice(ArrayList<Invoice> invList, Scanner scn){	//�j�M�o���\��
		boolean tt = true, findPro = false;
		String SearchName;
		ArrayList<LineItem> theItem;
		while(tt){
			findPro = false;
			System.out.print("�п�ܥ\��(1)�̰ӫ~�W�d��(2)��^:");
			switch (scn.next()){
			case "1":				//�̰ӫ~�W�d��
				System.out.print("�п�J���d�߰ӫ~�W��:");
				SearchName = getStr(scn);
				for(Invoice i: invList){
					theItem = i.getProduct();										//��o���Ҧ��ӫ~
					for(LineItem j: theItem){
						if(SearchName.equals(j.getProDes())){
							System.out.println("<�o��"+(invList.indexOf(i)+1)+">");	//�o����m
							String r=String.format("%-18s%15s%10s%25s\n","�~���W��","���","�ƶq","�p�p");
							System.out.println(r+j.format());						//�ӫ~��T
							System.out.println("--------------------------------");
							findPro = true;
						}
					}	
				}
				if(!findPro){
					System.out.println("�d�L���ӫ~!");
				}
				break;
			case "2":				//��^
				tt = false;
				break;
			default:
				System.out.println("�S�����ﶵ!");
			}
		}
	}
	public static void FucShowInvoice(ArrayList<Invoice> invList){	//��ܵo���\��
		int invNum = 0;
		for(Invoice inv:invList){
			inv.show(++invNum);
		}
	}
	public static String getStr(Scanner scn){					//�P�_�D�ťզr��
		String input = "";
		while(input.equals("")){
			input = scn.nextLine();
		}
		return input;
	}
	public static int getRangeNum(Scanner scn, int end){		//�P�_��ƽd��(0~end)
		int input = 0;
		boolean tt = true;
		while(tt){
			input = getIntNum(scn);
			if(0<input && input<=end){
				tt = false;
			}else{
				tt = true;
				System.out.println("�Ʀr�d����~�I");
			}	
		}
		return input;
	}
	public static int getIntNum(Scanner scn){					//�P�_�Ʀr�榡(���)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.next();
			if(input.matches("[0-9]{1,}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("�榡���~�A�Э��s��J�I");
			}
		}
		return Integer.parseInt(input);
	}
	public static double getNum(Scanner scn){					//�P�_�Ʀr�榡(��ƩΤp���I)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.next();
			if(input.matches("[0-9]{1,}\\.?[0-9]+")||input.matches("[0-9]{1,}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("�榡���~�A�Э��s��J�I");
			}
		}
		return Double.parseDouble(input);
	}
	public static String getPhoneNum(Scanner scn){			//�P�_�q�ܮ榡(2-8��4-6)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.nextLine();
			if(input.matches("[0-9]{2}-[0-9]{8}||[0-9]{4}-[0-9]{6}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("�榡���~�A�Э��s��J�I");
			}
		}
		return input;
	}
	public static Invoice creatInvoice(Scanner scn,int invNumber){
		String s1,s2,s3,s4,desc;
		int numOfItems,qty;
		double price;
		System.out.println("=========<��"+invNumber+"�i�o��>=========");
		System.out.println("�п�J���W(ex.�Ȭw��u��):");
		s1 = getStr(scn);
		System.out.println("�п�J�a�}(ex.�x�������p�Ϭh�׸�500��):");
		s2 = getStr(scn);
		System.out.println("�п�J�q�ܸ��X(ex.04-12345678,0912-123456):");
		s3 = getPhoneNum(scn);
		System.out.println("�п�J�ǯu���X(ex.04-12345678,0912-123456):");
		s4 = getPhoneNum(scn);
		Address add1 = new Address(s1,s2,s3,s4);
		Invoice inv1 = new Invoice(add1);
		System.out.println(inv1.showLine(32, "-"));
		System.out.print("�п�J�ӫ~�`����:");
		numOfItems = getIntNum(scn);
		for(int i=0 ; i<numOfItems ; i++){
			System.out.println("<�ӫ~"+(i+1)+">");
			System.out.print("�ӫ~����:");
			desc = getStr(scn);
			System.out.print("�ӫ~���:");
			price = getNum(scn);
			System.out.print("�ӫ~�ƶq:");
			qty = getIntNum(scn);
			inv1.add(new Product(desc,price), qty);
			System.out.println(inv1.showLine(32, "="));
		}
		System.out.println();
		return inv1;
	}
}

