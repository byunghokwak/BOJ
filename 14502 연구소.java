import java.util.Scanner;
public class Main {
	static int N, M, map[][], ans, dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		ans=0;
		map = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++) 
				map[i][j] = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) continue;
				Wall(i, j, 0);
				map[i][j] = 0;
			}
		}
		System.out.println(ans);
	}
	
	static void Wall(int x, int y, int cnt) {
		map[x][y]=1;

		if(cnt==2) {
			int[][] testMap = copy();
			int safeZone = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					Virus(testMap, i, j);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(testMap[i][j]==0)
						safeZone++;
				}
			}
			if(safeZone>ans)
				ans = safeZone;
			return;
		}
		
		for(int i=x; i<N; i++) {
			if(i==x) {
				for(int j=y+1; j<M; j++) {
					if(map[i][j]>0) continue;
					Wall(i, j, cnt+1);
					map[i][j] = 0;
				}
			}
			else {
				for(int j=0; j<M; j++) {
					if(map[i][j]>0) continue;
					Wall(i, j, cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void Virus(int[][] testMap, int x, int y) {
		if(testMap[x][y]<2) return;
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX>=0 && nextX<N && nextY>=0 && nextY<M) {
				if(testMap[nextX][nextY]==0) {
					testMap[nextX][nextY]=2;
					Virus(testMap, nextX, nextY);
				}
			}
		}
	}
	
	static int[][] copy() {
		int[][] t = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				t[i][j] = map[i][j];
			}
		}
		return t;
	}
}