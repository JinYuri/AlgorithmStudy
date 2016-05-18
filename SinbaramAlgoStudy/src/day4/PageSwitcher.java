package day4;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PageSwitcher {
	private static Map<Integer, Map<Integer, Integer>> gMap = new HashMap<>();
	private static int[] visited = null;
	private static int count = 0;
	private static int total = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; ++i){
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			count = Math.max(count, from);
			if(!gMap.containsKey(from)){
				Map<Integer, Integer> map = new HashMap<>();
				map.put(to, 1);
				gMap.put(from, map);
			}
			else{
				gMap.get(from).put(to, 1);
			}
		}
		++count;
		visited = new int[count];
		// 짧은 페이지 클릭 횟수의 합
		int total = 0;
		
		for(int i=0; i<count; ++i){
			for(int j=0; j<count; ++j){
				if(i != j){
					int temp = getBestPath(i, j);
					total += temp;
					System.out.println(temp);
				}
			}
		}
		// 쌍 갯수를 구해서 평균 클릭 횟수 구하기
		int pairCount = count*(count-1);
		System.out.println(getResult(total, pairCount));
		sc.close();
	}
	
	private static int getBestPath(int from, int to){
		visited[from] = 1;
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = gMap.get(from);
		if(!map.containsKey(to)){
			Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<Integer, Integer> temp = iter.next();
				if(visited[temp.getKey()] != 1){
					int tempValue = getBestPath(temp.getKey(), to);
					if(tempValue > 0){
						min = Math.min(min, tempValue+temp.getValue());
					}
				}
			}
			// 갈 곳 없음
			if(min == Integer.MAX_VALUE){
				visited[from] = 0;
				return -1;
			}
			map.put(to, min);
		}
		visited[from] = 0;
		return map.get(to);
	}
	
	private static String getResult(int total, int pairCount){
		DecimalFormat df = new DecimalFormat("#####.000");
		double n = (double)total/pairCount;
		double d = Math.pow(10, 3);
		return df.format(Math.round(n*d)/d);
	}
}

