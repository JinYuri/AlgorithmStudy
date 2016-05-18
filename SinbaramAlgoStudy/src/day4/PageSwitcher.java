package day4;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PageSwitcher {
	private static Map<Integer, Map<Integer, Integer>> gMap = new HashMap<>();
	private static int[] visited = null;
	private static int count = 0;
	private static int total = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; ++i){
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			count = Math.max(count, from);
			if(!gMap.containsKey(from)){
				gMap.put(from, new HashMap<Integer, Integer>());
			}
			gMap.get(from).put(to, 1);
		}
		visited = new int[++count];
		// ª�� ������ Ŭ�� Ƚ���� ��
		int total = 0;
		
		for(int i=0; i<count; ++i){
			for(int j=0; j<count; ++j){
				if(i != j){
					total += getMinPath(i, j);
				}
			}
		}
		// �� ������ ���ؼ� ��� Ŭ�� Ƚ�� ���ϱ�
		int pairCount = count*(count-1);
		System.out.println(getResult(total, pairCount));
		sc.close();
	}
	
	private static int getMinPath(int from, int to){
		visited[from] = 1;
		int min = Integer.MAX_VALUE;
		boolean isSubAnswer = false;
		Map<Integer, Integer> map = gMap.get(from);
		if(map.containsKey(to)){
			min = map.get(to);
		}else{
			Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<Integer, Integer> temp = iter.next();
				if(visited[temp.getKey()] != 1){
					int tempValue = getMinPath(temp.getKey(), to);
					if(tempValue > 0){
						min = Math.min(min, tempValue+temp.getValue());
					}
				}
				else{
					isSubAnswer = true;
				}
			}
			// �� �� ����
			if(min == Integer.MAX_VALUE){
				min = -1;
			}
			// �������� ���̶� �� ���� ����� ���� ��� �������� ����
			if(!isSubAnswer){
				map.put(to, min);
			}
		}
		visited[from] = 0;
		return min;
	}
	
	private static String getResult(int total, int pairCount){
		DecimalFormat df = new DecimalFormat("#####.000");
		double n = (double)total/pairCount;
		double d = Math.pow(10, 3);
		return df.format(Math.round(n*d)/d);
	}
}

