package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ToyFactory { 
	// 장난감 리스트
	private static int[] TOYS = null;
	// Memoization
	private static int[][] M = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; ++t){
			// 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			TOYS = new int[N];
			M = new int[N][N];
			for(int n=0; n<N; n++){
				TOYS[n] = Integer.parseInt(br.readLine());
			}
			// DP함수 호출하여 결과 리턴
			System.out.println("#"+t+" "+getBoxCount(0, N-1));
		}
		
		br.close();
	}
	
	// start ~ end 인덱스 사이의 장난감을 박스에 담는 최소 cost 리턴
	private static int getBoxCount(int start, int end){
		int result = Integer.MAX_VALUE;
		// Loop되는 횟수를 조정할 for문의 end값
		// start ~ end가 20개 이하면 end를 그대로 쓸 예정이고
		//               20보다 많으면 start+20개까지만 쓸 예정
		int loopEnd = start+20;
		// 마지막 1개 남음
		if(start == end){
			return 1;
		}
		// Memoization된 값이 있으면 사용
		if(M[start][end] != 0){
			return M[start][end];
		}
		Set<Integer> types = null;
		// start ~ end를 한번에 담을 수 있는 경우 초기값을 그걸로
		if(end <= start+19){
			types = new HashSet<>();
			for(int i=start; i<=end; ++i){
				types.add(TOYS[i]);
			}
			result = (int) Math.pow(types.size(),2);
			loopEnd = end;
		}
		
		types = new HashSet<>();
		// Loop 시작
		// 1개씩 늘려가며 박스에 담아보고 그중 min 값 찾음
		for(int i=start; i<loopEnd; ++i){
			types.add(TOYS[i]);
			int temp = (int) Math.pow(types.size(), 2) + getBoxCount(i+1, end);
			result = Math.min(result, temp);
		}
		// 계산한 값 기억해두기 (Memoization)
		M[start][end] = result;
		return result;
	}
}
