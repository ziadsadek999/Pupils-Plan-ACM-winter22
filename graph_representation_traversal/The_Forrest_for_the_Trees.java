package graph_representation_traversal;

import java.io.*;

import java.util.*;

public class The_Forrest_for_the_Trees {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		// This question is simply the problem of finding the number of connected
		// components in a graph which was discussed in the session. However you will
		// have distinguish between connected components with on node only and the
		// others with more than one node You may struggle a little bit with taking the
		// input but welcome to UVA :).
		int t = sc.nextInt();
		while (t-- > 0) {
			LinkedList<Integer> graph[] = new LinkedList[26];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			String s = sc.nextLine();
			while (s.charAt(0) != '*') {
				graph[s.charAt(1) - 'A'].add(s.charAt(3) - 'A');
				graph[s.charAt(3) - 'A'].add(s.charAt(1) - 'A');
				s = sc.nextLine();
			}
			boolean vis[] = new boolean[26];
			Arrays.fill(vis, true);
			s = sc.nextLine();
			int i = 0;
			while (i < s.length()) {
				vis[s.charAt(i) - 'A'] = false;
				i += 2;
			}
			int cAcorns = 0;
			for (int j = 0; j < graph.length; j++) {
				if (graph[j].size() == 0 && !vis[j]) {
					vis[j] = true;
					cAcorns++;
				}
			}
			int cTrees = 0;
			for (int j = 0; j < vis.length; j++) {
				if (!vis[j]) {
					cTrees++;
					dfs(graph, vis, j);
				}
			}
			pw.println("There are " + cTrees + " tree(s) and " + cAcorns + " acorn(s).");
		}
		pw.flush();
	}

	public static void dfs(LinkedList<Integer> graph[], boolean vis[], int curr) {
		if (vis[curr])
			return;
		vis[curr] = true;
		for (int x : graph[curr])
			dfs(graph, vis, x);
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
