package day6;

import java.util.Scanner;

public class YogurtFactory {
	private static int[][] costMap = null;
	private static int S = 0;
	private static int N = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		costMap = new int[N][2];
		long result = 0;
		
		for(int i=0; i<N; i++){
			costMap[i][0] = sc.nextInt();
			costMap[i][1] = sc.nextInt();
			result += calCost(i);
		}
		System.out.println(result);
		sc.close();
	}
	
	public static long calCost(int n){
		long cost = costMap[n][0];
		for(int i=0; i<=n; ++i){
			cost = Math.min(costMap[i][0]+((n-i)*S), cost);
		}
		
		return cost*costMap[n][1];
	}
}
