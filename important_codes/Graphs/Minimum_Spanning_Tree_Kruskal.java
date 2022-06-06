package important_codes.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Minimum_Spanning_Tree_Kruskal {
	public static void main(String[] args) throws IOException {
		// n: number of nodes
		// m: number of edges
		// Each of the following m lines contains three integers, a, b and c, which
		// means that there is an undirected edge between a and b with cost c
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		edge[] arr = new edge[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new edge(sc.nextInt(), sc.nextInt(), sc.nextLong());
		}
		Arrays.sort(arr);
		DSU u = new DSU(n);
		// MST is the adjacency list that represents the minimum spanning tree of the
		// graph
		LinkedList<edge> MST[] = new LinkedList[n];
		for (int i = 0; i < MST.length; i++) {
			MST[i] = new LinkedList<edge>();
		}
		for (int i = 0; i < arr.length; i++) {
			int from = arr[i].from;
			int to = arr[i].to;
			long cost = arr[i].cost;
			if (!u.isSameSet(from, to)) {
				u.unionSet(from, to);
				MST[from].add(new edge(from, to, cost));
				MST[to].add(new edge(to, from, cost));
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

	// Credits for this implementation of the DSU for Ahmad Elsagheer
	// https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/data_structures/UnionFind.java
	static class DSU {
		int[] p, rank, setSize;
		int numSets;

		public DSU(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			return p[i] == i ? i : (p[i] = findSet(p[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
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
