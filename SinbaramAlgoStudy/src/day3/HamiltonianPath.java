package day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HamiltonianPath {
	private static int[][] costs = null;
	private static int maxCost = 1200;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		costs = new int[n][n];
		Place[] visited = new Place[n];
		
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				costs[i][j] = sc.nextInt();
			}
			visited[i] = new Place();
		}
		
		System.out.println(getMinCost(0, visited));
		sc.close();
	}
	
	private static int getMinCost(int n, Place[] visited){
		String key = makeKey(visited);
		if(visited[n].getMemMap().containsKey(key)){
			return visited[n].getMemMap().get(key);
		}
		int min = Integer.MAX_VALUE;
		Place[] mVisited = copyArray(visited);
		mVisited[n].setVisited(true);
		if(isFinal(mVisited)){
			min = costs[n][0];
		}
		else{
			for(int i=0; i<costs[n].length; ++i){
				if(!mVisited[i].isVisited() && costs[n][i] != 0 && canComeback(i, mVisited)){
					int temp = costs[n][i]+getMinCost(i, mVisited);
					if(min > temp){
						min = temp;
					}
				}
			}
		}
		if(min==Integer.MAX_VALUE){
			min = maxCost;
		}
		visited[n].getMemMap().put(key, min);
		return min;
	}
	
	private static boolean isFinal(Place[] visited) {
		for(int i=0; i<visited.length; ++i){
			if(!visited[i].isVisited()){
				return false;
			}
		}
		
		return true;
	}

	private static boolean canComeback(int n, Place[] visited) {
		for(int i=0; i<visited.length; ++i){
			if(!visited[i].isVisited() && costs[i][0] != 0){
				return true;
			}
		}
		return false;
	}
	
	private static Place[] copyArray(Place[] source){
		Place[] target = new Place[source.length];
		for(int i=0; i<source.length; ++i){
			target[i] = new Place();
			target[i].visited = source[i].visited;
			target[i].setMemMap(source[i].getMemMap());
		}
		return target;
	}
	private static String makeKey(Place[] visited){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<visited.length; ++i){
			if(visited[i].isVisited()){
				sb.append(i).append("_");
			}
		}
		return sb.toString();
	}
	
	public static class Place{
		private boolean visited = false;
		private Map<String, Integer> memMap = new HashMap<>();
		
		public boolean isVisited() {
			return visited;
		}
		
		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public Map<String, Integer> getMemMap() {
			return memMap;
		}

		public void setMemMap(Map<String, Integer> memMap) {
			this.memMap = memMap;
		}
		
	}

}

