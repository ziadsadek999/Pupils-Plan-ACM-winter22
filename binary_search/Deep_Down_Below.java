package binary_search;
import java.io.*;
import java.util.*;

public class Deep_Down_Below {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Pair[] arr = new Pair[n];
			for (int i = 0; i < n; i++) {
				int k = sc.nextInt();
				int max = 0;
				for (int j = 0; j < k; j++) {
					max = Math.max(max, (sc.nextInt() - j) + 1);
				}
				arr[i] = new Pair(max, k);
			}
			Arrays.sort(arr);
			int l = 0;
			int h = arr[n - 1].max;
			while (l <= h) {
				int mid = (l + h) / 2;
				int x = mid;
				boolean f = true;
				for (int i = 0; i < n; i++) {
					if (x < arr[i].max) {
						f = false;
						break;
					} else
						x += arr[i].count;
				}
				if (f == true) {
					h = mid - 1;
				} else
					l = mid + 1;
			}
			pw.println(l);
		}
		pw.flush();
	}

	static class Pair implements Comparable<Pair> {
		int max;
		int count;

		public Pair(int max, int count) {
			this.max = max;
			this.count = count;
		}

		public int compareTo(Pair o) {
			return max - o.max;
		}

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
