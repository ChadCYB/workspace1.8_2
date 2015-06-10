import java.util.ArrayList;
public class MidExam extends Quiz{
	protected ArrayList<YNQuestion> ynQueArr = new ArrayList<YNQuestion>();
	protected ArrayList<SelectQuestion> seleQueArr = new ArrayList<SelectQuestion>();
	public MidExam(){}
	public void addYNQuestion(String que, boolean ans){		//新增是非題目
		ynQueArr.add(new YNQuestion(que,ans));
	}
	public void addYNQuestion(YNQuestion que){				//新增是非題目
		ynQueArr.add(que);
	}
	public void addSeleQuestion(String que, String ans, String... Options){	//新增選擇題目
		seleQueArr.add(new SelectQuestion(que,ans,Options));
	}
	public void addSeleQuestion(SelectQuestion que){		//新增選擇題目
		seleQueArr.add(que);
	}
	public String getYNQuestion(int n) {					//取得是非題目
		return ynQueArr.get(n).getTitle();
	}
	public String getSeleQuestion(int n) {					//取得選擇題目
		return seleQueArr.get(n).getTitle();
	}
	public ArrayList<String> getSeleOpt(int n){				//取得選擇選項
		return seleQueArr.get(n).getOption();
	}
	public ArrayList<String> getRandSeleOpt(int n){			//取得隨機選項
		ArrayList<String> rndOpt = new ArrayList<String>();	//宣告亂數選項陣列
		int optNum = this.getSeleOpt(n).size();				//取得選項數量
		boolean[] tt = new boolean[optNum];
		for(int i=0 ; i<optNum ; i++){
			int randNum = (int)(Math.random()*optNum);
			if(tt[randNum]){
				i--;
			}else{
				rndOpt.add(this.getSeleOpt(n).get(randNum));//加入選項
				tt[randNum] = true;
			}
		}
		return rndOpt;
	}
	public String getYNAnswer(int n){						//取得是非答案
		return ynQueArr.get(n).getAns();
	}
	public String getSelectAnswer(int n){					//取得選擇答案
		return seleQueArr.get(n).getAns();
	}
	public int getYNNum(){									//共有幾題是非
		return ynQueArr.size();
	}
	public int getSelectNum(){								//共有幾題選擇
		return seleQueArr.size();
	}
	public void setYNComplexity(int n, int level){			//設定是非難度
		ynQueArr.get(n).setComplexity(level);
	}
	public void setSelectComplexity(int n, int level){		//設定選擇難度
		seleQueArr.get(n).setComplexity(level);
	}
	public boolean checkYNAns(int n, String userAns){		//檢查是非答案
		return(ynQueArr.get(n).getAns().equals(userAns));
	}
	public boolean checkSelectAns
	(int n, int userAns, ArrayList<String> optArr){			//檢查選擇答案
		String selectAns = optArr.get(userAns-1);			//使用者答案
		return (selectAns.equals(this.getSelectAnswer(n)));
	}
}