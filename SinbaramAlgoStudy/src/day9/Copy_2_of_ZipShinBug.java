package day9;

import java.util.Scanner;

public class Copy_2_of_ZipShinBug {
	private static int a = 0;
	private static int b = 0;
	private static int d = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); //태어나고 a일 후 성체
		b = sc.nextInt(); //태어나고 b일 후 복제 stop
		d = sc.nextInt(); //태어나고 d일 후 사망 ㅠㅠ
		int N = sc.nextInt(); //구하고자 하는 일자
		System.out.println(getCount(1, N)%1000);
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		int result = 0;
		// 성숙하지 않음
		if(aliveDays < a){
			// 구하는 날까지 성숙하지 않으면
			if(leftDays <= a){
				result = 1;
			}
			// 성숙하는 날로 점프
			else{
				result = getCount(a, leftDays-a+aliveDays)%1000;
			}
		}
		//복제 그만
		else if(aliveDays >= b){
			// 구하는 날까지 살아 있다면
			if(leftDays <= d-aliveDays){
				result = 1;
			}
			else{
				result = 0;
			}	
		}
		// 성숙해서 복제 가능
		else{
			// 오늘이 마지막이라면
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
