package speed_contest;

import java.io.*;
import java.util.*;

public class slay_the_dragon {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		Long[] arr = new Long[n];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
			sum += arr[i];
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		while (m-- > 0) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			int ind = searchHigher(arr, x);
			long inc = Long.MAX_VALUE;
			long dec = Long.MAX_VALUE;
			if (ind < n) {
				dec = Math.max(0, y - (sum - arr[ind]));
			}
			ind = searchLower(arr, x);
			if (ind >= 0) {
				inc = (x - arr[ind]) + Math.max(0, y - (sum - arr[ind]));
			}
			pw.println(Math.min(inc, dec));
		}
		pw.flush();
	}

	public static int searchHigher(Long[] arr, long target) {
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
		return l;
	}

	public static int searchLower(Long[] arr, long target) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return h;
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
