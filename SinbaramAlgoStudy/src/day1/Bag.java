package day1;

import java.util.Scanner;

public class Bag {
	private static int[] values = null;
	private static int[] weights = null;
	private static int N = 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int w = sc.nextInt();
		
		weights = new int[N];
		values = new int[N];
		
		for(int i=0; i<N; ++i){
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		System.out.println(getMaxValue(0, w));
		sc.close();
	}
	
	private static int getMaxValue(int n, int lw){
		// 갯수가 끝난 경우 끝
		if(n >= N){
			return 0;
		}
		// 남은 배낭 용량이 없는 경우 담을 수 없다.
		else if(lw<=0){
			return 0;
		}
		// 보석의 무게가 남은 배낭의 용량보다 큰 경우 skip
		else if(weights[n]>lw){
			return getMaxValue(n+1, lw);
		}
		
		// 이 보석을 넣었을 때와 넣지 않았을 때 중 큰 값으로
		int inValue = values[n] + getMaxValue(n+1, lw-weights[n]);
		int outValue = getMaxValue(n+1, lw);
		if(inValue > outValue){
			return inValue;
		}
		
		return outValue;
	}
}
