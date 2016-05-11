package bj.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberCard {
	private static List<Integer> cards = new ArrayList<>();
	private static Map<Integer, Integer> mem = new HashMap<>();
	private static Map<Integer, Integer> iMap = new HashMap<>();
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
		if(mem.containsKey(m)){
			return mem.get(m);
		}
		if(start>end){
			mem.put(m, 0);
			return 0;
		}
		int idx = (start+end)/2;
		int temp = cards.get(idx);
		mem.put(temp, 1);
		
		int iIdx = temp/5;
		if(iMap.containsKey(iIdx)){
			int tempStart = iMap.get(iIdx);
			if(tempStart < start){
				iMap.put(iIdx, start);
			}
			else{
				start = tempStart;
			}
		}else{
			iMap.put(iIdx, start);
		}
		
		if(iMap.containsKey(iIdx+1)){
			int tempEnd = iMap.get(iIdx+1);
			if(tempEnd < end && start < tempEnd){
				end = tempEnd;
			}
		}
		
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
