import java.util.ArrayList;
import java.util.Arrays;
public class SelectQuestion implements Complexity {		//����D
	private ArrayList<String> optArr ;
	private String Question, Answer;
	private int level;
	public SelectQuestion(String que, String ans, String... Options){	//�غc��
		Question = que;
		Answer = ans;
		optArr = new ArrayList(Arrays.asList(Options));
	}
	public SelectQuestion(String que, String ans, int v1, String... Options){
		Question = que;		Answer = ans;
		optArr = new ArrayList(Arrays.asList(Options));
		level = v1;
	}
	public void addOptions(String option){				//�s�W�ﶵ
		optArr.add(option);
	}
	public void setComplexity(int v1) {level = v1;}		//�]�w�D������
	public int getComplexity() {return level;}			//���o�D������
	public String getTitle(){return Question;}			//���o�D��
	public String getAns(){return Answer;}				//���o����
	public ArrayList<String> getOption(){				//���o�ﶵ
		return optArr;
	}
}
