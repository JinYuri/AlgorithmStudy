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
		
		System.out.println(getCount(1, N));
		sc.close();
	}
	
	private static int getCount(int aliveDays, int leftDays){
		// 성숙하지 않음
		if(aliveDays < a){
			// 구하는 날까지 성숙하지 않으면
			if(leftDays < a){
				return 1;
			}
			// 성숙하는 날로 점프
			else{
				return getCount(a, leftDays-a+aliveDays);
			}
		}
		//복제 그만
		else if(aliveDays >= b){
			// 구하는 날까지 살아 있다면
			if(leftDays <= d-aliveDays){
				return 1;
			}
			else{
				return 0;
			}	
		}
		// 성숙해서 복제 가능
		else{
			// 그날이 왔다
			if(leftDays <= 0){
				return 1;
			} 
			else{
				return getCount(++aliveDays, leftDays-1)+getCount(0, leftDays-1);
			}
		}
	}
}
