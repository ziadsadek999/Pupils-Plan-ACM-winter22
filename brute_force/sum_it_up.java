package brute_force;

import java.io.*;
import java.util.*;

public class sum_it_up {
	static int[] arr;
	static int t;
	static ArrayList<String> res;
	static HashSet<String> hs;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			t = sc.nextInt();
			int n = sc.nextInt();
			if (t == 0 && n == 0)
				break;
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			res = new ArrayList<String>();
			hs = new HashSet<String>();
			solve(0, 0, "");
			pw.println("Sums of " + t + ":");
			if (res.size() == 0) {
				pw.println("NONE");
			} else {
				for (String x : res) {
					pw.println(x.substring(0, x.length() - 1));
				}
			}
		}
		pw.flush();
	}

	public static void solve(int curr, int acc, String exp) {
		if (curr == arr.length) {
			if (acc == t) {
				if (!hs.contains(exp)) {
					res.add(exp);
					hs.add(exp);
				}
			}
			return;
		}
		solve(curr + 1, acc + arr[curr], exp + arr[curr] + "+");
		solve(curr + 1, acc, exp);
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
