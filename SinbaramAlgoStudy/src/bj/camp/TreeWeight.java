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
		
		//������ĸ����
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			map[n][m] = map[m][n] = Integer.parseInt(st.nextToken());
		}
		
		// ����� ���ϱ� (1�̸� visited tagging�ϰ� ó�� �� tagging ����)
		// ����� ����ġ (������ ��)�� ���ϰ� �̸� sum�Ͽ� return
	}
}
