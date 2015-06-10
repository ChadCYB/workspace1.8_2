
public class Class extends Subject{
	private String Credit,Score,Time;	//學分數,成績,上課時段
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
		System.out.println("課程名稱:"+Name+" ("+ID+")"
						+"\n學分數:"+Credit
						+"\n成績:"+Score
						+"\n上課時段:"+Time);
	}
}
