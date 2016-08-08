package day9;

import java.util.Scanner;

public class ZipShinBug {
	private static int a = 0;
	private static int b = 0;
	private static int d = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); //태어나고 a일 후 성체
		b = sc.nextInt(); //태어나고 b일 후 복제 stop
		d = sc.nextInt(); //태어나고 d일 후 사망 ㅠㅠ
		int N = sc.nextInt(); //구하고자 하는 일자
		System.out.println(getCount(0));
		sc.close();
	}
	
	private static int getCount(int day){
		int result = 0;
		result = getCount(day-1)+getCount(day-a)-getCount(day-d);
		return result%1000;
	}
}
