/*
 * 문제 : 단어 수학(1339)
 * 접근법 : 완전탐색(백트래킹) 또는 정렬
 * 
 */

// 완전탐색 백트래킹 : 순열(퍼뮤테이션) 접근법으로 풀었으며, 정렬 접근법보다 10배 느림
import java.util.Scanner;

public class Main {
	static int N, alphabat[], matchCnt, match[];
	static String str[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		str = new String[N];
		alphabat = new int[26];
		matchCnt = 0;
		
		for(int i=0; i<N; i++) {
			str[i] = sc.nextLine();
			for(int j=0; j<str[i].length(); j++) {
				if(alphabat[str[i].charAt(j)-65]==0) {
					alphabat[str[i].charAt(j)-65]++;
					matchCnt++;
				}
			}
		}
		match = new int[matchCnt];
		int j=0;
		for(int i=0; i<26; i++) {
			if(alphabat[i]==1) {
				match[j++] = i;
			}
		}
		System.out.println(dfs(0,0,0));
	}
	
	static int dfs(int visited, int cnt, int total) {
		if(cnt==matchCnt) return total;
		
		int ret=0;
		for(int next=9; next>9-matchCnt; next--) {
			if(((1<<next)&visited)==0) {
				ret = Math.max(ret, dfs((1<<next)|visited, cnt+1, total+cal(next, cnt)));
			}
		}
		return ret;
	}

	static int cal(int num, int alpha) {
		int ret=0;
		int position=1;
		for(int i=0; i<N; i++) {
			position=1;
			for(int j=str[i].length()-1; j>=0; j--) {
				if(str[i].charAt(j)-65==match[alpha]) {
					ret+=num*position;
				} 
				position*=10;
			}
		}
		return ret;
	}
}