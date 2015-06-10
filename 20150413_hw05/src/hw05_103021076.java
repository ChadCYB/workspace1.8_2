/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/04/13
 * 	Uses: 介面及抽象類別練習(小考系統)
 * 	Java JDK: 1.6
 */
import java.util.Scanner;
import java.util.ArrayList;
public class hw05_103021076 {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		Question que1 = new Question("implements 的中文?","實作",1);
		Question que2 = new Question("extend 的中文?", "擴展",2);
		YNQuestion ynQ1 = new YNQuestion("修飾子public可以保護程式不被其他package程式讀取",false,2);
		YNQuestion ynQ2 = new YNQuestion("當呼叫一個函數時,該函數如果需要回傳值,則回傳資料的指令為return",true,1);
		SelectQuestion seleQ1 = new SelectQuestion("在設計類別時, 為了讓建立出來的物件有動作可以操作，因此需要下列何者?",
				"function member",2,"action function","member","function member","data member");
		SelectQuestion seleQ2 = new SelectQuestion("我們要測試一個方法可不可行就必須將方法實作出來進行下列哪一個動作?",
				"experimental",3,"experimental","implmentation","explored","loading");
		SelectQuestion seleQ3 = new SelectQuestion("我們做一件事都有明確的步驟與作法, 將這些做法集合起來稱之為?",
				"procedure",3,"analysis","procedure","program","step collection");
		
		Practice prac1 = new Practice();
		prac1.addQuestion(que1);
		prac1.addQuestion(que2);
		prac1.addYNQuestion(ynQ1);
		prac1.addYNQuestion(ynQ2);
		prac1.addSeleQuestion(seleQ1);
		prac1.addSeleQuestion(seleQ2);
		prac1.addSeleQuestion(seleQ3);
		Quiz quiz1 = new Quiz();
		quiz1.addQuestion(que1);
		quiz1.addQuestion(que2);
		MidExam mExam1 = new MidExam();
		mExam1.addQuestion(que1);
		mExam1.addQuestion(que2);
		mExam1.addYNQuestion(ynQ1);
		mExam1.addYNQuestion(ynQ2);
		mExam1.addSeleQuestion(seleQ1);
		mExam1.addSeleQuestion(seleQ2);
		mExam1.addSeleQuestion(seleQ3);
		FinalExam fExam1 = new FinalExam();
		fExam1.addQuestion(que1);
		fExam1.addQuestion(que2);
		fExam1.addYNQuestion(ynQ1);
		fExam1.addYNQuestion(ynQ2);
		fExam1.addSeleQuestion(seleQ1);
		fExam1.addSeleQuestion(seleQ2);
		fExam1.addSeleQuestion(seleQ3);
		boolean tt = true;
		
		while(tt){
			System.out.print("請選擇模式(1)練習(2)一般小考(3)期中考(4)期末考(5)離開:");
			int mode = scn.nextInt();
			System.out.println("================================");
			switch(mode){
				case 1:						//練習
					practiceMode(prac1);
					break;
				case 2:						//一般小考
					quizMode(quiz1);
					break;
				case 3:						//期中考
					midExamMode(mExam1);
					break;
				case 4:						//期末考
					finalExamMode(fExam1);
					break;
				default:
					tt = false;
					break;
			}
		}
		System.out.println("BYE~");
	}

	private static void finalExamMode(FinalExam fExam1) {
		int q1Num = fExam1.getQueNum();			//簡答題數
		int q2Num = fExam1.getYNNum();			//是非題數
		int q3Num = fExam1.getSelectNum();		//選擇題數
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num = (q1Num+q2Num+q3Num), CorrectNum = 0;
		String input;
		System.out.println("系統全部考題亂數出題");
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//簡答題
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(簡答題): ");
					System.out.println(fExam1.getQuestion(rand));
					check[rand] = true;
					System.out.print("答案: ");
					input = scn.next();
					if(fExam1.checkQueAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+fExam1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//是非題
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(是非題): ");
					System.out.println(fExam1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("答案(True,False): ");
					input = scn.next();
					if(fExam1.checkYNAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+fExam1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//選擇題
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(選擇題): ");
					System.out.println(fExam1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//選項計數
					ArrayList<String> opt = fExam1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("答案: ");
					input = scn.next();
					if(fExam1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+fExam1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("本次測驗共"+num+"題，答對了"+CorrectNum+"題");
	}
	private static void midExamMode(MidExam mExam1) {
		int q1Num = mExam1.getQueNum();			//簡答題數
		int q2Num = mExam1.getYNNum();			//是非題數
		int q3Num = mExam1.getSelectNum();		//選擇題數
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num = 5, CorrectNum = 0;
		String input;
		System.out.println("系統隨機出題，共5題");
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//簡答題
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(簡答題): ");
					System.out.println(mExam1.getQuestion(rand));
					check[rand] = true;
					System.out.print("答案: ");
					input = scn.next();
					if(mExam1.checkQueAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+mExam1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//是非題
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(是非題): ");
					System.out.println(mExam1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("答案(True,False): ");
					input = scn.next();
					if(mExam1.checkYNAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+mExam1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//選擇題
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(選擇題): ");
					System.out.println(mExam1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//選項計數
					ArrayList<String> opt = mExam1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("答案: ");
					input = scn.next();
					if(mExam1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+mExam1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("本次測驗共"+num+"題，答對了"+CorrectNum+"題");
	}

	private static void quizMode(Quiz q1) {
		String input;
		int qNum = q1.getQueNum(), CorrectNum = 0;
		for(int i=0 ; i<qNum ; i++){
			System.out.println("第"+(i+1)+"題: "+q1.getQuestion(i));
			System.out.print("答案: ");
			input = scn.next();
			if(q1.checkQueAns(i, input)){
				System.out.println("恭喜你答對了!");
				CorrectNum ++;
			}else{
				System.out.println("Oops~你答錯了!(正確答案:"+q1.getQueAnswer(i)+")");
			}
		}
		System.out.println("-------------------------");
		System.out.println("本次測驗共"+qNum+"題，答對了"+CorrectNum+"題");
	}

	private static void practiceMode(Practice p1) {
		int q1Num = p1.getQueNum();			//簡答題數
		int q2Num = p1.getYNNum();			//是非題數
		int q3Num = p1.getSelectNum();		//選擇題數
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num, CorrectNum = 0;
		String input;
		System.out.print("隨機出題，請輸入(1~"+(q1Num+q2Num+q3Num)+"題)?");
		do{
			num = scn.nextInt();
		}while(!(0<num && num<=(q1Num+q2Num+q3Num)));
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//簡答題
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(簡答題): ");
					System.out.println(p1.getQuestion(rand));
					check[rand] = true;
					System.out.print("答案: ");
					input = scn.next();
					if(p1.checkQueAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+p1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//是非題
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(是非題): ");
					System.out.println(p1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("答案(True,False): ");
					input = scn.next();
					if(p1.checkYNAns(rand, input)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+p1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//選擇題
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("第"+(i+1)+"題(選擇題): ");
					System.out.println(p1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//選項計數
					ArrayList<String> opt = p1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("答案: ");
					input = scn.next();
					if(p1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("恭喜你答對了!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~你答錯了!(正確答案:"+p1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("本次測驗共"+num+"題，答對了"+CorrectNum+"題");
	}
}
