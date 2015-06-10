import java.util.ArrayList;
public class Quiz extends Exam{
	private ArrayList<Question> queArr = new ArrayList<Question>();
	public Quiz(){ }		//建構元
	public void addQuestion(String que, String ans) {	//新增題目
		queArr.add(new Question(que, ans));
	}
	public String getQuestion(int n) {					//取得題目
		return queArr.get(n).getTitle();
	}
	public String getAnswer(int n){						//取得答案
		return queArr.get(n).getAns();
	}
	public int getNum(){								//共有幾題
		return queArr.size();
	}
	public void setComplexity(int n, int level){		//設定難度
		queArr.get(n).setComplexity(level);
	}
	public boolean checkAns(int n, String userAns) {	//檢查答案
		if(queArr.get(n).getAns().equals(userAns)){
			return true;
		}else{
			return false;
		}
	}
	
}
