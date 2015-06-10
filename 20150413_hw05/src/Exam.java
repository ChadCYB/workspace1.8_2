
public abstract class Exam {
	public abstract void addQuestion(String ans, String que);
	public abstract String getQuestion(int n);
	public abstract boolean checkQueAns(int n, String userAns);
}
