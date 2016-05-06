package day1;

import java.util.Scanner;

public class Bag {
	private static int[] values = null;
	private static int[] weights = null;
	private static int N = 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int w = sc.nextInt();
		
		weights = new int[N];
		values = new int[N];
		
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
		// ������ ���԰� ���� �賶�� �뷮���� ū ��� skip
		else if(weights[n]>lw){
			return getMaxValue(n+1, lw);
		}
		
		// �� ������ �־��� ���� ���� �ʾ��� �� �� ū ������
		int inValue = values[n] + getMaxValue(n+1, lw-weights[n]);
		int outValue = getMaxValue(n+1, lw);
		if(inValue > outValue){
			return inValue;
		}
		
		return outValue;
	}
}
