import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc;
	static int map[][], N, eatCnt, gbcSize, ans;
	static final int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
	static Point gbc;
    public static void main(String[] args) {

    	sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	map = new int[N][N];
    	
    	eatCnt = 0;
    	gbcSize = 2;
    	ans = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			map[i][j] = sc.nextInt();
    			if(map[i][j] == 9) {
    				gbc = new Point(i,j);
    			}
    		}
    	}
    	
    	while(true) {
    		Point nextP = new Point(0,0);
    		int minDis = findMinDis(nextP);
    		
    		if(minDis == -1) break;
    		
    		ans+=minDis;
    		
    		map[gbc.x][gbc.y ]= 0; 
    		gbc.x = nextP.x;
    		gbc.y = nextP.y;
    		
    		map[nextP.x][nextP.y] = 9; 
    		
    		eatCnt++;
    		
    		if(eatCnt == gbcSize) {
    			gbcSize++;
    			eatCnt = 0;
    		}
//    		System.out.println("이동수 : "+ans);
//    		System.out.println("현재위치 : "+gbc.x+" "+gbc.y);
//    		System.out.println("크기: "+gbcSize);
//    		System.out.println("먹은수: "+eatCnt);
//    		System.out.println("---------------");
    	}
    	
    	System.out.println(ans);
    }
    
    static int findMinDis(Point nextP) {
    	
    	Queue<Point> q = new LinkedList<>();
    	int nowMoveDis = 0;
    	int minDis = 0;
    	q.add(new Point(gbc.x, gbc.y));
    	
    	boolean visited[][] = new boolean[N][N];
    	visited[gbc.x][gbc.y] = true;
    	
    	while(!q.isEmpty()) {
    		int qSize = q.size();
    		
    		for(int size = 0; size<qSize; size++) {
    			Point nowP = q.poll();
        		
	    		for(int i=0; i<4; i++) {
	    			int nextX = nowP.x+dx[i];
	    			int nextY = nowP.y+dy[i];
	    			
	    			if(nextX<0 || nextY<0 || nextX>=N || nextY>=N || 
	    					visited[nextX][nextY] || gbcSize<map[nextX][nextY]) continue;
	    			else if(map[nextX][nextY] == 0 || map[nextX][nextY] == gbcSize) {
	    				visited[nextX][nextY] = true;
	    				q.add(new Point(nextX, nextY));
	    			} 
	    			else {
	    				if(minDis == 0) {
	    					nextP.x = nextX;
	    					nextP.y = nextY;
	    					minDis = nowMoveDis+1;
	    				} else if(nextX < nextP.x || ((nextX == nextP.x) && (nextY < nextP.y))) {
	    					nextP.x = nextX;
	    					nextP.y = nextY;
	    				} 
	    			}
	    		}
    		}
    		nowMoveDis++;
    		if(minDis!=0) return minDis;
    	}
    	
    	return -1;
    }
}