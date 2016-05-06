package day1;

import java.util.Scanner;

public class Bag {
	private static int[] values = null;
	private static int[] weights = null;
	private static int N = 1000;
	private static int[][] mem = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int w = sc.nextInt();
		
		weights = new int[N];
		values = new int[N];
		mem = new int[N][w+1];
		
		for(int i=0; i<N; ++i){
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		System.out.println(getMaxValue(0, w));
		sc.close();
	}
	
	private static int getMaxValue(int n, int lw){
		// ������ ���� ��� ��
		if(n >= N){
			return 0;
		}
		// ���� �賶 �뷮�� ���� ��� ���� �� ����.
		else if(lw<=0){
			return 0;
		}
		if(mem[n][lw] == 0){
			// ������ ���԰� ���� �賶�� �뷮���� ū ��� skip
			if(weights[n]>lw){
				mem[n][lw] = getMaxValue(n+1, lw);;
			}
			else{
				// �� ������ �־��� ���� ���� �ʾ��� �� �� ū ������
				int inValue = values[n] + getMaxValue(n+1, lw-weights[n]);
				int outValue = getMaxValue(n+1, lw);
				if(inValue > outValue){
					mem[n][lw] = inValue;
				}
				else{
					mem[n][lw] = outValue;
				}
			}
		}
		return mem[n][lw];
	}
}
