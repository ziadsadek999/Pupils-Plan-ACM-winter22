package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Sheep {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		// Taking the matrix input. A space will be 0. A sheep will be 1. A wolf will be
		// 2. A fence will be -1.
		int n = sc.nextInt();
		int m = sc.nextInt();
		int survivorSheep = 0;
		int survivorWolves = 0;
		int[][] matrix = new int[n][m];
		for (int i = 0; i < matrix.length; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < matrix[0].length; j++) {
				if (s.charAt(j) == '#') {
					matrix[i][j] = -1;
				} else if (s.charAt(j) == 'v') {
					matrix[i][j] = 2;
				} else if (s.charAt(j) == 'k') {
					matrix[i][j] = 1;
				}
			}
		}
		// first, we will perform dfs at any empty space found at the borders of the
		// backyard to eliminate the sectors from which we can escape the backyard.
		// While performing the DFS we will mark every visited field with 3. While doing
		// that, we must count the number of sheep and wolves as all of them will
		// survive as they do not belong to any sector.

		// Upper border
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] != -1) {
				int[] res = dfs(matrix, 0, i);
				survivorSheep += res[0];
				survivorWolves += res[1];
			}
		}

		// Lower border
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[n - 1][i] != -1 && matrix[n - 1][i] != 3) {
				int[] res = dfs(matrix, n - 1, i);
				survivorSheep += res[0];
				survivorWolves += res[1];
			}
		}

		// Left border
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] != -1 && matrix[i][0] != 3) {
				int[] res = dfs(matrix, i, 0);
				survivorSheep += res[0];
				survivorWolves += res[1];
			}
		}

		// Right border
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][m - 1] != -1 && matrix[i][m - 1] != 3) {
				int[] res = dfs(matrix, i, m - 1);
				survivorSheep += res[0];
				survivorWolves += res[1];
			}
		}

		// After that we can deal with every sector as a connected component. For every
		// sector we will perform dfs to count the number of sheep and number of wolves.

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != -1 && matrix[i][j] != 3) {
					int[] res = dfs(matrix, i, j);
					if (res[0] > res[1]) {
						survivorSheep += res[0];
					} else {
						survivorWolves += res[1];
					}
				}
			}
		}
		pw.println(survivorSheep + " " + survivorWolves);
		pw.flush();
	}

	// This function returns an array of length 2, where index 0 holds the number of
	// sheep and index 1 holds the number of wolves.
	public static int[] dfs(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1 || matrix[i][j] == 3) {
			return new int[] { 0, 0 };
		}
		int cSheep = 0;
		int cWolves = 0;
		if (matrix[i][j] == 1)
			cSheep++;
		if (matrix[i][j] == 2)
			cWolves++;
		matrix[i][j] = 3;
		int[] res1 = dfs(matrix, i + 1, j);
		int[] res2 = dfs(matrix, i - 1, j);
		int[] res3 = dfs(matrix, i, j + 1);
		int[] res4 = dfs(matrix, i, j - 1);
		cSheep += (res1[0] + res2[0] + res3[0] + res4[0]);
		cWolves += (res1[1] + res2[1] + res3[1] + res4[1]);
		return new int[] { cSheep, cWolves };

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
