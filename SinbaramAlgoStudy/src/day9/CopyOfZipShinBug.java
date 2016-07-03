package day9;

import java.util.Scanner;

public class CopyOfZipShinBug {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //태어나고 a일 후 성체
		int b = sc.nextInt(); //태어나고 b일 후 복제 stop
		int d = sc.nextInt(); //태어나고 d일 후 사망 ㅠㅠ
		int N = sc.nextInt(); //구하고자 하는 일자
		
		int[] counts = new int[d]; //개체수 세기
		counts[a-1] = 1;
		int result = 0;
		
		for(int i=a-1; i<N; ++i){
			int prev = counts[0];
			int newCount = 0;
			for(int j=1; j<d; ++j){
				int temp = counts[j];
				counts[j] = prev;
				prev = temp;
				if(a < j+1 && j < b){
					newCount += counts[j]%1000;
				}
			}
			counts[0] = newCount;
		}
		
		for(int j=0; j<d; ++j){
			result += counts[j]%1000;
		}
		System.out.println(result%1000);
		sc.close();
	}
}
