package bj.rgb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] MAP = null;
	private static int[][] M = null;
	private static int N = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		MAP = new int[N][3];
		M = new int[N][4];
		for(int n=0; n<N; ++n){
			st = new StringTokenizer(br.readLine());
			MAP[n][0] = Integer.parseInt(st.nextToken());
			MAP[n][1] = Integer.parseInt(st.nextToken());
			MAP[n][2] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getMinCost(3, 0));
		
		br.close();
	}
	
	private static int getMinCost(int preColor, int idx){
		int result = Integer.MAX_VALUE;
		if(idx == N){
			return 0;
		}
		if(M[idx][preColor] != 0){
			return M[idx][preColor];
		}
		for(int c=0; c<3; ++c){
			if(preColor != c){
				int temp = MAP[idx][c] + getMinCost(c, idx+1);
				result = Math.min(result, temp);
			}
		}
		M[idx][preColor] = result;
		return result;
	}
}
