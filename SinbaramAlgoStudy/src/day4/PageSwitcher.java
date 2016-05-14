package day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class PageSwitcher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Map<Integer, Vector<Integer>> map = new HashMap<>();
		
		for(int i=0; i<N; ++i){
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			if(map.containsKey(from)){
				map.get(from).addElement(to);
			}else{
				Vector<Integer> v = new Vector<>(1,1);
				v.addElement(to);
				map.put(from, v);
			}
		}
		
		// ÂªÀº ÆäÀÌÁö Å¬¸¯ È½¼öÀÇ ÇÕ
		// ½Ö °¹¼ö¸¦ ±¸ÇØ¼­ Æò±Õ Å¬¸¯ È½¼ö ±¸ÇÏ±â
		int pairCount = N*(N-1);
		sc.close();
	}
	
	private static int getBestPath(int from, int to){
		return 0;
	}
}
