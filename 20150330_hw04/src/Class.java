
public class Class extends Subject{
	private String Credit,Score,Time;	//�Ǥ���,���Z,�W�Үɬq
	public Class(){}
	public Class(String name,String id,String tCredit, String tScore, String tTime){
		Name = name; ID = id;
		Credit = tCredit;
		Score = tScore;
		Time = tTime;
	}
	
	public void setCredit(String tCredit){Credit = tCredit;}
	public void setScore(String tScore){Score = tScore;}
	public void setTime(String tTime){Time = tTime;}
	public String getCredit(){return Credit;}
	public String getScore(){return Score;}
	public String getTime(){return Time;}
	
	public String getName() { return Name;}
	public String getID() { return ID;}
	public void show() {
		System.out.println("�ҵ{�W��:"+Name+" ("+ID+")"
						+"\n�Ǥ���:"+Credit
						+"\n���Z:"+Score
						+"\n�W�Үɬq:"+Time);
	}
}
