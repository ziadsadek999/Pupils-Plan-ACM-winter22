package linear_data_structures;
import java.util.*;
import java.io.*;

public class Free_Spots{

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			int n = sc.nextInt();
			if (w == 0 && h == 0 && n == 0)
				break;
			int[][] arr = new int[w][h];
			int c = w * h;
			while (n-- > 0) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
					for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
						if (arr[i-1][j-1] == 0) {
							arr[i-1][j-1] = 1;
							c--;
						}
					}
				}
			}
			sc.nextLine();
			if (c == 0) {
				pw.println("There is no empty spots.");
			} else {
				if (c == 1) {
					pw.println("There is one empty spot.");
				} else {
					pw.println("There are " + c + " empty spots.");
				}
			}
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

