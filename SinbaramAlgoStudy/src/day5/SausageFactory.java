package day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SausageFactory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] sMap = new int[n][2];
		
		for(int i=0; i<n; ++i){
			int l = sc.nextInt();
			int w = sc.nextInt();
			sMap[i][0] = l;
			sMap[i][1] = w;
		}
		Arrays.sort(sMap, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return Integer.compare(o2[0], o1[0]);
		    }
		});
		int lCnt = 1;
		for(int i=1; i<n; ++i){
			if(sMap[i][1] > sMap[i-1][1]){
				lCnt++;
			}
		}
		
		Arrays.sort(sMap, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return Integer.compare(o2[1], o1[1]);
		    }
		});
		int wCnt = 1;
		for(int i=1; i<n; ++i){
			if(sMap[i][0] > sMap[i-1][0]){
				wCnt++;
			}
		}
		System.out.println(Math.min(lCnt, wCnt));
		sc.close();
	}
}
