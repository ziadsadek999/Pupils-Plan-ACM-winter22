package sorting;
import java.util.*;
import java.io.*;

public class Forbidden_Subsequence {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.nextLine();
			String T = sc.nextLine();
			int[] occ = new int[26];
			for (int i = 0; i < s.length(); i++) {
				occ[s.charAt(i) - 'a']++;
			}
			if (!T.equals("abc") || occ[0] == 0 || occ[1] == 0 || occ[2] == 0) {
				StringBuilder res = new StringBuilder();
				for (int i = 0; i < occ.length; i++) {
					while (occ[i]-- > 0)
						res.append((char)('a' + i));
				}
				pw.println(res);
			} else {
				StringBuilder res = new StringBuilder();
				while (occ[0]-- > 0) {
					res.append('a');
				}
				while (occ[2]-- > 0) {
					res.append('c');
				}
				while (occ[1]-- > 0) {
					res.append('b');
				}
				for (int i = 3; i < occ.length; i++) {
					while (occ[i]-- > 0)
						res.append((char)('a' + i));
				}
				pw.println(res);
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

