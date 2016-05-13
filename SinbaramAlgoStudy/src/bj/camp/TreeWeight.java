package bj.camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeWeight {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] visited = new int[N];
		StringTokenizer st = null;
		
		//인접행렬만들기
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			map[n][m] = map[m][n] = Integer.parseInt(st.nextToken());
		}
		
		// 모든경로 구하기 (1이면 visited tagging하고 처리 후 tagging 원복)
		// 경로의 가중치 (엣지의 곱)를 구하고 이를 sum하여 return
	}
}
