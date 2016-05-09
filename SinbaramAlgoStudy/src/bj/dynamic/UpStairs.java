package bj.dynamic;

import java.util.Scanner;

public class UpStairs {
	private static int[] score = null;
	private static int N = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		score = new int[N];
		
		for(int i=0; i<N; ++i){
			score[i] = sc.nextInt();
		}
		System.out.println(getMaxScore(0,0));
		sc.close();
	}
	
	private static int getMaxScore(int n, int depth){
		int max = Integer.MIN_VALUE;
		if((N-n == 2) || (N-n == 3 && depth >=1)){
			max = score[n] + score[N-1];
		}
		else if(depth == 2){
			// 다다음
			max = score[n]+getMaxScore(n+2, 1);
		}
		else{
			// 다음/다다음
			max = getMaxScore(n+2, 1);
			int temp = getMaxScore(n+1, ++depth);
			if(temp > max){
				max = temp;
			}
			max += score[n];
		}
		return max;
	}
}
