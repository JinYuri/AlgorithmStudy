package pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RiceCake {
	private static char[][] map = null;
	private static int[] price = {100, 70, 40, 50, 30, 20, 0};
	private static int N =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; ++i){
			String str = br.readLine();
			for(int j=0; j<N; ++j){
				map[i][j] = str.charAt(j);
			}
		}
		
		br.close();
	}
	private static int getPrice(int idx){
		int result = 0;
		if(idx%N < N-1)
			result = Math.max(result, getPrice(idx+2));
		if(idx/N < N-1)
			result = Math.max(result, getPrice(idx+2*N));
		else{
			if(idx%N != N-1)
				result = Math.max(result, getPrice(idx+1));
			else
				result = Math.max(result, getPrice(idx+N));
		}
		return result;
	}
	
//	130  100
//	131  70
//	132  40
//	132  50
//	133  30
//	134  20

}
