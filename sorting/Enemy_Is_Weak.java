package sorting;
import java.util.*;
import java.io.*;

public class Enemy_Is_Weak {

	static class item {
		int val;
		long cAfter;
		long cBefore;

		public item(int val, long cAfter, long cBefore) {
			this.val = val;
			this.cAfter = cAfter;
			this.cBefore = cBefore;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		item[] arr = new item[n];

		for (int i = 0; i < arr.length; i++) {
			int x = sc.nextInt();
			arr[i] = new item(x, 0, 0);
		}
		sort(arr, 0, n - 1);

		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			res += (arr[i].cAfter * arr[i].cBefore);
		}
		pw.println(res);
		pw.flush();
	}

	public static void sort(item[] arr, int l, int r) {
		if (l != r) {
			int mid = (l + r) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, r);
			merge(arr, l, mid, mid + 1, r);
		}
	}

	public static void merge(item[] arr, int l1, int r1, int l2, int r2) {
		item[] tmp = new item[r2 - l1 + 1];
		int i = l1;
		int j = l2;
		int c = 0;
		int t = 0;
		while (i <= r1 && j <= r2) {
			if (arr[i].val <= arr[j].val) {
				arr[i].cAfter += t;
				tmp[c++] = arr[i++];
			} else {
				arr[j].cBefore += (r1 - i + 1);
				tmp[c++] = arr[j++];
				t++;
			}
		}
		while (j <= r2) {
			tmp[c++] = arr[j++];
		}
		while (i <= r1) {
			arr[i].cAfter += t;
			tmp[c++] = arr[i++];
		}
		c = 0;
		for (int k = l1; k <= r2; k++) {
			arr[k] = tmp[c++];
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

