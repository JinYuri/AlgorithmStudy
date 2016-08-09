package pretest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ColorFiller {
	private static int[] indexes = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; ++t){
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[][] lines = new int[2*N][2];

			Job[] jobs = new Job[N];
			int[] results = new int[N];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int maxHeight = Integer.MIN_VALUE;
			for(int n=0; n<N; ++n){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				lines[2*n][0] = x;
				lines[2*n+1][0] = x+s;
				lines[2*n][1] = lines[2*n+1][1] = n;
				jobs[n] = new Job(x, y, s, n);
				maxHeight = Math.max(maxHeight, y+s);
			}
			
			Arrays.sort(lines, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] > o2[0]) return 1;
					else if(o1[0] == o2[0]) return 0;
					return -1;
				}
			});
			
			for(int n=0; n<N; ++n){
				Job std = jobs[n];
				Job prev = null;
				indexes = new int[maxHeight+1];
				int result = 0;
				for(int j=0; j<lines.length; ++j){
					Job temp = jobs[lines[j][1]];
					int tempX = lines[j][0];
					if(prev != null && prev.x >= std.x){
						result += getS(std.y, std.s) * (tempX - prev.x);
					}
					if(std.order < temp.order){
						int val = 1;
						if(tempX > temp.x) val = -1;
						for(int i=temp.y; i<temp.y+temp.s; ++i){
							update(i, val);
						}
					}
					else if(tempX > temp.x && std.order == temp.order){
						break;
					}
					prev = temp;
					prev.x = tempX;
				}
				if(result > 0){
					min = Math.min(min, result);
					max = Math.max(max, result);
				}
				results[n] = result;
			}
			StringBuilder mainsb = new StringBuilder();
			StringBuilder minsb = new StringBuilder();
			StringBuilder maxsb = new StringBuilder();
			int minCnt = 0;
			int maxCnt = 0;
			mainsb.append("#").append(t).append(" ");
			for(int n=0; n<N; ++n){
				if(results[n] == min){
					minCnt++;
					minsb.append(n+1).append(" ").append(results[n]).append(" ");
				}
				if(results[n] == max){
					maxCnt++;
					maxsb.append(n+1).append(" ").append(results[n]).append(" ");
				}
			}
			System.out.println(mainsb.append(minCnt).append(" ").append(minsb.toString().trim()));
			System.out.println(new StringBuilder().append(maxCnt).append(" ").append(maxsb.toString().trim()));
		}
		br.close();
	}
	
	static class Job{
		int x, y, s, order;
		public Job(int x, int y, int s, int order){
			this.x = x;
			this.y = y;
			this.s = s;
			this.order = order;
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
