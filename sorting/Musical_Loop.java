package sorting;
import java.util.*;
import java.io.*;

public class Musical_Loop {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int c = 0;
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1])
					c++;
				else if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i])
					c++;
			}
			int last = arr.length - 1;
			if (arr[0] > arr[1] && arr[0] > arr[last])
				c++;
			if (arr[0] < arr[1] && arr[0] < arr[last])
				c++;
			if (arr[last] > arr[last - 1] && arr[last] > arr[0])
				c++;
			if (arr[last] < arr[last - 1] && arr[last] < arr[0])
				c++;
			pw.println(c);
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

