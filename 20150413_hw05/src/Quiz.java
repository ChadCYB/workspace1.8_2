import java.util.ArrayList;
public class Quiz extends Exam{
	protected ArrayList<Question> queArr = new ArrayList<Question>();
	public Quiz(){ }		//�غc��
	public void addQuestion(String que, String ans) {	//�s�W²���D��
		queArr.add(new Question(que, ans));
	}
	public void addQuestion(Question que) {				//�s�W²���D��
		queArr.add(que);
	}
	public String getQuestion(int n) {					//���o²���D��
		return queArr.get(n).getTitle();
	}
	public String getQueAnswer(int n){					//���o²������
		return queArr.get(n).getAns();
	}
	public int getQueNum(){								//�@���X�D²��
		return queArr.size();
	}
	public void setQueComplexity(int n, int level){		//�]�w²������
		queArr.get(n).setComplexity(level);
	}
	public boolean checkQueAns(int n, String userAns) {	//�ˬd²������
		if(queArr.get(n).getAns().equals(userAns)){
			return true;
		}else{
			return false;
		}
	}	
}
