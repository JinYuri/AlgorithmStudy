package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CopyOfColorFiller {
	private static int[] indexes = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; ++t){
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Job> lines = new PriorityQueue<>(new Comparator<Job>() {
				@Override
				public int compare(Job j1, Job j2) {
					if(j1.x > j2.x) return 1;
					else if(j1.x == j2.x) return 0;
					return -1;
				}
			});
			Job[] jobs = new Job[N];
			int[] results = new int[N];
			int maxHeight = Integer.MIN_VALUE;
			for(int n=0; n<N; ++n){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				Job job = new Job(x, y, s, n, false);
				lines.add(job);
				lines.add(new Job(x+s, y, s, n, true));
				jobs[n] = job;
				maxHeight = Math.max(maxHeight, y+s);
			}
			
			for(int n=0; n<N; ++n){
				Job std = jobs[n];
				Job prev = null;
				indexes = new int[maxHeight+1];
				int result = 0;
				while(!lines.isEmpty()){
					Job temp = lines.poll();
					if(prev != null && temp.x >= std.x){
						result += getS(std.y, std.s) * (temp.x - prev.x);
					}
					if(temp.isEnd){
						if(temp.order == std.order){
							break;
						}
						for(int i=temp.y; i<temp.y+temp.s; ++i){
							update(i, -1);
						}
					}else if(std.order < temp.order){
						for(int i=temp.y; i<temp.y+temp.s; ++i){
							update(i, 1);
						}
					}
					prev = temp;
				}
				results[n] = result;
			}
			for(int n=0; n<N; ++n){
				System.out.println(results[n]);
			}
		}
		br.close();
	}
	
	static class Job{
		int x, y, s, order;
		boolean isEnd = false;
		public Job(int x, int y, int s, int order, boolean isEnd){
			this.x = x;
			this.y = y;
			this.s = s;
			this.order = order;
			this.isEnd = isEnd;
		}
	}
	
	public static int getS(int y, int s) {
        int sum = 0;
        for(int i=y; i<y+s; ++i){
        	if(indexes[i] == 0){
        		sum++;
        	}
        }

        return sum;
    }
    public static void update(int ind, int value) {
    	indexes[ind] += value;
    }
}
