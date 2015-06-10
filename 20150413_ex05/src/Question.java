
public class Question implements Complexity {
	private int level;
	private String Ans, Que;
	public Question(String s1, String s2){	//建構元
		Que = s1;
		Ans = s2;
	}
	public void setComplexity(int v1) {		//設定題目難度
		level = v1;
	}
	public int getComplexity() {			//取得題目難度
		return level;
	}
	public String getTitle(){				//取得題目
		return Que;
	}
	public String getAns(){					//取得答案
		return Ans;
	}
	
}
