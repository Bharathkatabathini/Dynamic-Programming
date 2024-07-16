package dynamicprogramming;

import java.util.Arrays;

public class MaxSumofNonAdjacent {
//recursion
private int sum0(int[] arr,int n) {
if(n<0) return 0;
if(n==0) return arr[0];
int pick=arr[n]+sum0(arr,n-2);
int notpick=0+sum0(arr,n-1);
return Math.max(pick, notpick);
}


//memoization
private int sum(int[] arr,int n,int[] dp) {
	if(n==0) return arr[0];
	if(n<0) return 0;
	if(dp[n]!=-1) return dp[n];
	int pick=arr[n]+sum(arr,n-2,dp);
	int notpick=0+sum(arr,n-1,dp);
	
	return dp[n]=Math.max(pick, notpick);
	
}
//tabulization
private int sum1(int[] arr,int n,int[] dp) {
	dp[0] =0;
	if(n==0) return dp[0];
	
	for(int i=1;i<n;i++) {
		int pick=arr[n];
		if(i>1)
		pick=arr[n]+dp[i-2];
		int notpick=0+dp[i-1];
		dp[i]=Math.max(pick, notpick);
	}
	return dp[n];
	
	
}
//space optimized way
private int sum2(int[] arr, int n) {
	int prev=arr[0];
	int prev2=0;
	for(int i=1;i<=n;i++) {
		int pick=arr[i];
		if(i>1)
		pick=pick+prev2;
		int notpick=0+prev;
		int curi=Math.max(pick, notpick);
		prev2=prev;
		prev=curi;
	}
	return prev;
	
	
}
public static void main(String[] args) {
	MaxSumofNonAdjacent maxsum=	new MaxSumofNonAdjacent();
	int[] arr= {2,1,4,9};
	int n=arr.length-1;
	int[] dp=new int[n+1];
	Arrays.fill(dp, -1);
	int k0=maxsum.sum0(arr,n);
	int k=maxsum.sum(arr,n,dp);
	int k1=maxsum.sum1(arr,n,dp);
	int k2=maxsum.sum2(arr, n);
	System.out.println(k0);
	System.out.println(k);
	System.out.println(k1);
	System.out.println(k2);
}


}

