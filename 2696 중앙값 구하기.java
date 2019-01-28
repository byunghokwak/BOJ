import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			int arr[] = new int[N];
			
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();

			for(int i=1; i<=N; i+=2) {
				int[] tmp = Arrays.copyOf(arr, i);
				Arrays.sort(tmp);
				sb.append(tmp[i/2]+" ");
			}
			
			System.out.println((N+1)/2);
			System.out.println(sb.toString());
		}
	}
}
