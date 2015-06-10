
public class YNQuestion implements Complexity {		//是非題
	private int level;
	private boolean Ans;
	private String Que;
	public YNQuestion(String s1, boolean tt){		//建構元
		Que = s1;	Ans = tt;
	}
	public YNQuestion(String s1, boolean tt, int v1){//建構元
		Que = s1;	Ans = tt;	level = v1;
	}
	public void setComplexity(int v1){level = v1;}	//設定題目難度
	public int getComplexity(){return level;}		//取得題目難度
	public String getTitle(){return Que;}			//取得題目
	public String getAns(){							//取得答案
		return (Ans)?"True":"False";
	}
}
