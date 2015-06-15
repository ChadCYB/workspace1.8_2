
public class ex11_1_103021076 {
	public static void main(String[] avg){
		int[][] img = randImg();
		System.out.println(method03(img,0,img.length));
	}
	public static String method03(int[][] data, int a, int b){
		int len = data.length;
		String str = "";
		for(int i=a ; i<b ; i++){
			for(int j=a ; j<b ; j++){
				if(data[i][j] > 0){
					return "1";
				}else{
					return "0";
				}
			}
		}
		str += (method03(data,0,len/2)) + (method03(data,len/2,len));
		return str;
	}
	public static void method01(){
		int len = 8;
		int[][] R = new int[len][len];
		int[][] G = new int[len][len];
		int[][] B = new int[len][len];
		
		B[3][5] = 255;	B[4][5] = 255;
		B[3][6] = 255;	B[4][6] = 255;
		G[3][5] = 255;	G[4][5] = 255;
		G[3][6] = 255;	G[4][6] = 255;
		
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				System.out.print("["+R[i][j]+","+G[i][j]+","+B[i][j]+"]\t");
			}
			System.out.println();
		}
	}
	public static void method02(){
		int len = 8;
		boolean[][] data = new boolean[len][len];
		data[2][4] = true;	data[3][4] = true;
		data[2][5] = true;	data[3][5] = true;
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				System.out.print("["+((data[i][j])?1:0)+"]\t");
			}
			System.out.println();
		}
	}
	public static int[][] randImg(){
		int len = 8;
		int[][] arr = new int[len][len];
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				arr[i][j] = (int)(Math.random()*3);
			}
		}
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				System.out.print("["+arr[i][j]+"]\t");
			}
			System.out.println();
		}	
		return arr;
	}
}
