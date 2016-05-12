package bj.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombRemover {
//https://www.acmicpc.net/problem/2345
	private static int[][] map = null;
	private static int l = Integer.MAX_VALUE;
	private static int n = Integer.MAX_VALUE;
	private static int m = Integer.MAX_VALUE;
	private static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				map[i][j] = sc.nextInt();
				if(map[i][j]==0){
				}
			}
		}
		l = sc.nextInt();
		
		System.out.println(result.size());
		for(int i=0; i<result.size(); ++i){
			System.out.println(result.get(i)/100 + " " + result.get(i)%100);
		}
		sc.close();
	}
	
//	private static int getBombCount(int i, int j){
//		// 여기에 제거폭탄을 놓고 안놓고 중 최선을 선택
//		map[i][j] = 1;
//		result.add(i*100+j);
//		for(int k=i+1; k<=(i+l); ++k){
//			if(k >= n || map[k][j] != 0){
//				break;
//			}
//			map[k][j] = 1;
//		}
//		for(int k=i-1; k>=(i-l); --k){
//			if(k < 0 || map[k][j] != 0){
//				break;
//			}
//			map[k][j] = 1;
//		}
//		for(int k=j+1; k<=(j+l); ++k){
//			if(k >= m || map[i][k] != 0){
//				break;
//			}
//			map[i][k] = 1;
//		}
//		for(int k=j-1; k>=(j-l); --k){
//			if(k < 0 || map[i][k] != 0){
//				break;
//			}
//			map[i][k] = 1;
//		}
//	}
}
