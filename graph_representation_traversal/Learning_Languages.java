package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Learning_Languages {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// this array of arraylists is an array in which the arraylist at index i
		// contains the employees that speaks the language i.
		ArrayList<Integer> languages[] = new ArrayList[m + 1];
		for (int i = 0; i < languages.length; i++) {
			languages[i] = new ArrayList<Integer>();
		}
		// iterating over the employees from employee 0 to employee n-1.
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			while (k-- > 0) {
				int language = sc.nextInt();
				languages[language].add(i);
			}
		}
		// Next, we will construct a graph, where all the employees speaking the same
		// languages will be in a connected component.
		ArrayList<Integer> graph[] = new ArrayList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < languages.length; i++) {
			for (int j = 0; j < languages[i].size() - 1; j++) {
				int employee1 = languages[i].get(j);
				int employee2 = languages[i].get(j + 1);
				graph[employee1].add(employee2);
				graph[employee2].add(employee1);
			}
		}
		// Now, we want to know the minimum number of courses to connect all the
		// employees. This number is the number of connected components -1, as we want
		// to draw an edge between every two connected components to make the whole
		// graph connected. And to get the number of connected components, we will keep
		// performing DFS until all the employees (nodes) are visited.
		boolean vis[] = new boolean[n];
		int c = 0;
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				c++;
				dfs(graph, vis, i);
			}
		}
		// However, we should handle a corner case where all the employees do not speak
		// any language. In this case we will have to make them all learn the same
		// language. In this case, the answer is the number of employees.
		boolean f = false;
		for (int i = 0; i < languages.length; i++) {
			if (languages[i].size() > 0) {
				f = true;
				break;
			}
		}
		if (f) {
			pw.println(c - 1);
		} else {
			pw.println(n);
		}

		pw.flush();
	}

	public static void dfs(ArrayList<Integer> graph[], boolean[] vis, int curr) {
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
