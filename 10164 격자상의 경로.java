/*
 * 10164 격자상의 경로
 * 2018.06.13 KWAK
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M, P, dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		
		dp = new int[N][M];
		
		for(int i=0; i<N; i++)
			dp[i][0] = 1;
		Arrays.fill(dp[0], 1);
		
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		if(P>0) {
			int x = (P-1)/M;
			int y = (P-1)-x*M;
			
			for(int i=x; i<N; i++)
				dp[i][y] = dp[x][y];
			Arrays.fill(dp[x], dp[x][y]);
			
			for(int i=x+1; i<N; i++) {
				for(int j=y+1; j<M; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}