package testProject;

public class test01 {

	public static void main(String[] args) {
		InSide II = new InSide();
		II.show();
	}
	static class InSide {
		public InSide(){
			System.out.println("Inside");
		}
		public void show(){
			System.out.println("showInside");
		}
	}
}