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
		System.out.println(getCount(0));
		sc.close();
	}
	
	private static int getCount(int day){
		int result = 0;
		result = getCount(day-1)+getCount(day-a)-getCount(day-d);
		return result%1000;
	}
}
