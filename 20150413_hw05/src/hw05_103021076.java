/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/04/13
 * 	Uses: �����Ω�H���O�m��(�p�Ҩt��)
 * 	Java JDK: 1.6
 */
import java.util.Scanner;
import java.util.ArrayList;
public class hw05_103021076 {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		Question que1 = new Question("implements ������?","��@",1);
		Question que2 = new Question("extend ������?", "�X�i",2);
		YNQuestion ynQ1 = new YNQuestion("�׹��lpublic�i�H�O�@�{�����Q��Lpackage�{��Ū��",false,2);
		YNQuestion ynQ2 = new YNQuestion("��I�s�@�Ө�Ʈ�,�Ө�Ʀp�G�ݭn�^�ǭ�,�h�^�Ǹ�ƪ����O��return",true,1);
		SelectQuestion seleQ1 = new SelectQuestion("�b�]�p���O��, ���F���إߥX�Ӫ����󦳰ʧ@�i�H�ާ@�A�]���ݭn�U�C���?",
				"function member",2,"action function","member","function member","data member");
		SelectQuestion seleQ2 = new SelectQuestion("�ڭ̭n���դ@�Ӥ�k�i���i��N�����N��k��@�X�Ӷi��U�C���@�Ӱʧ@?",
				"experimental",3,"experimental","implmentation","explored","loading");
		SelectQuestion seleQ3 = new SelectQuestion("�ڭ̰��@��Ƴ������T���B�J�P�@�k, �N�o�ǰ��k���X�_�Ӻ٤���?",
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
			System.out.print("�п�ܼҦ�(1)�m��(2)�@��p��(3)������(4)������(5)���}:");
			int mode = scn.nextInt();
			System.out.println("================================");
			switch(mode){
				case 1:						//�m��
					practiceMode(prac1);
					break;
				case 2:						//�@��p��
					quizMode(quiz1);
					break;
				case 3:						//������
					midExamMode(mExam1);
					break;
				case 4:						//������
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
		int q1Num = fExam1.getQueNum();			//²���D��
		int q2Num = fExam1.getYNNum();			//�O�D�D��
		int q3Num = fExam1.getSelectNum();		//����D��
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num = (q1Num+q2Num+q3Num), CorrectNum = 0;
		String input;
		System.out.println("�t�Υ������D�üƥX�D");
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//²���D
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(²���D): ");
					System.out.println(fExam1.getQuestion(rand));
					check[rand] = true;
					System.out.print("����: ");
					input = scn.next();
					if(fExam1.checkQueAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+fExam1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//�O�D�D
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(�O�D�D): ");
					System.out.println(fExam1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("����(True,False): ");
					input = scn.next();
					if(fExam1.checkYNAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+fExam1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//����D
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(����D): ");
					System.out.println(fExam1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//�ﶵ�p��
					ArrayList<String> opt = fExam1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("����: ");
					input = scn.next();
					if(fExam1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+fExam1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("��������@"+num+"�D�A����F"+CorrectNum+"�D");
	}
	private static void midExamMode(MidExam mExam1) {
		int q1Num = mExam1.getQueNum();			//²���D��
		int q2Num = mExam1.getYNNum();			//�O�D�D��
		int q3Num = mExam1.getSelectNum();		//����D��
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num = 5, CorrectNum = 0;
		String input;
		System.out.println("�t���H���X�D�A�@5�D");
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//²���D
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(²���D): ");
					System.out.println(mExam1.getQuestion(rand));
					check[rand] = true;
					System.out.print("����: ");
					input = scn.next();
					if(mExam1.checkQueAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+mExam1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//�O�D�D
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(�O�D�D): ");
					System.out.println(mExam1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("����(True,False): ");
					input = scn.next();
					if(mExam1.checkYNAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+mExam1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//����D
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(����D): ");
					System.out.println(mExam1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//�ﶵ�p��
					ArrayList<String> opt = mExam1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("����: ");
					input = scn.next();
					if(mExam1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+mExam1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("��������@"+num+"�D�A����F"+CorrectNum+"�D");
	}

	private static void quizMode(Quiz q1) {
		String input;
		int qNum = q1.getQueNum(), CorrectNum = 0;
		for(int i=0 ; i<qNum ; i++){
			System.out.println("��"+(i+1)+"�D: "+q1.getQuestion(i));
			System.out.print("����: ");
			input = scn.next();
			if(q1.checkQueAns(i, input)){
				System.out.println("���ߧA����F!");
				CorrectNum ++;
			}else{
				System.out.println("Oops~�A�����F!(���T����:"+q1.getQueAnswer(i)+")");
			}
		}
		System.out.println("-------------------------");
		System.out.println("��������@"+qNum+"�D�A����F"+CorrectNum+"�D");
	}

	private static void practiceMode(Practice p1) {
		int q1Num = p1.getQueNum();			//²���D��
		int q2Num = p1.getYNNum();			//�O�D�D��
		int q3Num = p1.getSelectNum();		//����D��
		boolean[] check = new boolean[q1Num+q2Num+q3Num];
		int rand, num, CorrectNum = 0;
		String input;
		System.out.print("�H���X�D�A�п�J(1~"+(q1Num+q2Num+q3Num)+"�D)?");
		do{
			num = scn.nextInt();
		}while(!(0<num && num<=(q1Num+q2Num+q3Num)));
		for(int i=0 ; i<num ; i++){
			switch((int)(Math.random()*3)){
			case 0:												//²���D
				rand = (int)(Math.random()*q1Num);
				if(check[rand]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(²���D): ");
					System.out.println(p1.getQuestion(rand));
					check[rand] = true;
					System.out.print("����: ");
					input = scn.next();
					if(p1.checkQueAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+p1.getQueAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 1:												//�O�D�D
				rand = (int)(Math.random()*q2Num);
				if(check[rand+q1Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(�O�D�D): ");
					System.out.println(p1.getYNQuestion(rand));
					check[rand+q1Num] = true;
					System.out.print("����(True,False): ");
					input = scn.next();
					if(p1.checkYNAns(rand, input)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+p1.getYNAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			case 2:												//����D
				rand = (int)(Math.random()*q3Num);
				if(check[rand+q1Num+q2Num]){
					i--;
				}else{
					System.out.print("��"+(i+1)+"�D(����D): ");
					System.out.println(p1.getSeleQuestion(rand));
					check[rand+q1Num+q2Num] = true;
					int optCount = 1;	//�ﶵ�p��
					ArrayList<String> opt = p1.getRandSeleOpt(rand);
					for(String str:opt){
						System.out.println("("+ optCount++ +")"+str);
					}
					System.out.print("����: ");
					input = scn.next();
					if(p1.checkSelectAns(rand, Integer.parseInt(input), opt)){
						System.out.println("���ߧA����F!");
						CorrectNum ++;
					}else{
						System.out.println("Oops~�A�����F!(���T����:"+p1.getSelectAnswer(rand)+")");
					}
					System.out.println("-------------------------");
				}
				break;
			}
		}
		System.out.println("��������@"+num+"�D�A����F"+CorrectNum+"�D");
	}
}
