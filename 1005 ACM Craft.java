/*
 * BOJ : 1005번
 * 유형 : DFS + memoization
 * 
 */


import java.util.*;

public class Main {
	static boolean map[][];
	static int conTime[], dp[];
	static int N, K, lastNode, ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int T=0; T<tc; T++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			map = new boolean[N+1][N+1];
			conTime = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				conTime[i] = sc.nextInt();
			}
			
			for(int i=1; i<=K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = true;
			}
			lastNode = sc.nextInt();
			dp = new int[N+1];
			Arrays.fill(dp, -1);
			
			ans = sol(lastNode);
			System.out.println(ans);
		}
	}
	
	static int sol(int node) {
		if(dp[node] != -1) return dp[node];
		
		int now = conTime[node];
		int max = now;
		
		for(int i=1; i<=N; i++) {
			if(!map[node][i]) continue; 
			max = Math.max(now + sol(i), max);
		}
		dp[node] = max;
		return dp[node];
	}
} 