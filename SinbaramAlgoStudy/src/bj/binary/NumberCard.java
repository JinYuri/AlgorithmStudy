package bj.binary;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class NumberCard {
	private static int[] cards = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		
		int n = sc.nextInt();
		cards = new int[n];
		for(int i=0; i<n; ++i){
			cards[i] = sc.nextInt();
		}
		Arrays.sort(cards);
		
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; ++i){
			sb.append(findCard(sc.nextInt(), 0, n-1)).append(" ");
		}
		System.out.print(sb.toString());
		sc.close();
	}
	
	private static int findCard(int m, int start, int end){
		if(start>end){
			return 0;
		}
		int idx = (start+end)/2;
		int temp = cards[idx];
		if(temp == m){
			return 1;
		}
		else if(temp > m){
			return findCard(m, start, idx-1);
		}
		else{
			return findCard(m, idx+1, end);
		}
		
	}
}
