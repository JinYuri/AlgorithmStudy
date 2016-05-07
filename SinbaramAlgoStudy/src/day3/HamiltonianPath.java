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
		copyArray(visited, mVisited);
		int min = Integer.MAX_VALUE;
		int idx = n;
		for(int i=0; i<costs[n].length; ++i){
			if(i != n && !visited[i] && costs[n][i] != 0){
				int temp = costs[n][i]+getMinCost(i);
				if(min > temp){
					min = temp;
					idx = i;
				}
				copyArray(mVisited, visited);
			}
		}
		// 모두 다 가봤으면 회사로 돌아가렴
		if(min == Integer.MAX_VALUE){
			if(costs[n][0] != 0){
				min = costs[n][0];
			}
			// 못가는 길이면 선택 못하게 최대값 박아버림 -_-;;
			else{
				visited[n]= false;
				return 1200;
			}
		}else{
			visited[idx] = true;
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
	
	private static void copyArray(boolean[] source, boolean[] target){
		for(int i=0; i<source.length; ++i){
			target[i] = source[i];
		}
	}
}

