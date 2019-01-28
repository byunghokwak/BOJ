import java.util.Scanner;

public class Main {
	static int a,b,c,cnt;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		cnt = sc.nextInt();
		
		int aMax = cnt/a;
		int bMax = cnt/b;
		int cMax = cnt/c;
		for(int i=0; i<=aMax; i++) {
			int num = a*i;
			for(int j=0; j<=bMax; j++) {
				num+=b*j;
				for(int k=0; k<=cMax; k++) {
					num+=c*k;
					if(cnt==num) {
						System.out.println(1);
						return;
					}
					num-=c*k;
				}
				num-=b*j;
			}
		}
		System.out.println(0);
	}
}
