package day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class PageSwitcher {
	private static Graph[] gArr = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
//		Map<Integer, Vector<Integer>> map = new HashMap<>();
		gArr = new Graph[N];
		for(int i=0; i<N; ++i){
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
//			if(map.containsKey(from)){
//				map.get(from).addElement(to);
//			}else{
//				Vector<Integer> v = new Vector<>(1,1);
//				v.addElement(to);
//				map.put(from, v);
//			}
			if(gArr[i] == null){
				gArr[i] = new Graph();
			}
			if(gArr[from] == null){
				gArr[from].map.put(to, 1);
			}
		}
		
		// ª�� ������ Ŭ�� Ƚ���� ��
		// �� ������ ���ؼ� ��� Ŭ�� Ƚ�� ���ϱ�
		int pairCount = N*(N-1);
		sc.close();
	}
	
	private static int getBestPath(int from){
		if(gArr[from].map.containsKey(from)){
			
		}
		return 0;
	}
	public static class Graph{
		Map<Integer, Integer> map = new HashMap<>();
	}
}

