/*
 * 6236 용돈관리
 * 유형 : 이진탐색
 * 
 */

import java.util.Scanner;

public class Main {

	static int N, M, arr[], ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans=0;
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if(ans<arr[i])
				ans = arr[i];
		}
		
		int l = 0;
		int r = 1000000;
		int m = (l+r)/2;
		while(l<r) {
			int withdrawCnt = check(m);
			if(withdrawCnt>M) {
				l = m+1;
				m = (l+r)/2;
			}
			else {
				r = m;
				m = (l+r)/2;
			}
		}
		if(m>ans)
			ans=m;
			
		System.out.println(ans);
	}
	
	static int check(int m) {
		int max = m;
		int cnt=1;
		for(int i=0; i<N; i++) {
			if(arr[i]>m) {
				m=max;
				cnt++;
			}
			m-=arr[i];
		}
		return cnt;
	}
}