package bj.binary;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberCard {
	private static Set<Integer> cards = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		cards = new HashSet<>();
		for(int i=0; i<n; ++i){
			cards.add(sc.nextInt());
		}
		
		int k = sc.nextInt();
		for(int i=0; i<k; ++i){
			if(cards.contains(sc.nextInt())){
				System.out.print(1);
			}
			else{
				System.out.print(0);
			}
			System.out.print(" ");
		}
		sc.close();
	}
}
