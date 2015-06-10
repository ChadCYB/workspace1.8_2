import java.util.ArrayList;
public class MidExam extends Quiz{
	protected ArrayList<YNQuestion> ynQueArr = new ArrayList<YNQuestion>();
	protected ArrayList<SelectQuestion> seleQueArr = new ArrayList<SelectQuestion>();
	public MidExam(){}
	public void addYNQuestion(String que, boolean ans){		//�s�W�O�D�D��
		ynQueArr.add(new YNQuestion(que,ans));
	}
	public void addYNQuestion(YNQuestion que){				//�s�W�O�D�D��
		ynQueArr.add(que);
	}
	public void addSeleQuestion(String que, String ans, String... Options){	//�s�W����D��
		seleQueArr.add(new SelectQuestion(que,ans,Options));
	}
	public void addSeleQuestion(SelectQuestion que){		//�s�W����D��
		seleQueArr.add(que);
	}
	public String getYNQuestion(int n) {					//���o�O�D�D��
		return ynQueArr.get(n).getTitle();
	}
	public String getSeleQuestion(int n) {					//���o����D��
		return seleQueArr.get(n).getTitle();
	}
	public ArrayList<String> getSeleOpt(int n){				//���o��ܿﶵ
		return seleQueArr.get(n).getOption();
	}
	public ArrayList<String> getRandSeleOpt(int n){			//���o�H���ﶵ
		ArrayList<String> rndOpt = new ArrayList<String>();	//�ŧi�üƿﶵ�}�C
		int optNum = this.getSeleOpt(n).size();				//���o�ﶵ�ƶq
		boolean[] tt = new boolean[optNum];
		for(int i=0 ; i<optNum ; i++){
			int randNum = (int)(Math.random()*optNum);
			if(tt[randNum]){
				i--;
			}else{
				rndOpt.add(this.getSeleOpt(n).get(randNum));//�[�J�ﶵ
				tt[randNum] = true;
			}
		}
		return rndOpt;
	}
	public String getYNAnswer(int n){						//���o�O�D����
		return ynQueArr.get(n).getAns();
	}
	public String getSelectAnswer(int n){					//���o��ܵ���
		return seleQueArr.get(n).getAns();
	}
	public int getYNNum(){									//�@���X�D�O�D
		return ynQueArr.size();
	}
	public int getSelectNum(){								//�@���X�D���
		return seleQueArr.size();
	}
	public void setYNComplexity(int n, int level){			//�]�w�O�D����
		ynQueArr.get(n).setComplexity(level);
	}
	public void setSelectComplexity(int n, int level){		//�]�w�������
		seleQueArr.get(n).setComplexity(level);
	}
	public boolean checkYNAns(int n, String userAns){		//�ˬd�O�D����
		return(ynQueArr.get(n).getAns().equals(userAns));
	}
	public boolean checkSelectAns
	(int n, int userAns, ArrayList<String> optArr){			//�ˬd��ܵ���
		String selectAns = optArr.get(userAns-1);			//�ϥΪ̵���
		return (selectAns.equals(this.getSelectAnswer(n)));
	}
}