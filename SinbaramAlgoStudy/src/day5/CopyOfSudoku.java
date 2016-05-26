package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyOfSudoku {
	private static List<EmptyCell> cells = new ArrayList<>();
	private static int[][] map = new int[9][9];
	private static int total = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				int val = sc.nextInt();
				map[i][j] = val;
				if(val == 0){
					EmptyCell temp = new EmptyCell();
					temp.i = i;
					temp.j = j;
					cells.add(temp);
				}
			}
		}
		total = cells.size();
		while(total>0){
			List<EmptyCell> filledCell = new ArrayList<>();
			for(int i=0; i<cells.size(); ++i){
				boolean isfilled = fill(i);
				if(total == 0){
					break;
				}
				if(isfilled){
					filledCell.add(cells.get(i));
				}
			}
			cells.removeAll(filledCell);
		}
		sc.close();
	}
	private static boolean fill(int k){
		EmptyCell temp = cells.get(k);
		boolean isfilled = false;
		int[] pool = new int[9];
		// 가로 한줄
		for(int j=0; j<9; ++j){
			if(j!=temp.j&& map[temp.i][j]!= 0){
				pool[map[temp.i][j]-1] = 1;
			}
		}
		// 세로 한줄
		for(int i=0; i<9; ++i){
			if(i!=temp.i && map[i][temp.j]!= 0){
				pool[map[i][temp.j]-1] = 1;
			}
		}
		// 작은 네모
		for(int i=3*(temp.i/3); i<3*(temp.i/3)+3; ++i){
			for(int j=3*(temp.i/3); j<3*(temp.i/3)+3; ++j){
				if(i!=temp.i && j!=temp.j&& map[i][j]!= 0){
					pool[map[i][j]-1] = 1;
				}
			}
		}
		for(int i=0; i<9; ++i){
			if(pool[i] == 0){
				temp.candidateNums.add(i+1);
			}
		}
		if(temp.candidateNums.size() == 1){
			map[temp.i][temp.j] = temp.candidateNums.get(0);
			--total;
			isfilled = true;
		}
		return isfilled;
	}
	public static class EmptyCell{
		int i = Integer.MIN_VALUE;
		int j = Integer.MIN_VALUE;
		
		List<Integer> candidateNums = new ArrayList<>();
	}
	
}
