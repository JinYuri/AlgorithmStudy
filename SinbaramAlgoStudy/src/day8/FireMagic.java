package day8;

import java.util.Scanner;

public class FireMagic {
	private static String[][] map = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		map = new String[R][C];
		
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				map[R][C] = sc.next();
			}
		}
		
		sc.close();
	}
}
