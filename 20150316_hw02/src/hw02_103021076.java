/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/03/16
 * 	Uses: 發票程式(多張發票輸入，發票,商品 新增刪除功能，查詢功能)
 *  Java JDK: 1.8
 */
import java.util.Scanner;
import java.util.ArrayList;

public class hw02_103021076 {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Invoice> invList = new ArrayList<Invoice>();
		System.out.println("      >>>發票資料輸入<<<");
		FucAddInvoice(invList,scanner);		//發票資料輸入
		boolean tt = true;
		while(tt){
			System.out.println("********************************");
			System.out.print("(1)新增發票 (2)修改發票或商品 (3)刪除發票或商品\n(4)查詢商品 (5)顯示發票 (6)離開\n請選擇模式:");
			String mode = scanner.next();
			System.out.println("********************************\n");
			switch(mode){
				case "1":	//新增發票
					System.out.println("      >>>新增發票<<<");
					FucAddInvoice(invList,scanner);
					break;
				case "2":	//修改發票
					if(invList.size()==0){	//有無發票判斷
						System.out.println("沒有發票了!");
					}else{
						System.out.println("      >>>修改發票<<<");
						FucSetInvoice(invList,scanner);
					}
					break;
				case "3":	//刪除發票
					System.out.println("      >>>刪除發票<<<");
					FucDelInvoice(invList,scanner);
					break;
				case "4":	//查詢發票
					if(invList.size()==0){	//有無發票判斷
						System.out.println("沒有發票了!");
					}else{
						System.out.println("      >>>查詢發票<<<");
						FucSearchInvoice(invList,scanner);
					}
					break;
				case "5":	//顯示發票
					if(invList.size()==0){	//有無發票判斷
						System.out.println("沒有發票了!");
					}else{
						FucShowInvoice(invList);
					}
					break;
				case "6":	//離開
					tt = false;
					break;
				default:
					System.out.println("沒有此選項!!");
			}
			System.out.println();
		}
		System.out.print("Bye Bye!");
	}

	public static void FucAddInvoice(ArrayList<Invoice> invList, Scanner scn){		//新增發票功能
		boolean tt = true;
		int invNum = invList.size();
		while(tt){
			invList.add(creatInvoice(scn,++invNum));
			System.out.print("請問是否繼續輸入發票(y/n)?");
			String str = scn.next();
			tt = (str.equals("y")||str.equals("Y"))?true:false;
			System.out.println();
		}
	}
	public static void FucSetInvoice(ArrayList<Invoice> invList, Scanner scn){		//修改發票功能
		Invoice inv1;
		boolean t1 = true;
		String desc,mode1;
		double price;
		int invNum, qty;
		int invSize = invList.size();										//發票數量
		while(t1){
			System.out.print("請輸入功能(1)新增商品(2)修改商品(3)返回:");
			mode1 = scn.next();
			switch (mode1){
				case "1":		//新增商品
					FucShowInvoice(invList);								//顯示發票
					System.out.print("請輸入要修改第幾張發票(1~"+invSize+"):");
					invNum = getRangeNum(scn,invSize)-1;					//選擇發票
					inv1 = invList.get(invNum);								//發票物件
					System.out.println(inv1.showLine(32, "="));
					System.out.print("品項名稱:");
					desc = getStr(scn);
					System.out.print("商品單價:");
					price = getNum(scn);
					System.out.print("商品數量:");
					qty = getIntNum(scn);
					inv1.add(new Product(desc,price), qty);
					System.out.println("新增成功!");
					System.out.print(inv1.productFormat());			//顯示商品
					System.out.println(inv1.showLine(32, "="));
					break;
				case "2":		//修改商品
					FucShowInvoice(invList);								//顯示發票
					System.out.print("請輸入要修改第幾張發票(1~"+invSize+"):");
					invNum = getRangeNum(scn,invSize)-1;					//選擇發票
					inv1 = invList.get(invNum);								//發票物件
					System.out.println(inv1.showLine(32, "="));
					boolean t2 = true;
					while(t2){
						int proSize = inv1.getProductSize();				//商品數量
						if(proSize == 0){									//有無商品
							System.out.println("沒有商品了!");
							break;
						}else{
							System.out.print(inv1.productFormat());			//顯示商品
							System.out.println(inv1.showLine(32, "-"));
							System.out.print("請輸入要修改第幾項商品(1~"+proSize+"):");
							int proNum = getRangeNum(scn,proSize)-1;		//選擇商品
							System.out.print("請要修改選項(1)商品說明(2)商品單價(3)商品數量(4)返回:");
							switch (scn.next()){
								case "1":	//商品說明
									System.out.print("商品說明:");
									inv1.getProduct(proNum).setProDes(getStr(scn));
									System.out.println("修改成功!");
									break;
								case "2":	//商品單價
									System.out.print("商品單價:");
									inv1.getProduct(proNum).setProPri(getNum(scn));
									System.out.println("修改成功!");
									break;
								case "3":	//商品數量
									System.out.print("商品數量:");
									inv1.getProduct(proNum).setAmount(getIntNum(scn));
									System.out.println("修改成功!");
									break;
								case "4":	//返回
									t2 = false;
									break;
								default:
									System.out.println("沒有此選項!");
							}
							invList.get(0).showLine(32, "-");
						}
					}
					break;
				case "3":		//返回
					t1 = false;
					break;
				default:
					System.out.println("沒有此選項!");
			}
		}
	}
	public static void FucDelInvoice(ArrayList<Invoice> invList, Scanner scn){		//刪除發票功能
		boolean tt = true;
		int invNum;
		while(tt){
			if(invList.size()==0){	//有無發票判斷
				System.out.println("沒有發票了!");
				break;
			}else{
				System.out.print("請選擇功能(1)刪除發票(2)刪除商品(3)返回:");
				switch (scn.next()){
					case "1":		//刪除發票
						FucShowInvoice(invList);										//顯示發票
						System.out.print("請輸入要刪除第幾張發票(1~"+invList.size()+"):");
						invNum = getRangeNum(scn,invList.size())-1;						//選擇發票
						invList.remove(invNum);											//刪除整張發票
						System.out.println("發票刪除成功!");
						break;
					case "2":		//刪除商品
						FucShowInvoice(invList);										//顯示發票
						System.out.print("請選擇要第幾張發票(1~"+invList.size()+"):");
						invNum = getRangeNum(scn,invList.size())-1;						//選擇發票
						int proSize = invList.get(invNum).getProductSize();				//商品數量
						if(proSize == 0){
							System.out.println("沒有商品了!");
							break;
						}else{
							System.out.println(invList.get(invNum).productFormat());		//顯示商品
							System.out.print("請輸入要刪除第幾項商品(1~"+proSize+"):");
							int proNum = getRangeNum(scn,proSize)-1;
							invList.get(invNum).removeProduct(proNum);						//刪除商品
							System.out.println("商品刪除成功!");
							System.out.println("--------------------------------");
							System.out.println(invList.get(invNum).productFormat()+"\n");	//顯示商品
						}
						break;
					case "3":		//返回
						tt = false;
						break;
					default:
						System.out.println("沒有此選項!");
				}
			}
		}
	}
	public static void FucSearchInvoice(ArrayList<Invoice> invList, Scanner scn){	//搜尋發票功能
		boolean tt = true, findPro = false;
		String SearchName;
		ArrayList<LineItem> theItem;
		while(tt){
			findPro = false;
			System.out.print("請選擇功能(1)依商品名查詢(2)返回:");
			switch (scn.next()){
			case "1":				//依商品名查詢
				System.out.print("請輸入欲查詢商品名稱:");
				SearchName = getStr(scn);
				for(Invoice i: invList){
					theItem = i.getProduct();										//單發票所有商品
					for(LineItem j: theItem){
						if(SearchName.equals(j.getProDes())){
							System.out.println("<發票"+(invList.indexOf(i)+1)+">");	//發票位置
							String r=String.format("%-18s%15s%10s%25s\n","品項名稱","單價","數量","小計");
							System.out.println(r+j.format());						//商品資訊
							System.out.println("--------------------------------");
							findPro = true;
						}
					}	
				}
				if(!findPro){
					System.out.println("查無此商品!");
				}
				break;
			case "2":				//返回
				tt = false;
				break;
			default:
				System.out.println("沒有此選項!");
			}
		}
	}
	public static void FucShowInvoice(ArrayList<Invoice> invList){	//顯示發票功能
		int invNum = 0;
		for(Invoice inv:invList){
			inv.show(++invNum);
		}
	}
	public static String getStr(Scanner scn){					//判斷非空白字串
		String input = "";
		while(input.equals("")){
			input = scn.nextLine();
		}
		return input;
	}
	public static int getRangeNum(Scanner scn, int end){		//判斷整數範圍(0~end)
		int input = 0;
		boolean tt = true;
		while(tt){
			input = getIntNum(scn);
			if(0<input && input<=end){
				tt = false;
			}else{
				tt = true;
				System.out.println("數字範圍錯誤！");
			}	
		}
		return input;
	}
	public static int getIntNum(Scanner scn){					//判斷數字格式(整數)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.next();
			if(input.matches("[0-9]{1,}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("格式錯誤，請重新輸入！");
			}
		}
		return Integer.parseInt(input);
	}
	public static double getNum(Scanner scn){					//判斷數字格式(整數或小數點)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.next();
			if(input.matches("[0-9]{1,}\\.?[0-9]+")||input.matches("[0-9]{1,}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("格式錯誤，請重新輸入！");
			}
		}
		return Double.parseDouble(input);
	}
	public static String getPhoneNum(Scanner scn){			//判斷電話格式(2-8或4-6)
		String input = "";
		boolean tt = true;
		while(tt){
			input = scn.nextLine();
			if(input.matches("[0-9]{2}-[0-9]{8}||[0-9]{4}-[0-9]{6}") && !input.equals("")){
				tt = false;	
			}else{
				tt = true;
				System.out.println("格式錯誤，請重新輸入！");
			}
		}
		return input;
	}
	public static Invoice creatInvoice(Scanner scn,int invNumber){
		String s1,s2,s3,s4,desc;
		int numOfItems,qty;
		double price;
		System.out.println("=========<第"+invNumber+"張發票>=========");
		System.out.println("請輸入店名(ex.亞洲資工站):");
		s1 = getStr(scn);
		System.out.println("請輸入地址(ex.台中市霧峰區柳豐路500號):");
		s2 = getStr(scn);
		System.out.println("請輸入電話號碼(ex.04-12345678,0912-123456):");
		s3 = getPhoneNum(scn);
		System.out.println("請輸入傳真號碼(ex.04-12345678,0912-123456):");
		s4 = getPhoneNum(scn);
		Address add1 = new Address(s1,s2,s3,s4);
		Invoice inv1 = new Invoice(add1);
		System.out.println(inv1.showLine(32, "-"));
		System.out.print("請輸入商品總項數:");
		numOfItems = getIntNum(scn);
		for(int i=0 ; i<numOfItems ; i++){
			System.out.println("<商品"+(i+1)+">");
			System.out.print("商品說明:");
			desc = getStr(scn);
			System.out.print("商品單價:");
			price = getNum(scn);
			System.out.print("商品數量:");
			qty = getIntNum(scn);
			inv1.add(new Product(desc,price), qty);
			System.out.println(inv1.showLine(32, "="));
		}
		System.out.println();
		return inv1;
	}
}

