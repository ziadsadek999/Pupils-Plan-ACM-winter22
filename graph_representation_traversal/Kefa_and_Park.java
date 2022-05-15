package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Kefa_and_Park {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cats = new int[n];
		for (int i = 0; i < cats.length; i++) {
			cats[i] = sc.nextInt();
		}
		LinkedList<Integer> graph[] = new LinkedList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			// We decrement the input by one to make the nodes zero indexed.

			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		// since the graph is a tree rooted at zero, it is guaranteed that there is a
		// unique path between the root and every leaf. We can define the problem
		// recursively by calling the function on every child for every node. The
		// function return the number of reachable leaves for every node. The answer for
		// every node will be the sum of the answers of all its children. To know that
		// the leaf is reachable, we can add a parameter called accumulator in which we
		// store the number of consecutive cats we meet along the path. If I hit a node
		// with no cats, I reset the counter. If the counter exceeds m, I return zero as
		// I will have to stop without reaching any leaves.

		// Since the graph is a rooted tree, we do not have to make a boolean array to
		// know the visited nodes. Instead, we can add a parameter in the function
		// indicating the index of the node that I called the function from (the parent)
		// so that I do not return for it again.

		// Initially, we start at the root which is at index zero -remember we made the
		// graph zero indexed-. The cat accumulator is zero. And since the root has no
		// parent, we initialize the parent with -1.
		pw.println(dfs(graph, 0, -1, 0, cats, m));
		pw.flush();
	}

	public static int dfs(LinkedList<Integer>[] graph, int curr, int parent, int acc, int[] cats, int m) {
		// This condition checks if we reached a leaf.
		if (graph[curr].size() == 1 && graph[curr].getFirst() == parent) {
			// Check if the leaf itself contains a cat. If a cat exists, we increment the
			// acc then check if it exceeded m.
			if (cats[curr] == 1)
				acc++;
			if (acc > m)
				return 0;
			return 1;
		}
		if (cats[curr] == 1)
			acc++;
		else
			acc = 0;
		if (acc > m)
			return 0;
		int result = 0;
		for (int x : graph[curr]) {
			if (x != parent) {
				// x will be the next node and its parent is curr.
				result += dfs(graph, x, curr, acc, cats, m);
			}
		}
		return result;
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
