package brute_force;

import java.io.*;
import java.util.*;

public class twenty_three_out_of_five {
	static int[] arr;
	static boolean vis[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			arr = new int[5];
			int countZero = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] == 0)
					countZero++;
			}
			if (countZero == 5)
				break;
			vis = new boolean[5];
			boolean ret = false;
			for (int i = 0; i < arr.length; i++) {
				vis[i] = true;
				ret |= solve(1, arr[i]);
				vis[i] = false;
			}
			if (ret) {
				pw.println("Possible");
			} else {
				pw.println("Impossible");
			}
		}
		pw.flush();
	}

	public static boolean solve(int count, int acc) {
		if (count == 5) {
			if (acc == 23)
				return true;
			return false;

		}
		boolean ret = false;
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				ret |= solve(count + 1, acc + arr[i]);
				ret |= solve(count + 1, acc - arr[i]);
				ret |= solve(count + 1, acc * arr[i]);
				vis[i] = false;
			}
		}
		return ret;
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
