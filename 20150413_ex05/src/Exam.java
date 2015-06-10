
public abstract class Exam {
	public abstract void addQuestion(String ans, String que);
	public abstract String getQuestion(int n);
	public abstract boolean checkAns(int n, String userAns);
}
