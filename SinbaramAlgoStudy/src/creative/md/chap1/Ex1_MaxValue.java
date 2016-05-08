package creative.md.chap1;

import java.util.Scanner;

public class Ex1_MaxValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 9; // fixed
		int max = sc.nextInt();
		int idx = 1;
		
		for(int i=1; i<n; ++i){
			int temp = sc.nextInt();
			if(temp > max){
				max = temp;
				idx = i+1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
		
		sc.close();
	}
}
