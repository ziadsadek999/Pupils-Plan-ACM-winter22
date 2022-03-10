package brute_force;

import java.io.*;
import java.util.*;

public class factorials_and_powers_of_two {
	static long n;
	static long fact[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		fact = new long[16];
		fact[0] = 1;
		for (long i = 1; i < fact.length; i++) {
			fact[(int) i] = i * fact[(int) i - 1];
		}
		while (t-- > 0) {
			n = sc.nextLong();
			pw.println(solve(0, 0, 0));
		}
		pw.flush();
	}

	public static int solve(int curr, int count, long acc) {
		if (curr == fact.length) {
			if (acc <= n) {
				return count + count_ones(n - acc);
			}
			return 1000;
		}
		int take = solve(curr + 1, count + 1, acc + fact[curr]);
		int leave = solve(curr + 1, count, acc);
		return Math.min(take, leave);
	}

	public static int count_ones(long x) {
		long mask = 1;
		int count = 0;
		while (mask <= x) {
			if ((mask & x) != 0)
				count++;
			mask <<= 1;
		}
		return count;
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
