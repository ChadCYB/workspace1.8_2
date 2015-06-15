
public class ex11_2_103021076 {
	public static void main(String[] avg){
		int[][] img = randImg();
//		int x1 = 0;
//		int y1 = img.length;
//		int x2 = 0;
//		int y2 = img.length;
		System.out.println(TransCode(img,0,img.length,0,img.length,false));
	}
	public static String TransCode(int[][] data, int x1, int y1, int x2, int y2, boolean tt){
		int len = data.length;
		for(int i=x1 ; i<x2 ; i++){
			for(int j=y1 ; j<y2 ; j++){
				if(data[i][j] > 0){
					return "1";
				}else{
					return "0";
				}
			}
		}
	//²×¤î±ø¥ó x1 = x2
		String str = (TransCode(data,0,len/2)) + (TransCode(data,len/2,len));
		return str;
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
