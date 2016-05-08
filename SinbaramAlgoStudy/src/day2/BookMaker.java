package day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookMaker {
	private static Map<Integer, Integer> mem = new HashMap<>();
	private static int[] files = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0; tc<t; ++tc){
			int k = sc.nextInt();
			files = new int[k];
			mem = new HashMap<>();
			
			for(int i=0; i<k; ++i){
				files[i] = sc.nextInt();
			}
			System.out.println(getMinCost(0, k-1));
		}
		sc.close();
	}
	
	private static int getMinCost(int start, int end){
		int min = Integer.MAX_VALUE;
		if(end - start == 0){
			return 0;
		}
		else if(end - start == 1){
			return files[start]+files[end];
		}
		else{
			int sum = files[end];
			int key = makeKey(start, end);
			if(mem.containsKey(key)){
				return mem.get(key);
			}
			for(int i=start; i<end; ++i){
				int temp = getMinCost(start, i) + getMinCost(i+1, end);
				if(min > temp){
					min = temp;
				}
				sum += files[i];
			}
			int result = sum+min;
			mem.put(key, result);
			return result;
		}
	}
	
	private static int makeKey(int start, int end){
		return start * 10000 + end;
	}
}
