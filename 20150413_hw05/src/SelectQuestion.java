import java.util.ArrayList;
import java.util.Arrays;
public class SelectQuestion implements Complexity {		//選擇題
	private ArrayList<String> optArr ;
	private String Question, Answer;
	private int level;
	public SelectQuestion(String que, String ans, String... Options){	//建構元
		Question = que;
		Answer = ans;
		optArr = new ArrayList(Arrays.asList(Options));
	}
	public SelectQuestion(String que, String ans, int v1, String... Options){
		Question = que;		Answer = ans;
		optArr = new ArrayList(Arrays.asList(Options));
		level = v1;
	}
	public void addOptions(String option){				//新增選項
		optArr.add(option);
	}
	public void setComplexity(int v1) {level = v1;}		//設定題目難度
	public int getComplexity() {return level;}			//取得題目難度
	public String getTitle(){return Question;}			//取得題目
	public String getAns(){return Answer;}				//取得答案
	public ArrayList<String> getOption(){				//取得選項
		return optArr;
	}
}
