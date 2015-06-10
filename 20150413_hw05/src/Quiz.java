import java.util.ArrayList;
public class Quiz extends Exam{
	protected ArrayList<Question> queArr = new ArrayList<Question>();
	public Quiz(){ }		//建構元
	public void addQuestion(String que, String ans) {	//新增簡答題目
		queArr.add(new Question(que, ans));
	}
	public void addQuestion(Question que) {				//新增簡答題目
		queArr.add(que);
	}
	public String getQuestion(int n) {					//取得簡答題目
		return queArr.get(n).getTitle();
	}
	public String getQueAnswer(int n){					//取得簡答答案
		return queArr.get(n).getAns();
	}
	public int getQueNum(){								//共有幾題簡答
		return queArr.size();
	}
	public void setQueComplexity(int n, int level){		//設定簡答難度
		queArr.get(n).setComplexity(level);
	}
	public boolean checkQueAns(int n, String userAns) {	//檢查簡答答案
		if(queArr.get(n).getAns().equals(userAns)){
			return true;
		}else{
			return false;
		}
	}	
}
