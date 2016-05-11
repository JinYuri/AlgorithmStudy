package bj.binary;

import java.util.Scanner;

public class NumberCard3 {
	private static boolean[] cards = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		cards = new boolean[20000000];
		for(int i=0; i<n; ++i){
			cards[sc.nextInt() + 10000000] = true;
		}
		
		int k = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<k; ++i){
			sb.append(cards[sc.nextInt()+10000000] ? 1 : 0).append(" ");
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
