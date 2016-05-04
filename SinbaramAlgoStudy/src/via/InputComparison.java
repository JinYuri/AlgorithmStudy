package via;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
result 
1. TIME : 214.600077 (ms) via Scanner Only
2. TIME : 70.597856 (ms) via BufferedReader with String split
3. TIME : 76.93713 (ms) via BufferedReader with StringTokenizer
4. TIME : 67.667364 (ms) via Scanner with BufferedReader
*/
public class InputComparison {

	static long startTime = 0;
	static long endTime = 0;

	public static void main(String[] args) throws IOException {
		String path = InputComparison.class.getResource("Z-large-practice.in").getPath();

		int[][] board;
		int size;
		int testcase = 0;

		// CASE 1. SCANNER ONLY
		startTime = System.nanoTime();
		Scanner sc = new Scanner(new File(path));
		testcase = sc.nextInt();
		while (testcase-- > 0) {
			size = sc.nextInt();
			board = new int[size * 2 - 1][size];
			for (int i = 0; i < size * 2 - 1; i++)
				for (int j = 0; j < size; j++)
					board[i][j] = sc.nextInt();
		}
		endTime = System.nanoTime();
		System.out.println("1. TIME : " + (endTime - startTime) / 1000000.0 + " (ms) via Scanner Only");

		// CASE 2. BufferedReader and String.split
		startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))), 32768);
		testcase = Integer.parseInt(br.readLine());
		while (testcase-- > 0) {
			size = Integer.parseInt(br.readLine());
			board = new int[size * 2 - 1][size];
			for (int i = 0; i < size * 2 - 1; i++) {
				String current = br.readLine();
				String[] currentsplit = current.split(" ");
				for (int j = 0; j < size; j++)
					board[i][j] = Integer.parseInt(currentsplit[j]);
			}
		}
		endTime = System.nanoTime();
		System.out.println(
				"2. TIME : " + (endTime - startTime) / 1000000.0 + " (ms) via BufferedReader with String split");

		// CASE 3. custom READER ( using BufferedReader and StringTokenizer )
		startTime = System.nanoTime();
		InputReader cr = new InputReader(new FileInputStream(new File(path)));
		testcase = cr.nextInt();
		while (testcase-- > 0) {
			size = cr.nextInt();
			board = new int[size * 2 - 1][size];
			for (int i = 0; i < size * 2 - 1; i++)
				for (int j = 0; j < size; j++)
					board[i][j] = cr.nextInt();
		}
		endTime = System.nanoTime();
		System.out.println(
				"3. TIME : " + (endTime - startTime) / 1000000.0 + " (ms) via BufferedReader with StringTokenizer");

		// CASE 4. Scanner with BufferedInputStream
		startTime = System.nanoTime();
		Scanner sc2 = new Scanner(new BufferedInputStream(new FileInputStream(path), 32768));
		testcase = sc2.nextInt();
		while (testcase-- > 0) {
			size = sc2.nextInt();
			board = new int[size * 2 - 1][size];
			for (int i = 0; i < size * 2 - 1; i++)
				for (int j = 0; j < size; j++)
					board[i][j] = sc2.nextInt();
		}
		endTime = System.nanoTime();
		System.out.println("4. TIME : " + (endTime - startTime) / 1000000.0 + " (ms) via Scanner with BufferedReader");

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}

}
