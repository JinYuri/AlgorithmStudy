package day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Wire {
	private static int N = 0;
	private static int[][] map = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][2];
		for(int i=0; i<N; ++i){
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
		
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		System.out.println(N-LIS());
		sc.close();
	}

	private static int LIS() {
		int[] LIS = new int[N+1]; // LIS�� ���̴� 1�̻� N�����̹Ƿ�, �迭 ũ��� N+1�� �����Ѵ�. 
	    int maxLength = 0; // LIS �迭�� �ʱ� ����. 
	    LIS[0] = Integer.MIN_VALUE; // ���ǻ� �ּڰ��� ����Ű�� �ּ� ���Ҹ� ���� 
	    
	    for(int i=0 ; i<N;i++){
	        int position = binary_search(LIS,0,maxLength+1,map[i][1]); // ���� Ž���� ���� ������ ������ ��ġ�� Ȯ�� 
	        LIS[position] = map[i][1]; // LIS �迭�� ���� ����
	        if( maxLength < position ) maxLength = position; // maxLength ���� 
	    }
	    return maxLength; 
	}
	
	// ������ ���� ����
	// s <= n <= e �� �����ϴ� n�� ������ [s,e] �� �Ѵ�.
	// s < n < e �� �����ϴ� n�� ������ (s,e) �� �Ѵ�. 
	private static int binary_search(int Arrays[], int start, int end, int key) { // Ž�� ������ [start,end) �̴�. 
	    if( start==end ) return start; // Ž���� �� �� �ʿ䰡 ���� ��� 
	     
	    int middle = (start+end)/2;
	    if( Arrays[middle] < key ) { // [middle+1,end) �������� ���� ���
	        return binary_search(Arrays,middle+1,end,key);
	    }
	    else if( Arrays[middle] > key ) { // [start,middle) �������� ���� ���
	         return binary_search(Arrays,start,middle,key);
	    }
	    else return middle;
	}
}
