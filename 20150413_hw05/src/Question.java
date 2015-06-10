
public class Question implements Complexity {		//簡答題
	private int level;
	private String Ans, Que;
	public Question(String s1, String s2){			//建構元
		Que = s1;	Ans = s2;
	}
	public Question(String s1, String s2, int v1){	//建構元
		Que = s1;	Ans = s2;	level = v1;
	}
	public void setComplexity(int v1){level = v1;}	//設定題目難度
	public int getComplexity(){return level;}		//取得題目難度
	public String getTitle(){return Que;}			//取得題目
	public String getAns(){return Ans;}				//取得答案
}
