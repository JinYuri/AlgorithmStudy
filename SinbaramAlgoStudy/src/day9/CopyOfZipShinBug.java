package day9;

import java.util.Scanner;

public class CopyOfZipShinBug {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //�¾�� a�� �� ��ü
		int b = sc.nextInt(); //�¾�� b�� �� ���� stop
		int d = sc.nextInt(); //�¾�� d�� �� ��� �Ф�
		int N = sc.nextInt(); //���ϰ��� �ϴ� ����
		
		int[] counts = new int[d]; //��ü�� ����
		counts[a-1] = 1;
		int result = 0;
		
		for(int i=a-1; i<N; ++i){
			int prev = counts[0];
			int newCount = 0;
			for(int j=1; j<d; ++j){
				int temp = counts[j];
				counts[j] = prev;
				prev = temp;
				if(a < j+1 && j < b){
					newCount += counts[j]%1000;
				}
			}
			counts[0] = newCount;
		}
		
		for(int j=0; j<d; ++j){
			result += counts[j]%1000;
		}
		System.out.println(result%1000);
		sc.close();
	}
}
