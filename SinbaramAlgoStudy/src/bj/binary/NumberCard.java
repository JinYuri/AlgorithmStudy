package bj.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
	private static int[] cards = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; ++i){
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; ++i){
			sb.append(findCard(Integer.parseInt(st.nextToken()), 0, n-1)).append(" ");
		}
		System.out.print(sb.toString());
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
