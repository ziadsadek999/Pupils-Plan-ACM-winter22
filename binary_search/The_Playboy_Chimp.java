package binary_search;
import java.util.*;
import java.io.*;

public class The_Playboy_Chimp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			long target = sc.nextLong();
			int l = 0;
			int h = n - 1;
			while (l <= h) {
				int mid = (l + h) / 2;
				if (arr[mid] >= target) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			StringBuilder res = new StringBuilder();
			if (h == -1) {
				res.append("X ");
			} else {
				res.append(arr[h]);
				res.append(" ");
			}
			l = 0;
			h = n - 1;
			while (l <= h) {
				int mid = (l + h) / 2;
				if (arr[mid] > target) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if (l == n) {
				res.append("X");
			} else {
				res.append(arr[l]);
			}
			pw.println(res);
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

