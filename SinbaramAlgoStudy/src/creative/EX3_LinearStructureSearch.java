package creative;

import java.util.Scanner;

public class EX3_LinearStructureSearch {
	private static int[] values = null;
	private static int target = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		values = new int[n];
		for(int i=0; i<n; ++i){
			values[i] = sc.nextInt();
		}
		target = sc.nextInt();
		System.out.println(solve(0, n-1));
		sc.close();
	}
	
	private static int solve(int start, int end){
		if(end-start < 0){
			return -1;
		}
		int middle = (start+end)/2;
		if(values[middle] == target){
			return middle+1;
		}
		else if(values[middle] > target){
			return solve(start, middle-1);
		}
		else{
			return solve(middle+1, end);
		}
	}
}
