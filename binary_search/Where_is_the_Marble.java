package binary_search;
import java.util.*;
import java.io.*;

public class Where_is_the_Marble {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int c = 1;
		while (true) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			if (n == 0 && q == 0)
				break;
			pw.println("CASE# " + c + ":");
			Integer[] arr = new Integer[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			while (q-- > 0) {
				int target = sc.nextInt();
				int l = 0;
				int h = arr.length - 1;
				while (l <= h) {
					int mid = (l + h) / 2;
					if (arr[mid] < target) {
						l = mid + 1;
					} else {
						h = mid - 1;
					}
				}
				if (l == n || arr[l] != target) {
					pw.println(target + " not found");
				} else {
					pw.println(target + " found at " + (l + 1));
				}
			}
			c++;
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

