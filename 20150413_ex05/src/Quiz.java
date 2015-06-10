import java.util.ArrayList;
public class Quiz extends Exam{
	private ArrayList<Question> queArr = new ArrayList<Question>();
	public Quiz(){ }		//�غc��
	public void addQuestion(String que, String ans) {	//�s�W�D��
		queArr.add(new Question(que, ans));
	}
	public String getQuestion(int n) {					//���o�D��
		return queArr.get(n).getTitle();
	}
	public String getAnswer(int n){						//���o����
		return queArr.get(n).getAns();
	}
	public int getNum(){								//�@���X�D
		return queArr.size();
	}
	public void setComplexity(int n, int level){		//�]�w����
		queArr.get(n).setComplexity(level);
	}
	public boolean checkAns(int n, String userAns) {	//�ˬd����
		if(queArr.get(n).getAns().equals(userAns)){
			return true;
		}else{
			return false;
		}
	}
	
}
