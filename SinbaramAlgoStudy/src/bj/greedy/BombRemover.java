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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		List<Integer> candidate = new ArrayList<>();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				map[i][j] = sc.nextInt();
				if(map[i][j]==0){
					candidate.add(i*1000+j);
				}
			}
		}
		l = sc.nextInt();
		List<Integer> filteredList = checkDestoryBuildings(candidate);
		List<Integer> result = markBombArea(filteredList);
		
		System.out.println(result.size());
		for(int val:result){
			int i = (val/1000)+1;
			int j = (val%1000)+1;
			System.out.println(i+" "+j);
		}
		
		sc.close();
	}
	// 건물을 안부수는 곳만 걸러내기
	private static List<Integer> checkDestoryBuildings(List<Integer> candidate){
		List<Integer> result = new ArrayList<>();
		for(int val:candidate){
			int i=val/1000;
			int j=val%1000;
			
			boolean isDestoryed = false;
			
			for (int k=i+1; k<=(i+l); ++k) {
				if (k>=n)
					break;
				if (map[k][j]>0) {
					if(map[k][j]==1)
						isDestoryed = true;
					break;
				}
			}
			for (int k=i-1; k>=(i-l); --k) {
				if(k<0)
					break;
				if (map[k][j]>0) {
					if(map[k][j]==1)
						isDestoryed = true;
					break;
				}
			}
			for (int k=j+1; k<=(j+l); ++k) {
				if(k>=m)
					break;
				if (map[i][k]>0) {
					if(map[i][k]==1)
						isDestoryed = true;
					break;
				}
			}
			for (int k=j-1; k>=(j-l); --k) {
				if (k<0)
					break;
				if (map[i][k]>0) {
					if(map[i][k]==1)
						isDestoryed = true;
					break;
				}
			}
			if(!isDestoryed){
				result.add(val);
			}
		}
		return result;
	}
	
	// 폭탄 영역 표시하기
	private static List<Integer> markBombArea(List<Integer> filteredList){
		int[][] areaMap = new int[n][m];
		List<Integer> result = new ArrayList<>();
		for(int val:filteredList){
			int i=val/1000;
			int j=val%1000;
			
			for (int k=i+1; k<=(i+l); ++k) {
				if (k>=n || map[k][j]>0) {
					break;
				}else{
					++areaMap[k][j];
				}
			}
			for (int k=i-1; k>=(i-l); --k) {
				if (k<0 || map[k][j]>0) {
					break;
				}else{
					++areaMap[k][j];
				}
			}
			for (int k=j+1; k<=(j+l); ++k) {
				if (k>=m || map[i][k]>0) {
					break;
				}else{
					++areaMap[i][k];
				}
			}
			for (int k=j-1; k>=(j-l); --k) {
				if (k<0 || map[i][k]>0) {
					break;
				}else{
					++areaMap[i][k];
				}
			}
		}
		
		for(int val:filteredList){
			int i=val/1000;
			int j=val%1000;
			
			if((i!=n-1 && areaMap[i+1][j]==1) || (j!=m-1 && areaMap[i][j+1]==1) || (i!=0 && areaMap[i-1][j]==1) || (j!=0 && areaMap[i][j-1]==1)){
				result.add(val);
			}
			
		}
		
		return result;
	}
}
