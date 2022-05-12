package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Easy_Problem_from_Rujia_Liu {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		// Thread.sleep(3000);
		// The description of the problem is very simple, yet implementing it the same
		// way it is described will give a Time Limit Exceeded verdict as every
		// traversal costs O(n) time and you have m queries, so the total complexity
		// will be O(n*m). You can avoid this by creating an array of arraylists whose
		// size equals 1,000,001, because the maximum value will be 1,000,000 and the
		// array is zero indexed so we added a 1. After that, you traverse the input
		// array only once, then while traversing if you hit a value x, you add the
		// index at which you found x to the arraylist at index x in the array of
		// arraylists you created. Then for ever query, you get the k-th value in th
		// v-th arraylist if it exists.
		// Take care about which values are 1-indexed and zero-indexed. Also do not
		// forget there are multiple test cases and that the input is terminated with
		// EOF.
		while (sc.ready()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> occurence[] = new ArrayList[1000001];
			for (int i = 0; i < occurence.length; i++) {
				occurence[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				occurence[x].add(i + 1);
			}
			while (m-- > 0) {
				int k = sc.nextInt();
				int v = sc.nextInt();
				if (occurence[v].size() >= k) {
					pw.println(occurence[v].get(k - 1));
				} else {
					pw.println(0);
				}
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
