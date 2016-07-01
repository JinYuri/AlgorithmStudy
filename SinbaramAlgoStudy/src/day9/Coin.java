package day9;

import java.util.Scanner;

public class Coin {
	private static int[] coinMap = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		coinMap = new int[N];
		
		for(int i=0; i<N; ++i){
			coinMap[i] = sc.nextInt();
		}
		
		int W = sc.nextInt();
		int result = getCoinCount(W);
		if(result < 0){
			System.out.println("impossible");
		}
		else{
			System.out.println(result);
		}
		
		sc.close();
	}
	
	private static int getCoinCount(int w){
		if(w == 0){
			return 0;
		}
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<coinMap.length; ++i){
			int cost = coinMap[i];
			if(cost <= w){
				int temp = getCoinCount(w-cost)+1;
				if(temp > 0){
					result = Math.min(temp, result);
				}
			}
		}
		
		if(result == Integer.MAX_VALUE){
			result = -1;
		}
		
		return result;
	}
}
