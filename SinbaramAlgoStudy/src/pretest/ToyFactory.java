package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ToyFactory { 
	// �峭�� ����Ʈ
	private static int[] TOYS = null;
	// Memoization
	private static int[][] M = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �׽�Ʈ���̽� ��
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; ++t){
			// �Է¹���
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			TOYS = new int[N];
			M = new int[N][N];
			for(int n=0; n<N; n++){
				TOYS[n] = Integer.parseInt(br.readLine());
			}
			// DP�Լ� ȣ���Ͽ� ��� ����
			System.out.println("#"+t+" "+getBoxCount(0, N-1));
		}
		
		br.close();
	}
	
	// start ~ end �ε��� ������ �峭���� �ڽ��� ��� �ּ� cost ����
	private static int getBoxCount(int start, int end){
		int result = Integer.MAX_VALUE;
		// Loop�Ǵ� Ƚ���� ������ for���� end��
		// start ~ end�� 20�� ���ϸ� end�� �״�� �� �����̰�
		//               20���� ������ start+20�������� �� ����
		int loopEnd = start+20;
		// ������ 1�� ����
		if(start == end){
			return 1;
		}
		// Memoization�� ���� ������ ���
		if(M[start][end] != 0){
			return M[start][end];
		}
		Set<Integer> types = null;
		// start ~ end�� �ѹ��� ���� �� �ִ� ��� �ʱⰪ�� �װɷ�
		if(end <= start+19){
			types = new HashSet<>();
			for(int i=start; i<=end; ++i){
				types.add(TOYS[i]);
			}
			result = (int) Math.pow(types.size(),2);
			loopEnd = end;
		}
		
		types = new HashSet<>();
		// Loop ����
		// 1���� �÷����� �ڽ��� ��ƺ��� ���� min �� ã��
		for(int i=start; i<loopEnd; ++i){
			types.add(TOYS[i]);
			int temp = (int) Math.pow(types.size(), 2) + getBoxCount(i+1, end);
			result = Math.min(result, temp);
		}
		// ����� �� ����صα� (Memoization)
		M[start][end] = result;
		return result;
	}
}
