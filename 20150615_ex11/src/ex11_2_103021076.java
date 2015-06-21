
public class ex11_2_103021076 {
	static int count = 0;
	public static void main(String[] avg){
		int len = 8;
		int[][] img = randImg(len);
		boolean tt = false;
		String str = (TransCode(img,0,0,len/2,len,!tt))
				   + (TransCode(img,len/2,0,len,len,!tt));	//第一次直切
		System.out.println(str);
		System.out.println(toDec(str)+":"+str.length());
	}

	public static String TransCode(int[][] data, int x1, int y1, int x2, int y2, boolean tt){
		System.out.println("<"+(count++)+">("+x1+","+y1+" | "+x2+","+y2+"):"+tt);
		String str = "";
		try{
			str = check1(data, x1, y1, x2, y2);
			if(Math.abs(x1-x2)<=1 && Math.abs(y1-y2)<=1 ||(x1==x2 && x2==y1 && y2==1)){ //終止條件 x1 = x2
				return str;
			}else{
				if(tt){		//直切
					int xHalf = ((x1+x2)/2 == x1) ? x2:(x1+x2)/2;
					return str + (TransCode(data,x1,y1,xHalf,y2,!tt))
							   + (TransCode(data,xHalf,y1,x2,y2,!tt));
				}else{		//橫切
					int yHalf = ((y1+y2)/2 == y1) ? y2:(y1+y2)/2;
					return str + (TransCode(data,x1,y1,x2,yHalf,!tt))
							   + (TransCode(data,x1,yHalf,x2,y2,!tt));
				}
			}
		}catch(StackOverflowError ee){
			ee.printStackTrace();
			return str;
		}
	}
	public static String check1(int[][] data,int x1, int y1, int x2, int y2){
		String str = "";
		for(int i=y1 ; i<y2 ; i++){
			for(int j=x1 ; j<x2 ; j++){
				if(data[i][j] > 0){
					str = "1";
				}else{
					str = "0";
				}
			}
		}
		return str;
	}
	public static int[][] randImg(int len){
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
	public static int toDec(String dec){
		int sum = 0;
		for(int i=0 ; i<dec.length() ; i++){
			sum += Integer.parseInt(dec.substring(i,i+1))*Math.pow(2, i);
		}
		return sum;
	}
}
