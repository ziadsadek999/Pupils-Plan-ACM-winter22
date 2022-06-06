package important_codes.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Minimum_Spanning_Tree_Prim {
	public static void main(String[] args) throws IOException {
		// n: number of nodes
		// m: number of edges
		// Each of the following m lines contains three integers, a, b and c, which
		// means that there is an undirected edge between a and b with cost c
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<edge> graph[] = new LinkedList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<edge>();
		}
		while (m-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long cost = sc.nextLong();
			graph[a].add(new edge(a, b, cost));
			graph[b].add(new edge(b, a, cost));
		}
		boolean[] vis = new boolean[n];
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		vis[0] = true;
		for (edge x : graph[0])
			pq.add(x);
		// MST is the adjacency list that represents the minimum spanning tree of the
		// graph
		LinkedList<edge> MST[] = new LinkedList[n];
		for (int i = 0; i < MST.length; i++) {
			MST[i] = new LinkedList<edge>();
		}
		while (!pq.isEmpty()) {
			edge curr = pq.poll();
			int from = curr.from;
			int to = curr.to;
			long cost = curr.cost;
			if (!vis[to]) {
				vis[to] = true;
				MST[from].add(new edge(from, to, cost));
				MST[to].add(new edge(to, from, cost));
				for (edge x : graph[to])
					pq.add(x);
			}
		}

	}

	static class edge implements Comparable<edge> {
		int from;
		int to;
		long cost;

		public edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(edge x) {
			if (cost < x.cost)
				return -1;
			if (cost > x.cost)
				return 1;
			return 0;
		}
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

		public int[] nextIntArr(int n) throws IOException {
			int[] res = new int[n];
			for (int i = 0; i < res.length; i++) {
				res[i] = nextInt();
			}
			return res;
		}

		public long[] nextlongArr(int n) throws IOException {
			long[] res = new long[n];
			for (int i = 0; i < res.length; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public Long[] nextLongArr(int n) throws IOException {
			Long[] res = new Long[n];
			for (int i = 0; i < res.length; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public Integer[] nextIntegerArr(int n) throws IOException {
			Integer[] res = new Integer[n];
			for (int i = 0; i < res.length; i++) {
				res[i] = nextInt();
			}
			return res;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
