package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Validate_The_Maze {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			// In this matrix we will mark '.' as zero and a '#' as -1.
			int[][] matrix = new int[m][n];
			for (int i = 0; i < matrix.length; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < matrix[0].length; j++) {
					if (s.charAt(j) == '#')
						matrix[i][j] = -1;
				}
			}
			// First, we need to validate that that the maze has exactly one entrance and
			// exactly one exit, in other words we want to check that the number of spaces
			// at the border of the maze is exactly two. Also, we need to keep track of
			// the positions of these two spaces to use them. However we must handle the
			// cases when the maze consists of only one row or only one column.

			int[] entrance = null;
			int[] exit = null;
			boolean f = true;
			if (m == 1) {
				for (int i = 0; i < matrix[0].length; i++) {
					if (matrix[0][i] == 0) {
						if (entrance == null) {
							entrance = new int[] { 0, i };
						} else {
							if (exit == null) {
								exit = new int[] { 0, i };
							} else {
								f = false;
								break;
							}
						}

					}
				}
			} else if (n == 1) {
				for (int i = 0; i < matrix.length; i++) {
					if (matrix[i][0] == 0) {
						if (entrance == null) {
							entrance = new int[] { i, 0 };
						} else {
							if (exit == null) {
								exit = new int[] { i, 0 };
							} else {
								f = false;
								break;
							}
						}
					}
				}
			} else {
				// Check on the upper bound.
				for (int i = 0; i < matrix[0].length; i++) {
					if (matrix[0][i] == 0) {
						if (entrance == null) {
							entrance = new int[] { 0, i };
						} else {
							if (exit == null) {
								exit = new int[] { 0, i };
							} else {
								f = false;
								break;
							}
						}

					}

				}
				// Check for the lower bound.
				for (int i = 0; i < matrix[0].length && f; i++) {
					if (matrix[m - 1][i] == 0) {
						if (entrance == null) {
							entrance = new int[] { m - 1, i };
						} else {
							if (exit == null) {
								exit = new int[] { m - 1, i };
							} else {
								f = false;
								break;
							}
						}
					}
				}
				// Check for the left bound, but we will the skip the first and last row as they
				// are already checked to avoid counting a space twice.
				for (int i = 1; i < matrix.length - 1 && f; i++) {
					if (matrix[i][0] == 0) {
						if (entrance == null) {
							entrance = new int[] { i, 0 };
						} else {
							if (exit == null) {
								exit = new int[] { i, 0 };
							} else {
								f = false;
								break;
							}
						}
					}
				}
				// Check for the right bound, but we will the skip the first and last row as
				// they are already checked to avoid counting a space twice.
				for (int i = 1; i < matrix.length - 1; i++) {
					if (matrix[i][n - 1] == 0) {
						if (entrance == null) {
							entrance = new int[] { i, n - 1 };
						} else {
							if (exit == null) {
								exit = new int[] { i, n - 1 };
							} else {
								f = false;
								break;
							}
						}
					}

				}
			}

			if (!f || entrance == null || exit == null) {
				pw.println("invalid");
			} else {
				// Now, we validated the entrance and the exit. The next step is to validate
				// that the exit is reachable from the entrance. You can choose any opening to
				// be the exit and any opening to be the entrance, then start performing DFS or
				// in other words (Flood Fill) at the entrance and see if the exit will be
				// visited or not.
				// We will use the matrix itself as the visited array, as we will mark every
				// visited cell by changing its value to 1.
				dfs(matrix, entrance[0], entrance[1]);
				// Check if the exit is visited.
				if (matrix[exit[0]][exit[1]] == 1) {
					pw.println("valid");
				} else {
					pw.println("invalid");
				}
			}
		}
		pw.flush();
	}

	public static void dfs(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 0) {
			return;
		}
		matrix[i][j] = 1;
		dfs(matrix, i + 1, j);
		dfs(matrix, i - 1, j);
		dfs(matrix, i, j + 1);
		dfs(matrix, i, j - 1);
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
