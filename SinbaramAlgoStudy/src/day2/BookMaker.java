package day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookMaker {
	private static Map<String, Integer> mem = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0; tc<t; ++tc){
			int k = sc.nextInt();
			int[] files = new int[k];
			mem = new HashMap<>();
			
			for(int i=0; i<k; ++i){
				files[i] = sc.nextInt();
			}
			System.out.println(getMinCost(files));
		}
		sc.close();
	}
	
	private static int getMinCost(int[] files){
		String key = makeKey(files);
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		int min = Integer.MAX_VALUE;
		if(files.length == 2){
			min = files[0] + files[1];
		}
		else{
			for(int i=0; i<files.length-1; ++i){
				int cost = files[i] + files[i+1];
				int temp = cost + getMinCost(makeNewFile(files, i, cost));
				if(min > temp){
					min = temp;
				}
			}
		}
		mem.put(key, min);
		return min;
	}
	
	private static int[] makeNewFile(int[] source, int idx, int cost){
		int[] target = new int[source.length-1];
		for(int i=0; i<source.length-1; ++i){
			if(i == idx){
				target[i] = cost;
			}
			else if(i < idx){
				target[i] = source[i];
			}
			else{
				target[i] = source[i+1];
			}
		}
		return target;
	}
	
	private static String makeKey(int[] files){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<files.length; ++i){
			sb.append(files[i]).append("_");
		}
		return sb.toString();
	}
}
