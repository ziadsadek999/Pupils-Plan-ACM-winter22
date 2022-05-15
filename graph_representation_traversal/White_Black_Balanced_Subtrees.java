package graph_representation_traversal;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class White_Black_Balanced_Subtrees {
	static int counter;

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			LinkedList<Integer> graph[] = new LinkedList[n];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			for (int i = 1; i < n; i++) {
				// We decrement to make the graph zero indexed.
				int a = sc.nextInt() - 1;
				// As specified in the input, a_i is the parent of i, so we we add i to to the
				// linked list at index a_i, where i starts from 1 as 0 has no parent.
				graph[a].add(i);
			}
			String colors = sc.nextLine();
			// The problem can create a recursive function that returns a pair (x,y). the
			// function is called on a node and returns the pair where x is the number of
			// black nodes in the tree whose root is this node, and y is the number of white
			// nodes. The function will be called on all of the children of the node and add
			// the x's together and all the y's together. After that we check the color of
			// the parent itself and increment either x or y accordingly. After that we see
			// if x = y we increment the static counter.
			// Since this tree is directed, we do not need a visited boolean array since we
			// can never reach a node twice. Remember a tree has no cycles.
			counter = 0;
			dfs(graph, 0, colors);
			pw.println(counter);
		}
		pw.flush();
	}

	public static Point dfs(LinkedList<Integer>[] graph, int curr, String colors) {
		// This condition checks if we reached a leaf.
		if (graph[curr].size() == 0) {
			if (colors.charAt(curr) == 'W') {
				return new Point(0, 1);
			}
			return new Point(1, 0);
		}
		int x = 0;
		int y = 0;
		for (int node : graph[curr]) {
			// x will be the next node and its parent is curr.
			Point res = dfs(graph, node, colors);
			x += res.x;
			y += res.y;

		}
		if (colors.charAt(curr) == 'W')
			y++;
		else
			x++;
		if (x == y)
			counter++;
		return new Point(x, y);
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
