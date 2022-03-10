package binary_search;
import java.util.*;
import java.io.*;

public class Keshi_Is_Throwing_a_Party {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < b.length; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			int l = 0;
			int h = n;
			while (l <= h) {
				int mid = (l + h) / 2;
				int poorer = 0;
				int richer = mid - 1;
				int taken = 0;
				for (int i = 0; i < b.length; i++) {
					if (b[i] >= poorer) {
						if (a[i] >= richer) {
							poorer++;
							richer--;
							taken++;
							if (taken == mid)
								break;
						}
					}
				}
				if (taken >= mid) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
			pw.println(h);
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

