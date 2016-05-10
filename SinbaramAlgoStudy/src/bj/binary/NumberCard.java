package bj.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//https://www.acmicpc.net/problem/10815
public class NumberCard {
	private static List<Integer> cards = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0; i<n; ++i){
			cards.add(sc.nextInt());
		}
		Collections.sort(cards);
		
		int k = sc.nextInt();
		for(int i=0; i<k; ++i){
			System.out.print(findCard(sc.nextInt(), 0, n-1));
			System.out.print(" ");
		}
		
		sc.close();
	}
	
	private static int findCard(int m, int start, int end){
		if(start>end){
			return 0;
		}
		if(cards.get((start+end)/2) == m){
			return 1;
		}
		else if(cards.get((start+end)/2) > m){
			return findCard(m, start, ((start+end)/2)-1);
		}
		else{
			return findCard(m, ((start+end)/2)+1, end);
		}
		
	}
}
