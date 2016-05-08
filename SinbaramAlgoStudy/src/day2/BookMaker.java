package day2;

import java.util.Scanner;

public class BookMaker {
	private static int[][] mem = null;
	private static int[] files = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0; tc<t; ++tc){
			int k = sc.nextInt();
			files = new int[k];
			mem = new int[k][k];
			
			for(int i=0; i<k; ++i){
				files[i] = sc.nextInt();
			}
			System.out.println(getMinCost(0, k-1));
		}
		sc.close();
	}
	
	private static int getMinCost(int start, int end){
		if(mem[start][end] != 0){
			return mem[start][end];
		}
		if(end - start == 0){
			return 0;
		}
		else if(end - start == 1){
			int result = files[start]+files[end];
			mem[start][end] = result;
			return result;
		}
		else{
			int min = Integer.MAX_VALUE;
			int sum = files[end];
			for(int i=start; i<end; ++i){
				int temp = getMinCost(start, i) + getMinCost(i+1, end);
				if(min > temp){
					min = temp;
				}
				sum += files[i];
			}
			int result = sum+min;
			mem[start][end] = result;
			return result;
		}
	}
}
