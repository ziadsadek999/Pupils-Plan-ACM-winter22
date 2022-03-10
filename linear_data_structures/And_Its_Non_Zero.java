package linear_data_structures;
import java.util.*;
import java.io.*;

public class And_Its_Non_Zero {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int[][] arr = new int[25][200000];
		int mask = 1;
		int curr = 0;
		while (mask <= 200000) {
			for (int i = 0; i < 200000; i++) {
				if ((mask & (i + 1)) != 0) {
					arr[curr][i] = 1;
				}
			}
			curr++;
			mask <<= 1;
		}
		int[][] prefixSum = new int[25][200000];
		for (int i = 0; i < prefixSum.length; i++) {
			prefixSum[i][0] = arr[i][0];
			for (int j = 1; j < prefixSum[0].length; j++) {
				prefixSum[i][j] = prefixSum[i][j - 1] + arr[i][j];
			}
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int max = 0;
			for (int i = 0; i < prefixSum.length; i++) {
				if (l > 1)
					max = Math.max(max, prefixSum[i][r - 1] - prefixSum[i][l - 2]);
				else
					max = Math.max(max, prefixSum[i][r - 1]);
			}
			pw.println((r - l + 1) - max);
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

