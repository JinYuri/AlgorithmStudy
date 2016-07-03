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
		
		System.out.println(getCount(1, N));
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		// �������� ����
		if(aliveDays < a){
			// ���ϴ� ������ �������� ������
			if(leftDays < a){
				return 1;
			}
			// �����ϴ� ���� ����
			else{
				return getCount(a, leftDays-a+aliveDays);
			}
		}
		//���� �׸�
		else if(aliveDays >= b){
			// ���ϴ� ������ ��� �ִٸ�
			if(leftDays <= d-aliveDays){
				return 1;
			}
			else{
				return 0;
			}	
		}
		// �����ؼ� ���� ����
		else{
			// �׳��� �Դ�
			if(leftDays <= 0){
				return 1;
			} 
			else{
				return getCount(++aliveDays, leftDays-1)+getCount(0, leftDays-1);
			}
		}
	}
}
