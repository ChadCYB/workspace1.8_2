
public class YNQuestion implements Complexity {		//�O�D�D
	private int level;
	private boolean Ans;
	private String Que;
	public YNQuestion(String s1, boolean tt){		//�غc��
		Que = s1;	Ans = tt;
	}
	public YNQuestion(String s1, boolean tt, int v1){//�غc��
		Que = s1;	Ans = tt;	level = v1;
	}
	public void setComplexity(int v1){level = v1;}	//�]�w�D������
	public int getComplexity(){return level;}		//���o�D������
	public String getTitle(){return Que;}			//���o�D��
	public String getAns(){							//���o����
		return (Ans)?"True":"False";
	}
}
