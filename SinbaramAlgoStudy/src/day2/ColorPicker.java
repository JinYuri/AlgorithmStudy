package day2;

import java.util.Scanner;

public class ColorPicker {
	public static int[][] mem = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		mem = new int[n+1][k+1];
		
		sc.close();
		
		System.out.println(getCaseCount(n, k));
		
	}
	
	private static int getCaseCount(int n, int k){
		// n�� �� 1�� ���� ����� ���� n
		if(k == 1){
			return n;
		}
		// ����� �� ���ų�
		// n�� �� max�� �� �� �ִ� ������ Ŭ ��
		if(k == 0 || (n/2) < k){
			return 0;
		}
		
		if(mem [n][k] == 0){
			// ���� ���� �������� ���� �������� �ʾ��� ���� ����� ���� ���Ͽ� ���Ѵ�.
			// 1,000,000,003�� ������?
			mem [n][k] = (getCaseCount(n-2, k-1) + getCaseCount(n-1, k))%1000000003;
		}
		
		return mem [n][k];
	}
}
