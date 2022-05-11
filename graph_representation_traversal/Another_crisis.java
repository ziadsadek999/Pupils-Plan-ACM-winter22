package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Another_crisis {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt();
			int t = sc.nextInt();
			if (n == 0 && t == 0)
				break;
			LinkedList<Integer> graph[] = new LinkedList[n + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			for (int i = 1; i <= n; i++) {
				int manager = sc.nextInt();
				graph[manager].add(i);
			}
			pw.println(minimumEmployees(graph, 0, t));
		}
		pw.flush();
	}

	public static int minimumEmployees(LinkedList<Integer>[] graph, int curr, int t) {
		if (graph[curr].size() == 0) {
			return 1;
		}
		int min = (graph[curr].size() * t) / 100;
		if ((graph[curr].size() * t) % 100 != 0)
			min++;
		PriorityQueue<Integer> subGraphsSol = new PriorityQueue<Integer>();
		for (int x : graph[curr]) {
			subGraphsSol.add(minimumEmployees(graph, x, t));
		}
		int res = 0;
		while (min-- > 0) {
			res += subGraphsSol.poll();
		}
		return res;
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
