package binary_search;
import java.util.*;
import java.io.*;

public class New_Years_Problem {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			sc.nextLine();
			int m = sc.nextInt();
			int n = sc.nextInt();
			long[][] joy = new long[m][n];
			long max = 0;
			for (int i = 0; i < joy.length; i++) {
				for (int j = 0; j < joy[0].length; j++) {
					joy[i][j] = sc.nextInt();
					max = Math.max(max, joy[i][j]);
				}
			}
			long l = 0;
			long h = max;
			while (l <= h) {
				long mid = (l + h) / 2;
				HashSet<Integer> hs = new HashSet<Integer>();
				int vis = -1;
				for (int i = 0; i < joy.length; i++) {
					HashSet<Integer> tmp = new HashSet<Integer>();
					for (int j = 0; j < joy[0].length; j++) {
						if (joy[i][j] >= mid) {
							tmp.add(j);
						}
					}
					if (tmp.size() > 1) {
						vis = i;
						hs = tmp;
						break;
					}
				}
				if (vis == -1) {
					h = mid - 1;
				} else {
					for (int i = 0; i < joy.length; i++) {
						if (i != vis) {
							for (int j = 0; j < joy[0].length; j++) {
								if (joy[i][j] >= mid) {
									hs.add(j);
								}
							}
						}
					}
					if (hs.size() == n) {
						l = mid + 1;
					} else {
						h = mid - 1;
					}
				}
			}
			pw.println(h);
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

