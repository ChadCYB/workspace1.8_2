
public class Question implements Complexity {		//²���D
	private int level;
	private String Ans, Que;
	public Question(String s1, String s2){			//�غc��
		Que = s1;	Ans = s2;
	}
	public Question(String s1, String s2, int v1){	//�غc��
		Que = s1;	Ans = s2;	level = v1;
	}
	public void setComplexity(int v1){level = v1;}	//�]�w�D������
	public int getComplexity(){return level;}		//���o�D������
	public String getTitle(){return Que;}			//���o�D��
	public String getAns(){return Ans;}				//���o����
}
