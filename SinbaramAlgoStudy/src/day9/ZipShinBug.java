package day9;

import java.util.HashMap;
import java.util.Map;
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
		System.out.println(getCount(1, N));
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
				result = getCount(a, leftDays-a+aliveDays);
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
				result = getCount(aliveDays+1, leftDays-1)+getCount(0, leftDays);
			}
		}
		return result%1000;
	}
}
