package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Cow {
	private static final int TO = 25;//Z:25
	private static int[][] map = new int[52][52];
	private static int[] visited = new int[52];
	private static Set<Integer> startSet = new HashSet<>();
	private static Map<String, Integer> mem = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			int from = getIndex(st.nextToken());
			int to = getIndex(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(map[from][to] != 0)	cost = Math.min(map[from][to], cost);
			map[from][to] = map[to][from] = cost;
		}
		
		int result = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;
		Iterator<Integer> iter = startSet.iterator();
		while(iter.hasNext()){
			int i = iter.next();
			int tempCost = find(i);
			if(tempCost > 0 && tempCost < result){
				result = tempCost;
				index = i;
			}
		}
		System.out.println((char) (index+65)+" "+result);
		br.close();
	}
	
	private static int find(int from){
		if(map[from][TO] > 0)	return map[from][TO];
		String key = makeKey(from);
        if(mem.containsKey(key))	return mem.get(key);
		
        visited[from] = 1;
        int minCost = Integer.MAX_VALUE;
        
    	for(int i=0; i<map[from].length; i++){
    		if(visited[i] != 1 && map[from][i] > 0){
    			int tempCost = find(i);
    			if(tempCost > 0)	minCost = Math.min(minCost, tempCost+map[from][i]);
    		}
    	}
    	
    	visited[from] = 0;
    	if(minCost == Integer.MAX_VALUE)	minCost = -1;
    	mem.put(key, minCost);
        return minCost;
	}
	private static String makeKey(int index) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<visited.length; ++i){
			if(visited[i] > 0)	sb.append(i).append("_");
		}
		return sb.append("*").append(index).toString();
	}
	//A:65 Y:89 a:97 z:122 
	//A:0  Y:24 a:26 z:51 
	private static int getIndex(String s){
		char ch = s.charAt(0);
		if(ch > 96) return ch-71;
		else if(ch != 'Z')	startSet.add(ch-65);
		return ch-65;
	}
}
