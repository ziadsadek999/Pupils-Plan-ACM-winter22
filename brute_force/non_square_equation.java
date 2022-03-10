package brute_force;

import java.io.*;
import java.util.*;

public class non_square_equation {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		long n = sc.nextLong();
		long max = (long) Math.ceil((-1 + Math.sqrt(1 + 4 * n)) / 2.0);
		long min = (long) Math.floor((-108 + Math.sqrt(11664 + 4 * n)) / 2.0);
		min = Math.max(min, 1);
		while (min <= max) {
			long s = min * min + sumDigits(min) * min;
			if (s == n) {
				break;
			}
			min++;
		}
		if (min > max)
			pw.print(-1);
		else
			pw.print(min);
		pw.flush();
	}

	public static long sumDigits(long x) {
		long res = 0;
		while (x > 0) {
			res += (x % 10);
			x = x / 10;
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
