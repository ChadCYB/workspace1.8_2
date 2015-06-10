package testProject;
public class test03 {
	public static void main(String[] args) {
		int aa = 1234;
		int bb = 2222;
		String str1 = String.valueOf(aa);
		String str2 = String.valueOf(9133);
		int count = 0;
		for(int i=0 ; i<4 ; i++){
			String a = str1.substring(i,i+1);
			String b = str2.substring(i,i+1);
			if(a.equals(b)){
				count++;
			}
		}
		System.out.println(count);


	}

}
