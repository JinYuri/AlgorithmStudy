package bj.camp;

import java.util.Scanner;

public class PapaerScissorsRock {
	private static int[] teacher = null;
	private static int[][] students = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		students = new int[N][2];
		teacher = new int[M];
		
		for(int i=0; i<N; ++i){
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
		
		
		sc.close();
	}
	
	private boolean areWePassed(int idx){
		boolean result = true;
		
		int first = students[idx][0]; 
		int second = students[idx][1];
		
		
		
		return result;
	}
}
