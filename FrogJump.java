package dynamicprogramming;

import java.util.Arrays;
//REcursive way
public class FrogJump {
	int mincost(int n,int[] cost) {
		if(n==0) return 0;
		if(n==1)  return Math.abs(cost[1]-cost[0]);
		int l=mincost(n-1,cost)+Math.abs(cost[n]-cost[n-1]);
		int r=Integer.MAX_VALUE;
		if(n>=2) {
			r=mincost(n-2,cost)+Math.abs(cost[n]-cost[n-2]);
		}
		
		return Math.min(l, r);
		
	}//memoization
	int mincost(int n,int[] cost,int[] dp){
		
		Arrays.fill(dp, -1);
		dp[1]=Math.abs(cost[1]-cost[0]);
		if(n==0) return 0;
		if(n==1) return dp[1];
		if(dp[n]!=-1) return dp[n];
		int l=mincost((n-1),cost,dp)+Math.abs(cost[n]-cost[n-1]);
		int r=Integer.MAX_VALUE;
		if(n>=2) {
			r=mincost((n-2),cost,dp)+Math.abs(cost[n]-cost[n-2]);
		}
		
		
		return Math.min(l, r);
	}

    public static void main(String[] args) {
    	int[] cost={30,10,60,10,60,50};
    	int n=cost.length;
    	int[] dp=new int[cost.length];
    	FrogJump jump=new FrogJump();
		int k=jump.mincost(n-1,cost );
		int k1=jump.mincost(n-1,cost,dp);
		int k2=jump.mincost2(n-1, cost);
		System.out.println(k+" "+k1+" "+k2);
	}//tabulization way
	private int mincost2(int n, int[] cost) {
		int prev=0;
		int prev2=0;
		if(n==0) return 0;
		if(n==1) return Math.abs(cost[1]-cost[0]);
		
		for(int i=1;i<=n;i++) {
			int j2=Integer.MAX_VALUE;
			int j1=prev+Math.abs(cost[i]-cost[i-1]);//20
			if(i>1)
			j2=prev2+Math.abs(cost[i]-cost[i-2]);
			int curi=Math.min(j2, j1);
			prev2=prev;
			prev=curi;
			
		}
		return prev;
	}
}
