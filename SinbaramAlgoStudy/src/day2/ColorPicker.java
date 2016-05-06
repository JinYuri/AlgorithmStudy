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
		// n개 중 1를 고르는 경우의 수는 n
		if(k == 1){
			return n;
		}
		// 경우의 수 없거나
		// n개 중 max로 고를 수 있는 수보다 클 때
		if(k == 0 || (n/2) < k){
			return 0;
		}
		
		if(mem [n][k] == 0){
			// 현재 것을 선택했을 때와 선택하지 않았을 때의 경우의 수를 구하여 더한다.
			// 1,000,000,003로 나눈다?
			mem [n][k] = (getCaseCount(n-2, k-1) + getCaseCount(n-1, k))%1000000003;
		}
		
		return mem [n][k];
	}
}
