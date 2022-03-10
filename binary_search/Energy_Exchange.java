package binary_search;

import java.util.*;
import java.io.*;

public class Energy_Exchange {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int k = sc.nextInt();
		double arr[] = new double[n];
		double max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
			max = Math.max(max, arr[i]);
		}
		double l = 0;
		double h = max;
		while (l <= h) {
			double mid = (l + h) / 2.0;
			double removed = 0;
			double required = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid)
					removed += (arr[i] - mid);
				else
					required += (mid - arr[i]);
			}
			removed = removed - (removed * k) / 100.0;
			if (required > removed) {
				h = mid - 0.0000001;
			} else {
				l = mid + 0.0000001;
			}
		}
		pw.println(h);
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
