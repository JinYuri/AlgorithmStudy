package day9;

import java.util.Scanner;

public class Copy_2_of_ZipShinBug {
	private static int a = 0;
	private static int b = 0;
	private static int d = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); //�¾�� a�� �� ��ü
		b = sc.nextInt(); //�¾�� b�� �� ���� stop
		d = sc.nextInt(); //�¾�� d�� �� ��� �Ф�
		int N = sc.nextInt(); //���ϰ��� �ϴ� ����
		System.out.println(getCount(1, N)%1000);
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		int result = 0;
		// �������� ����
		if(aliveDays < a){
			// ���ϴ� ������ �������� ������
			if(leftDays <= a){
				result = 1;
			}
			// �����ϴ� ���� ����
			else{
				result = getCount(a, leftDays-a+aliveDays)%1000;
			}
		}
		//���� �׸�
		else if(aliveDays >= b){
			// ���ϴ� ������ ��� �ִٸ�
			if(leftDays <= d-aliveDays){
				result = 1;
			}
			else{
				result = 0;
			}	
		}
		// �����ؼ� ���� ����
		else{
			// ������ �������̶��
			if(leftDays <= 1){
				result = 2;
			}
			else{
				result = getCount(aliveDays+1, leftDays-1)%1000+getCount(0, leftDays)%1000;
				System.out.println(aliveDays + " " + leftDays + " " + result);
			}
		}
		return result;
	}
}
