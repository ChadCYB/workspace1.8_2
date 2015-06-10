package testProject;

import java.util.Scanner;

public class test04 {
	public static void main(String [] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(fun(n,0));
	}
	public static int fun(int n,int c){
		if(n>=2){
			int m = n%2;
			int k = n/2;
			if(n%2 == 1){
				c++;
			}
			return fun(k,c);
		}else{
			if(n==1){
				c++;
			}
			return c;
		}
	}
}	 
