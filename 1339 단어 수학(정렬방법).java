/*
 * ���� : �ܾ� ����(1339)
 * ���ٹ� : ����Ž��(��Ʈ��ŷ) �Ǵ� ����
 * 
 */

// ���� ��� : ����Ž�� ��Ʈ��ŷ�� ���� 10�� �ӵ� ���̳�
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] alpabet = new int[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String inputString;
		
		for(int i = 0; i < N; i++) {
			inputString = sc.next();
			int temp = 1;
			for(int j = inputString.length() - 1; j >= 0; j--) {
				alpabet[inputString.charAt(j) - 65] = alpabet[inputString.charAt(j) - 65] + temp;
				temp = temp * 10;
			}
		}
		Arrays.sort(alpabet);
		
		int sum = 0;
		int mul = 9;
		for(int i = alpabet.length - 1; i > 15; i--) {
			sum = sum + mul * alpabet[i];
			mul--;
		}
		System.out.println(sum);
		
		sc.close();
	}
}