import java.util.Scanner;

public class Main {
	static int ans, map[][], N, M, H;
	static final int verIdx[] = {0,1,3,5,7,9,11,13,15,17,19,21,23};
	static Scanner sc;
	static final int INF = 2131234232;
    public static void main(String[] args) {

    	sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	H = sc.nextInt();
    	map = new int[H+2][25];
    	
    	for(int i=1; i<=N; i++) {
    		for(int j=0; j<H+2; j++) {
    			map[j][verIdx[i]] = 1;
    		}
    	}
    	
    	for(int i=0; i<M; i++) {
    		int rowNum = sc.nextInt();
    		int verticalNum = sc.nextInt();
    		map[rowNum][verIdx[verticalNum]+1] = 1;
    	}
    	
    	ans = INF;
    	
    	// 시간 줄이는 법
    	// 답 0,1,2,3 나오는지를 순서대로 확인하면 앞에서 답이 나오는 경우에 뒤에껄 확인한 필요가 없음
    	
    	solution(1,1,0);
    	if(ans==INF) ans=-1;
    	System.out.println(ans);
    }
    
    static void solution(int row, int vert, int cnt) {

    	if(cnt>3 || verIdx[vert]>verIdx[N]) return;
    	
    	if(check()) {
    		ans = Math.min(ans, cnt);
    		return;
    	}
    	
    	for(int v=vert; v<=N; v++) {
    		if(cnt+1>ans) 
    		for(int r=row; r<=H; r++) {
    			if(map[r][verIdx[v]+1] == 1 || map[r][verIdx[v]-1] == 1) continue;
    			
    			map[r][verIdx[v]+1] = 1;
    			if(row+1>H) {
    				solution(1, v+1, cnt+1);
    			}
    			else {
    				solution(row+1, v, cnt+1);
    			}
    			map[r][verIdx[v]+1] = 0;
    		}
    	}
    }
    
    static boolean check() {
    	boolean isEqual = true;
    	
    	for(int v=1; v<=N; v++) {
    		int nowV = v;
    		int r = 0;
    		while(r<=H) {
    			if(map[r][verIdx[nowV]+1] == 1) {
    				nowV++;
    			}
    			else if(map[r][verIdx[nowV]-1] == 1) {
    				nowV--;
    			}
				r++;
    		}
    		if(nowV==v) continue;
    		isEqual = false;
    		break;
    	}
    	return isEqual;
    }
}