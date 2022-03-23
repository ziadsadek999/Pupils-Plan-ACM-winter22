package brute_force_2;

import java.io.*;
import java.util.*;

public class repeated_substitution_with_sed {
	static String target;
	static String[][] dic;
	static int min;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			dic = new String[2][n];
			for (int i = 0; i < n; i++) {
				dic[0][i] = sc.next();
				dic[1][i] = sc.next();
			}
			String start = sc.next();
			target = sc.next();
			min = Integer.MAX_VALUE;
			solve(start, 0);
			if (min == Integer.MAX_VALUE)
				pw.println(-1);
			else
				pw.println(min);
		}
		pw.flush();
	}

	public static void solve(String curr, int count) {
		if (curr.equals(target)) {
			min = Math.min(count, min);
			return;
		}
		if (curr.length() >= target.length())
			return;
		for (int i = 0; i < dic[0].length; i++) {
			if (curr.contains(dic[0][i])) {
				solve(curr.replace(dic[0][i], dic[1][i]), count + 1);
			}
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

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
