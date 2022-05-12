package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Demanding_Dilemma {
	// The problem may sound complicated however it is very simple. The given matrix
	// consists of rows and columns. Every column corresponds to and edge. For a
	// column i if the row j = 1, then the edge i is connected to edge j. So every
	// column should have exactly two 1's as an edge can connect exactly two nodes
	// according to the description given -"and E is a set of unordered pairs (u, v)
	// where u and v are in V and u != v"- so since u!= v, there does not exist an
	// edge connecting a node to itself. There is another thing we need to check
	// that might be not clear from the description. The description says that E is
	// a set. So it is not possible for two edges to be connecting the same two
	// nodes as a set does not contain duplicates.
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] matrix = new int[n][m];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			boolean f = true;
			// Here we used an array of hashsets instead of an array of arraylists, because
			// we need to check if node a is connected to node b by another edge or no. So
			// to check for this we see if the hashset at index a contains b. Hashsets are
			// more time efficient as we can check for this in O(1) unlike arraylists which
			// will need O(n).
			HashSet<Integer> graph[] = new HashSet[n];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new HashSet<Integer>();
			}
			for (int i = 0; i < matrix[0].length; i++) {
				// Here we traverse every column in the matrix and see the position of the ones
				// in every column. If there exist more than two ones we break and set the flag
				// to false. Then if there exist exactly two ones we see if the nodes
				// represented by these two nodes are connected by another edge by examining
				// array of hashsets, if they are not connected, we add the 'to' to the 'from'
				// hashset and add the 'from' to the 'to' hashset.
				int from = -1;
				int to = -1;
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[j][i] == 1) {
						if (from == -1) {
							from = j;
						} else if (to == -1) {
							to = j;
						} else {
							f = false;
							break;
						}
					}
				}
				if (!f)
					break;
				if (from != -1 && to != -1) {
					if (graph[from].contains(to)) {
						f = false;
						break;
					}
					graph[from].add(to);
				} else {
					f = false;
					break;
				}

			}
			if (!f) {
				pw.println("No");
			} else {
				pw.println("Yes");
			}
		}
		pw.flush();
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
