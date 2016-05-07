package day3;

import java.util.Scanner;

public class HamiltonianPath {
	private static int[][] costs = null;
	private static boolean[] visited = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		costs = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				costs[i][j] = sc.nextInt();
			}
			visited[i] = false;
		}
		
		System.out.println(getMinCost(0));
		sc.close();
	}
	
	private static int getMinCost(int n){
		visited[n] = true;
		boolean[] mVisited = new boolean[visited.length];
		boolean[] minVisited = new boolean[visited.length];
		boolean isFinal = true;
		copyArray(visited, mVisited);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<costs[n].length; ++i){
			if(!visited[i] && n!=i){
				isFinal = false;
				if(costs[n][i] != 0 && canComeback(n, visited)){
					int temp = costs[n][i]+getMinCost(i);
					if(min > temp){
						min = temp;
						copyArray(visited, minVisited);
					}
					copyArray(mVisited, visited);
				}
			}
		}
		// 모두 다 가봤으면 회사로 돌아가렴
		if(isFinal){
			min = costs[n][0];
		}
		else{
			copyArray(minVisited, visited);
		}
		return min;
	}
//	public class Graph{
//		private boolean visited = false;
//
//		public boolean isVisited() {
//			return visited;
//		}
//
//		public void setVisited(boolean visited) {
//			this.visited = visited;
//		}
//	}
	
	private static boolean canComeback(int n, boolean[] visited) {
		
		for(int i=0; i<visited.length; ++i){
			if(i!=n && !visited[i] && costs[i][0] != 0){
				return true;
			}
		}
		return false;
	}

	private static void copyArray(boolean[] source, boolean[] target){
		for(int i=0; i<source.length; ++i){
			target[i] = source[i];
		}
	}
}

