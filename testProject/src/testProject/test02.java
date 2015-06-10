package testProject;

import java.util.ArrayList;
import java.util.Scanner;

public class test02 {
	public static void main(String avgs[]) {
		java.util.Scanner scn = new java.util.Scanner(System.in);
		int aa = scn.nextInt();
		System.out.println(FibonacciNumber(aa));
	}

	static int FibonacciNumber(int X) {
		 ArrayList<Integer> A = new ArrayList<Integer>();
		  A.add(0);
		  A.add(1);
		  int sum = 0, i = 2;
		  while(i <= X){
		    A.add(A.get(i-1)+A.get(i++-2));
		  }
		  for(int n:A){
		    sum += n;
		  }	
		  return  sum % 10007;
	}
}
