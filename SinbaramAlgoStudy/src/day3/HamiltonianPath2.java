package day3;

import java.util.Scanner;

public class HamiltonianPath2 {
	private static int[][] costs = null;
	private static int maxCost = 1200;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		costs = new int[n][n];
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				costs[i][j] = sc.nextInt();
			}
			visited[i] = false;
		}
		
		System.out.println(getMinCost(0, visited));
		sc.close();
	}
	
	private static int getMinCost(int n, boolean[] visited){
		int min = Integer.MAX_VALUE;
		boolean[] mVisited = copyArray(visited);
		mVisited[n] = true;
		if(isFinal(mVisited)){
			min = costs[n][0];
		}
		else{
			for(int i=0; i<costs[n].length; ++i){
				if(!mVisited[i] && costs[n][i] != 0 && canComeback(i, mVisited)){
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
		return min;
	}
	
	private static boolean isFinal(boolean[] visited) {
		for(int i=0; i<visited.length; ++i){
			if(!visited[i]){
				return false;
			}
		}
		
		return true;
	}

	private static boolean canComeback(int n, boolean[] visited) {
		for(int i=0; i<visited.length; ++i){
			if(!visited[i] && costs[i][0] != 0){
				return true;
			}
		}
		return false;
	}
	
	private static boolean[] copyArray(boolean[] source){
		boolean[] target = new boolean[source.length];
		for(int i=0; i<source.length; ++i){
			target[i] = source[i];
		}
		return target;
	}
}

