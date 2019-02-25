import java.util.*;

class BFS {
	long [][] tempMap = new long[21][21];	
	long [][] tempMap2;	
	
	void dfsCall() {

		long[] temp = new long[Main.N+1];
		int k;
		int head=0, rear=0;
		int b;
	
		while(true) {
			tempMap = Main.q.poll();	

			// depth 5이면 나가기
			if(tempMap[0][0] >= 5) {
				Main.q.add(tempMap); // 뺀거 원위치
				return;
			}
			tempMap2 = new long[21][21];
//****************** 오른쪽으로 옮기기*************************
			for(int i=1; i<=Main.N; i++) {
				k=1;
				//한개 행 중, 숫자 있는 것만 선택해서 복사
				for(int j=1; j<=Main.N; j++) {
					long a = tempMap[i][j];
					if(tempMap[i][j] != 0) {
						temp[k] = tempMap[i][j];
						k++;
					}
				}

				// 같은 숫자 합치기
				for(int m=Main.N; m>1; m--) {
					if(temp[m]!=0){
						if(temp[m] == temp[m-1]) {
							temp[m] = temp[m] + temp[m-1];
							temp[m-1] = 0;
							m--;
						}
					}
				}

				// 합친거 한쪽으로 몰기
				for(int m=Main.N; m>1; m--) {
					if(temp[m] == 0) {
						for(int n=m-1; n>=1; n--) {
							if(temp[n]!=0) {
								temp[m] = temp[n];
								temp[n] = 0;
								break;
							}
						}
					}
				}
				
				// 원래 배열(tempMap)에 넣기
				for(int j=1; j<=Main.N; j++)
						tempMap2[i][j] = temp[j];
				
				//정리 위한 임시 배열 초기화
				for(int j=0; j<=Main.N; j++)
					temp[j] = 0;
			} 
			
			tempMap2[0][0] = tempMap[0][0]+1;
			Main.q.add(tempMap2);
					
//**************** 왼쪽으로 옮기기*************************
			tempMap2 = new long[21][21];
			
			for(int i=1; i<=Main.N; i++) {
				k=1;
				//한개 행 중, 숫자 있는 것만 선택해서 복사
				for(int j=1; j<=Main.N; j++) {
					if(tempMap[i][j] != 0) {
						temp[k] = tempMap[i][j];
						k++;
					}
				}
				//rear=1; head = rear+1;
				// 같은 숫자 합치기
				for(int m=1; m<Main.N; m++) {
					if(temp[m]!=0){
						if(temp[m] == temp[m+1]) {
							temp[m] = temp[m] + temp[m+1];
							temp[m+1] = 0;
							m++;
						}
					}
				}
			
				// 합친거 한쪽으로 몰기
				for(int m=1; m<=Main.N-1; m++) {
					if(temp[m] == 0) {
						for(int n=m+1; n<=Main.N; n++) {
							if(temp[n]!=0) {
								temp[m] = temp[n];
								temp[n] = 0;
								break;
							}
						}
					}
				}
				// 원래 배열(tempMap)에 넣기
				for(int j=1; j<=Main.N; j++)
					tempMap2[i][j] = temp[j];
				
				//정리 위한 임시 배열 초기화
				for(int j=0; j<=Main.N; j++)
					temp[j] = 0;
			} 

			tempMap2[0][0] = tempMap[0][0]+1;
			Main.q.add(tempMap2);
		
//	**************** 윗쪽으로 옮기기*************************
			tempMap2 = new long[21][21];
			
			for(int j=1; j<=Main.N; j++) {
				k=1;

				//한개 행 중, 숫자 있는 것만 선택해서 복사
				for(int i=1; i<=Main.N; i++) {
					if(tempMap[i][j] != 0) {
						temp[k] = tempMap[i][j];
						k++;
					}
				}
				
				for(int m=1; m<Main.N; m++) {
					if(temp[m]!=0){
						if(temp[m] == temp[m+1]) {
							temp[m] = temp[m] + temp[m+1];
							temp[m+1] = 0;
							m++;
						}
					}
				}
				
				// 합친거 한쪽으로 몰기
				for(int m=1; m<=Main.N-1; m++) {
					if(temp[m] == 0) {
						for(int n=m+1; n<=Main.N; n++) {
							if(temp[n]!=0) {
								temp[m] = temp[n];
								temp[n] = 0;
								break;
							}
						}
					}
				}				
				// 원래 배열(tempMap)에 넣기
				for(int i=1; i<=Main.N; i++)
					tempMap2[i][j] = temp[i];
				//정리 위한 임시 배열 초기화
				for(int i=0; i<=Main.N; i++)
					temp[i] = 0;
			} 
			tempMap2[0][0] = tempMap[0][0]+1;
			Main.q.add(tempMap2);
			
			// tempMap = tempMap2.clone(); : Call By Reference
							
//	**************** 아래쪽으로 옮기기 *************************
			tempMap2 = new long[21][21];
			for(int j=1; j<=Main.N; j++) {
				k=1;
				//한개 행 중, 숫자 있는 것만 선택해서 복사
				for(int i=1; i<=Main.N; i++) {
					if(tempMap[i][j] != 0) {
						temp[k] = tempMap[i][j];
						k++;
					}
				}
				rear=Main.N; head = rear-1;
				// 같은 숫자 합치기
				for(int m=Main.N; m>1; m--) {
					if(temp[m]!=0){
						if(temp[m] == temp[m-1]) {
							temp[m] = temp[m] + temp[m-1];
							temp[m-1] = 0;
							m--;
						}
					}
				}	
				// 합친거 한쪽으로 몰기
				for(int m=Main.N; m>1; m--) {
					if(temp[m] == 0) {
						for(int n=m-1; n>=1; n--) {
							if(temp[n]!=0) {
								temp[m] = temp[n];
								temp[n] = 0;
								break;
							}
						}
					}
				}
				// 원래 배열(tempMap)에 넣기
				for(int i=1; i<=Main.N; i++)
						tempMap2[i][j] = temp[i];
				//정리 위한 임시 배열 초기화
				for(int i=0; i<=Main.N; i++)
					temp[i] = 0;
			} 
			tempMap2[0][0] = tempMap[0][0]+1;
			Main.q.add(tempMap2);
			
		}	// 전체 while
	} //dfs 함수 끝
	
	long malValueFind() {
		long [][] tempMap = new long[21][21];		
		long maxNum=0;
		while(!Main.q.isEmpty()) {
			tempMap = Main.q.poll();
			for(int j=1; j<=Main.N; j++) {
				for(int k=1; k<=Main.N; k++) {
					if(maxNum < tempMap[j][k]){
						maxNum = tempMap[j][k];
					}
				}
			}
		}
		return maxNum;
	}
}

public class Main {
	static int N; 
	long [][] map;
	static Queue <long [][]> q = new LinkedList <long [][]>();

	public static void main(String[] args) {

		long[][] MAP = new long[21][21];
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 배열 크기 입력
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				MAP[i][j] = sc.nextInt();
			}
		}
		
		MAP[0][0] = 0; // bdf depth 표기
		
		q.add(MAP);
		
		// BSF(5), 객체생성(깊이 5인
		BFS bfsStart = new BFS();
		bfsStart.dfsCall();
		
		System.out.println(bfsStart.malValueFind());
	}
} 