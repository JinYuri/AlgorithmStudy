package creative.md.chap1;

import java.util.Scanner;

public class EX5_UpperBound {
	private static int[] values = null;
	private static int target = Integer.MAX_VALUE;
	private static int n = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		values = new int[n];
		for(int i=0; i<n; ++i){
			values[i] = sc.nextInt();
		}
		target = sc.nextInt();
		System.out.println(solve(0, n));
		sc.close();
	}
	private static int solve(int start, int end){
		if(end-start <= 0){
			return end+1;
		}
		int middle = (start+end)/2;
		if(values[middle] > target){
			return solve(start, middle);
		}
		else{
			return solve(middle+1, end);
		}
	}
}
