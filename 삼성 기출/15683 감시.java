import java.awt.Point;
import java.util.Scanner;

public class Main {
	static int N, M, map[][], cctvCnt, ans;
	static final int CHECK=10, ERASE = 11;
	static Point[] cctv;
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctvCnt=0;
		int roomCnt=0;
		cctv = new Point[8];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(1<=map[i][j] && map[i][j]<=5) {
					cctv[cctvCnt++] = new Point(i,j);
				}
				if(map[i][j] == 0) roomCnt++;
			}
		}
		ans=roomCnt;
		dfs(0);
		System.out.println(ans);
	}
	
	static void dfs(int cctvNum) {
		
		if(cctvNum>=cctvCnt) {
			ans = Math.min(ans, blindSpotCheck());
			return;
		}
		
		int x = cctv[cctvNum].x;
		int y = cctv[cctvNum].y;
		
		if(map[x][y] == 1) {
			for(int next=0; next<4; next++) {
				cctvView(next, x, y, CHECK);
				dfs(cctvNum+1);
				cctvView(next, x, y, ERASE);
			}
		} else if(map[x][y] == 2) {
			for(int next=0; next<2; next++) {
				cctvView(next, x, y, CHECK);
				cctvView(next+2, x, y, CHECK);
				dfs(cctvNum+1);
				cctvView(next, x, y, ERASE);
				cctvView(next+2, x, y, ERASE);
			}
		} else if(map[x][y] == 3) {
			for(int next=0; next<4; next++) {
				cctvView(next, x, y, CHECK);
				cctvView((next+1)%4, x, y, CHECK);
				dfs(cctvNum+1);
				cctvView(next, x, y, ERASE);
				cctvView((next+1)%4, x, y, ERASE);
			}
		} else if(map[x][y] == 4) {
			for(int next=0; next<4; next++) {
				cctvView(next, x, y, CHECK);
				cctvView((next+1)%4, x, y, CHECK);
				cctvView((next+2)%4, x, y, CHECK);
				dfs(cctvNum+1);
				cctvView(next, x, y, ERASE);
				cctvView((next+1)%4, x, y, ERASE);
				cctvView((next+2)%4, x, y, ERASE);
			}
		} else {
			for(int next=0; next<4; next++) {
				cctvView(next, x, y, CHECK);
			}
			dfs(cctvNum+1);
			for(int next=0; next<4; next++) {
				cctvView(next, x, y, ERASE);
			}
		}
	}
	
	static void cctvView(int arrow, int x, int y, int mode) {
		// →
		if(arrow==0) {
			checkRight(x,y,mode);
		}
		// ↓
		else if(arrow==1) {
			checkDown(x,y,mode);
		}
		// ←
		else if(arrow==2) {
			checkLeft(x,y,mode);
		} 
		// ↑
		else {
			checkUp(x,y,mode);
		}
	}
	
	static int blindSpotCheck() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	// mode 1 : 체크, 0:지우기 
	static void checkDown(int x, int y, int mode) {
		if(mode==CHECK) {
			for(int i=x+1; i<N; i++) {
				if(1<=map[i][y] && map[i][y]<=5) continue;
				if(map[i][y]==6) break;
				map[i][y]--;
			}
		}
		else {
			for(int i=x+1; i<N; i++) {
				if(1<=map[i][y] && map[i][y]<=5) continue;
				if(map[i][y]==6) break;
				map[i][y]++;
			}
		}
	}
	static void checkUp(int x, int y, int mode) {
		if(mode==CHECK) {
			for(int i=x-1; i>=0; i--) {
				if(1<=map[i][y] && map[i][y]<=5) continue;
				if(map[i][y]==6) break;
				map[i][y]--;
			}
		}
		else {
			for(int i=x-1; i>=0; i--) {
				if(1<=map[i][y] && map[i][y]<=5) continue;
				if(map[i][y]==6) break;
				map[i][y]++;
			}
		}
	}
	static void checkLeft(int x, int y, int mode) {
		if(mode==CHECK) {
			for(int j=y-1; j>=0; j--) {
				if(1<=map[x][j] && map[x][j]<=5) continue;
				if(map[x][j]==6) break;
				map[x][j]--;
			}
		}
		else {
			for(int j=y-1; j>=0; j--) {
				if(1<=map[x][j] && map[x][j]<=5) continue;
				if(map[x][j]==6) break;
				map[x][j]++;
			}
		}
	}
	static void checkRight(int x, int y, int mode) {
		if(mode==CHECK) {
			for(int j=y+1; j<M; j++) {
				if(1<=map[x][j] && map[x][j]<=5) continue;
				if(map[x][j]==6) break;
				map[x][j]--;
			}
		}
		else {
			for(int j=y+1; j<M; j++) {
				if(1<=map[x][j] && map[x][j]<=5) continue;
				if(map[x][j]==6) break;
				map[x][j]++;
			}
		}
	}
}