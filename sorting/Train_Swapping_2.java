package sorting;
import java.util.*;
import java.io.*;

public class Train_Swapping_2 {
	static int c;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			c = 0;
			int n = sc.nextInt();
			if (n == 0) {
				pw.println("Optimal train swapping takes 0 swaps.");
			} else {
				int[] arr = new int[n];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = sc.nextInt();
				}
				sort(arr);
				pw.println("Optimal train swapping takes " + c + " swaps.");
			}

		}
		pw.flush();
	}

	public static void sort(int[] arr) {
		sortHelper(arr, 0, arr.length - 1);
	}

	public static void sortHelper(int[] arr, int l, int r) {
		if (l != r) {
			int mid = (l + r) / 2;
			sortHelper(arr, l, mid);
			sortHelper(arr, mid + 1, r);
			merge(arr, l, mid, mid + 1, r);
		}
	}

	public static void merge(int[] arr, int l1, int r1, int l2, int r2) {
		int[] tmp = new int[r2 - l1 + 1];
		int i = l1;
		int j = l2;
		int curr = 0;
		while (i <= r1 && j <= r2) {
			if (arr[i] <= arr[j]) {
				tmp[curr++] = arr[i++];
			} else {
				c += (r1 - i + 1);
				tmp[curr++] = arr[j++];
			}
		}
		while (i <= r1) {
			tmp[curr++] = arr[i++];
		}
		while (j <= r2) {
			tmp[curr++] = arr[j++];
		}
		curr = 0;
		for (int k = l1; k <= r2; k++) {
			arr[k] = tmp[curr++];
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

