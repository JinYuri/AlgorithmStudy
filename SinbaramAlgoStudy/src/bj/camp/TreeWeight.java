package bj.camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeWeight {
	private static int N = Integer.MIN_VALUE;
	private static int[][] map = null;
	private static int[] visited = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new int[N];
		map = new int[N][N];
		StringTokenizer st = null;
		
		//인접행렬만들기
		for(int i=1; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken())-1;
			
			map[n][m] = map[m][n] = Integer.parseInt(st.nextToken());
		}
		
		// 모든경로 구하기
		// 경로의 가중치 (엣지의 곱)를 구하고 이를 sum하여 return
		List<Integer> result = getWieght(0);
		int total = 0;
		for(int val:result){
			total = (total+val)%1000000007;
		}
		System.out.println(total);
	}
	
    public static List<Integer> getWieght(int n){
        List<Integer> result = new ArrayList<>();
        visited[n] = 1;
        for(int i=0; i<N; i++){
            if(map[n][i] > 0 && visited[i] != 1){
            	result.add(map[n][i]);
            	List<Integer> temp = getWieght(i);
            	for(int val : temp){
            		result.add(val);
            		result.add((map[n][i]*val)%1000000007);
            	}
            }
        }
        return result;
    }
}
