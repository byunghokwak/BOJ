import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		N = sc.nextInt();
		M = sc.nextInt();
		
		Node first = new Node(null, 1);
		first.next = first;
		Node before = first;
		
		if(N==1) {
			System.out.println("<"+1+">");
			return;
		}
		for(int i=2; i<=N; i++) {
			Node newNode = new Node(first, i);
			before.next = newNode;
			before = newNode;
		}
		
		Node tail = before;
		Node now = tail;
		boolean isStart=true;
		while(now!=now.next) {
			if(!isStart) {
				sb.append(", ");
			}
			isStart=false;
			for(int i=0; i<M-1; i++) {
				now = now.next;
			}
			before = now;
			now = now.next;
			if(now == tail.next)
				tail.next = now.next;
			sb.append(now.num);
			before.next = now.next;
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}

class Node {
	Node next;
	int num;
	Node(Node next, int num) {
		this.next = next;
		this.num = num;
	}
}