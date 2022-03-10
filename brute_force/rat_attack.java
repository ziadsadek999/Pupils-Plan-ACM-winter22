package brute_force;

import java.io.*;
import java.util.*;

public class rat_attack {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int d = sc.nextInt();
			int n = sc.nextInt();
			int[][] pop = new int[1025][1025];
			while (n-- > 0) {
				pop[sc.nextInt()][sc.nextInt()] = sc.nextInt();
			}
			int[][] acc = new int[1025][1025];
			for (int i = 0; i < acc.length; i++) {
				acc[i][0] = pop[i][0];
				for (int j = 1; j < acc.length; j++) {
					acc[i][j] = acc[i][j - 1] + pop[i][j];
				}
			}
			int max = -1;
			int x = 0;
			int y = 0;
			for (int i = 0; i < acc.length; i++) {
				for (int j = 0; j < acc.length; j++) {
					int count = 0;
					for (int k = Math.max(0, i - d); k <= Math.min(1024, i + d); k++) {
						count += acc[k][Math.min(1024, j + d)];
						if (j - d > 0) {
							count -= acc[k][j - d - 1];
						}
					}
					if (count > max) {
						max = count;
						x = i;
						y = j;
					}
				}
			}
			pw.println(x + " " + y + " " + max);
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
