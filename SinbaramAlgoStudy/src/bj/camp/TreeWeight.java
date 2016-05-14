package bj.camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class TreeWeight {
	private static int N = Integer.MIN_VALUE;
	private static Vector<Integer>[] map = null;
	private static int[] visited = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new int[N];
		map = new Vector[N];
		StringTokenizer st = null;
		
		//��������Ʈ�����
		for(int i=1; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			if(map[n] == null){
				map[n] = new Vector<>(1, 1);
			}
			if(map[m] == null){
				map[m] = new Vector<>(1, 1);
			}
			map[n].add(m);
			map[n].add(w);
			map[m].add(n);
			map[m].add(w);
			
		}
		// ����� ���ϱ�
		// ����� ����ġ (������ ��)�� ���ϰ� �̸� sum�Ͽ� return
		List<Integer> result = getWieght(0);
		int total = 0;
		for(int val:result){
			total = (total+val)%1000000007;
		}
		System.out.println(total);
	}
	
    public static List<Integer> getWieght(int n){
        List<Integer> result = new ArrayList<>();
        visited[n] = 1;
        if(map[n] != null){
        	for(int i=0; i<map[n].size(); i+=2){
        		if(visited[map[n].get(i)] != 1){
        			result.add(map[n].get(i+1));
        			List<Integer> temp = getWieght(map[n].get(i));
        			for(int val : temp){
        				result.add(val);
        				result.add((map[n].get(i+1)*val)%1000000007);
        			}
        		}
        	}
        }
        return result;
    }
}