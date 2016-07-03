package day9;

import java.util.Scanner;

public class ZipShinBug {
	private static int a = 0;
	private static int b = 0;
	private static int d = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); //�¾�� a�� �� ��ü
		b = sc.nextInt(); //�¾�� b�� �� ���� stop
		d = sc.nextInt(); //�¾�� d�� �� ��� �Ф�
		int N = sc.nextInt(); //���ϰ��� �ϴ� ����
		
		System.out.println(getCount(0, N+1));
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		// ���
		if(aliveDays >= d) {
			return 0;
		}
		// �׳��� �Դ�
		else if(leftDays <= 0){
			return 1;
		}
		// �������� �ʰų� ���� �׸�
		else if(aliveDays < a || aliveDays >= b){
			return getCount(++aliveDays, --leftDays);
		}
		// �����ؼ� ���� ����
		else{
			return getCount(++aliveDays, --leftDays)+getCount(0, --leftDays);
		}
	}
}
