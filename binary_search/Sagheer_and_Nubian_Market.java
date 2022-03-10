package binary_search;
import java.util.*;
import java.io.*;

public class Sagheer_and_Nubian_Market {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		long s = sc.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
		}
		long l = 0;
		long h = n;
		long res = 0;
		while (l <= h) {
			long mid = (l + h) / 2;
			Long costs[] = new Long[n];
			for (int i = 0; i < costs.length; i++) {
				costs[i] = arr[i] + (i + 1) * mid;
			}
			Arrays.sort(costs);
			long cost = 0;
			for (int i = 0; i < mid; i++) {
				cost += costs[i];
			}
			if (cost <= s) {
				res = cost;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		pw.println(h + " " + res);
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

