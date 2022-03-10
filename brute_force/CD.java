package brute_force;

import java.io.*;
import java.util.*;

public class CD {
	static int[] arr;
	static int N;
	static int max;
	static String t;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		//Thread.sleep(3000);
		while (sc.ready()) {
			N = sc.nextInt();
			int num_tracks = sc.nextInt();
			arr = new int[num_tracks];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			max = 0;
			solve(0, 0, "");
			pw.println(t + "sum:" + max);
		}
		pw.flush();
	}

	public static void solve(int curr, int acc, String token) {
		if (curr == arr.length) {
			if (acc > max) {
				t = token;
				max = acc;
			}
			return;
		}
		if (acc + arr[curr] <= N)
			solve(curr + 1, acc + arr[curr], token + arr[curr] + " ");
		solve(curr + 1, acc, token);
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
