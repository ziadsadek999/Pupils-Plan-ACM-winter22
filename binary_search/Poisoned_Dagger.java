package binary_search;
import java.util.*;
import java.io.*;

public class Poisoned_Dagger {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long h = sc.nextLong();
			long[] arr = new long[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLong();
			}
			long low = 0;
			long high = h;
			while (low <= high) {
				long mid = (low + high) / 2;
				long health = h;
				int i = 0;
				while (health > 0) {
					if (i == n - 1) {
						health -= mid;
						break;
					}
					health -= Math.min(mid, arr[i + 1] - arr[i]);
					i++;
				}
				if (health > 0) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			pw.println(low);
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


