package binary_search;
import java.util.*;
import java.io.*;

public class Fill_The_Containers {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		// Thread.sleep(3000);
		while (sc.ready()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[] arr = new long[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLong();

			}
			long l = 0;
			long h = 1000000000;
			while (l <= h) {
				long mid = (l + h) / 2;
				int i = 0;
				int currContainer = 0;
				long currCapacity = 0;
				boolean f = true;
				while (i < n) {
					if (currCapacity + arr[i] <= mid) {
						currCapacity += arr[i];
					} else {
						currContainer++;
						if (arr[i] > mid) {
							f = false;
							break;
						}
						currCapacity = arr[i];
					}
					i++;
				}
				if (currContainer >= m || f == false) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
			pw.println(l);
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

