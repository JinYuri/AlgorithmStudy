package bj.dynamic;

import java.util.Scanner;

public class UpStairs {
	private static int[] score = null;
	private static int[][] mem = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		score = new int[n];
		mem = new int[n][2];
		
		for(int i=0; i<n; ++i){
			score[i] = sc.nextInt();
		}
		System.out.println(getMaxScore(n-1,0));
		sc.close();
	}
	
	private static int getMaxScore(int n, int depth){
		if(mem[n][depth] != 0){
			return mem[n][depth];
		}
		int max = Integer.MIN_VALUE;
		// 처음 도착
		// 두번째인데 이미 두번 연속이면
		if((n==0) || (n==1 && depth == 1)){
			max = score[n];
		}
		else if(n==1){
			max = score[n]+getMaxScore(n-1, depth+1);
		}
		// 이미 2번 연속이라 전전으로
		else if(depth == 1){
			max = score[n]+getMaxScore(n-2, 0);
		}
		// 전/전전 비교해서 큰걸로
		else{
			max = getMaxScore(n-2, 0);
			int temp = getMaxScore(n-1, depth+1);
			if(temp > max){
				max = temp;
			}
			max += score[n];
		}
		mem[n][depth] = max;
		return max;
	}
}
