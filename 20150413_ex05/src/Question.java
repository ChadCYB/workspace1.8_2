
public class Question implements Complexity {
	private int level;
	private String Ans, Que;
	public Question(String s1, String s2){	//�غc��
		Que = s1;
		Ans = s2;
	}
	public void setComplexity(int v1) {		//�]�w�D������
		level = v1;
	}
	public int getComplexity() {			//���o�D������
		return level;
	}
	public String getTitle(){				//���o�D��
		return Que;
	}
	public String getAns(){					//���o����
		return Ans;
	}
	
}
