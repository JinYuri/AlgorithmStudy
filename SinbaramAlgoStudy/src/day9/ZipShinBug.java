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
		
		System.out.println(getCount(0, N+1));
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		// 사망
		if(aliveDays >= d) {
			return 0;
		}
		// 그날이 왔다
		else if(leftDays <= 0){
			return 1;
		}
		// 성숙하지 않거나 복제 그만
		else if(aliveDays < a || aliveDays >= b){
			return getCount(++aliveDays, --leftDays);
		}
		// 성숙해서 복제 가능
		else{
			return getCount(++aliveDays, --leftDays)+getCount(0, --leftDays);
		}
	}
}
