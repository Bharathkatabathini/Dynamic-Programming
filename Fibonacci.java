package dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
	//using recursion
	//Time complexity O(2^n)
	//Space complexity O(n)(we are using recursion stack)
	int fibo(int n) {
		//base case
		if(n<=1) return n;//5
		return fibo(n-1)+fibo(n-2);//fibo(4)
		
	}
	//Using dp[] array
	//Time complexity O(n)
	//Space complexity O(n)(Reason: we are using recursion stack again)
	int fibodp(int n) {
		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		if(n<=1) {
			return n;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		return dp[n]= fibodp(n-1)+fibodp(n-2);
		
	}
	//Using dp[] array
	//Time complexity O( reason : we elminated the array)
	int fibo1(int k) {
		int prev2=0;
		int prev=1;
		int ans=0;
		for(int i=2;i<k;i++) {
			ans=prev+prev2;
		}
		return ans;
	}
	public static void main(String[] args) {
		Fibonacci f=new Fibonacci();
		int k=f.fibo(7);
		int k1=f.fibodp(7);
		int k2=f.fibodp(7);
		System.out.println(k);
		System.out.println(k1);
		System.out.println(k2);
	}
}

