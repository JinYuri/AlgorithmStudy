package day2;

import java.util.Scanner;

public class ColorPicker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int result = getCaseCount(n, k);
		System.out.println(result);
		
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
		
		// ���� ���� �������� ���� �������� �ʾ��� ���� ����� ���� ���Ͽ� ���Ѵ�.
		// 1,000,000,003�� ������?
		int count = (getCaseCount(n-2, k-1) + getCaseCount(n-1, k))%1000000003;
		return count;
	}
}
