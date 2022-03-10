package sorting;
import java.util.*;
import java.io.*;

public class Take_Your_Places {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int cEven = 0;
			int cOdd = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 0)
					cEven++;
				else
					cOdd++;
			}
			if (Math.abs(cEven - cOdd) > 1) {
				// to make sure that the number of even elements equal the number of odd
				// elements, or one of them exceeds the other by one, so that the elements of
				// the resulting array can be alternating between even and odd
				pw.println(-1);
			} else {
				if (cEven > cOdd) {
					int result = 0;
					int currentIndex = 0;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] % 2 == 0) {
							result += Math.abs((i - currentIndex));
							currentIndex += 2;
						}
					}
					pw.println(result);
				} else if (cOdd > cEven) {
					int result = 0;
					int currentIndex = 0;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] % 2 == 1) {
							result += Math.abs((i - currentIndex));
							currentIndex += 2;
						}
					}
					pw.println(result);
				} else {
					int result1 = 0;
					int currentIndex = 0;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] % 2 == 1) {
							result1 += Math.abs((i - currentIndex));
							currentIndex += 2;
						}
					}
					int result2 = 0;
					currentIndex = 0;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] % 2 == 0) {
							result2 += Math.abs((i - currentIndex));
							currentIndex += 2;
						}
					}
					pw.println(Math.min(result1, result2));
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

