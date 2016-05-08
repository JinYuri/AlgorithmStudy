package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookMaker {
	private static Map<String, Integer> mem = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0; tc<t; ++tc){
			int k = sc.nextInt();
			List<Integer> files = new ArrayList<>();
			mem = new HashMap<>();
			
			for(int i=0; i<k; ++i){
				files.add(sc.nextInt());
			}
			System.out.println(getMinCost(files));
		}
		sc.close();
	}
	
	private static int getMinCost(List<Integer> files){
		String key = makeKey(files);
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		int min = Integer.MAX_VALUE;
		if(files.size() == 2){
			min = files.get(0) + files.get(1);
		}
		else{
			for(int i=0; i<files.size()-1; ++i){
				int cost = files.get(i) + files.get(i+1);
				int temp = cost + getMinCost(makeNewFile(files, i, cost));
				if(min > temp){
					min = temp;
				}
			}
		}
		mem.put(key, min);
		return min;
	}
	
	private static List<Integer> makeNewFile(List<Integer> source, int idx, int cost){
		List<Integer> target = new ArrayList<>();
		for(int i=0; i<source.size()-1; ++i){
			if(i == idx){
				target.add(cost);
			}
			else if(i < idx){
				target.add(source.get(i));
			}
			else{
				target.add(source.get(i+1));
			}
		}
		return target;
	}
	
	private static String makeKey(List<Integer> files){
		List<Integer> sorted = new ArrayList<>();
		sorted.addAll(files);
		Collections.sort(sorted);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<sorted.size(); ++i){
			sb.append(sorted.get(i)+"_");
		}
		return sb.toString();
	}
}
