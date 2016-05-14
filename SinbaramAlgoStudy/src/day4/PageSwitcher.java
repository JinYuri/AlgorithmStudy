package day4;

import java.util.Scanner;
import java.util.Vector;

public class PageSwitcher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Vector<Integer>[] map = new Vector[500];
		
		for(int i=0; i<N; ++i){
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			if(map[from] == null){
				map[from] = new Vector<>(1, 1);
			}
			map[from].addElement(to);
		}
		
		// ª�� ������ Ŭ�� Ƚ���� ��
		// �� ������ ���ؼ� ��� Ŭ�� Ƚ�� ���ϱ�
		sc.close();
	}
}
