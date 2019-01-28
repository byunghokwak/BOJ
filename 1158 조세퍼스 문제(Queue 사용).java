import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		N = sc.nextInt();
		M = sc.nextInt();
		
		Queue q = new LinkedList<>();
		
		for(int i=1; i<=N; i++)
			q.add(i);
		
		while(q.size()>1) {
			int cnt = 0;
			while(cnt < M-1) {
				q.add(q.poll());
				cnt++;
			}
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		System.out.println(sb.toString());
	}
}
