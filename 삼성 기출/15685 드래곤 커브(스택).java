import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int info[][], dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1};
	static boolean map[][];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new boolean[101][101];
		int ans=0;
		int N = sc.nextInt();
		info = new int[N][4];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<4; j++) {
				info[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) draw(i);
		
		for(int y=0; y<100; y++) {
			for(int x=0; x<100; x++) {
				if(map[y][x] && map[y][x+1] 
						&& map[y+1][x] && map[y+1][x+1])
					ans++;
			}
		}
		System.out.println(ans);
	}
	
	static void draw(int dNum) {
		LinkedList<Integer> list = new LinkedList();
		
		int x=info[dNum][0];
		int y=info[dNum][1];
		int d=info[dNum][2];
		int g=info[dNum][3];
		
		list.add(d);
		map[y][x] = true;
		
		for(int i=0; i<g; i++) {
			int size = list.size();
			Queue<Integer> tmpQ = new LinkedList();
			for(int j=size-1; j>=0; j--) {
				tmpQ.add((list.get(j)+1)%4);
			}
			while(!tmpQ.isEmpty()) list.add(tmpQ.poll());
		}
		
		while(!list.isEmpty()) {
			int direct = list.poll();
			
			x+=dx[direct];
			y+=dy[direct];
			
			map[y][x] = true;
		}
	}
}


