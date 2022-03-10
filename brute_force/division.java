package brute_force;

import java.io.*;
import java.util.*;

public class division {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		while (true) {
			ArrayList<String> res = new ArrayList<String>();
			for (int i = 01234; i <= 98765; i++) {
				if (i % n == 0) {
					if (distinct(i, i / n)) {
						int x = i;
						int y = i / n;
						String s = x + "";
						if (x < 10000)
							s = "0" + s;
						String z = y + "";
						if (y < 10000)
							z = "0" + z;
						res.add(s + " / " + z + " = " + n);
					}
				}
			}
			if (res.size() == 0)
				pw.println("There are no solutions for " + n + ".");
			else {
				for (String x : res) {
					pw.println(x);
				}
			}
			n = sc.nextInt();
			if (n == 0)
				break;
			pw.println();
		}
		pw.flush();
	}

	public static boolean distinct(int x, int y) {
		if (x < 1234 || y < 1234)
			return false;
		String s = x + "";
		if (x < 10000)
			s = "0" + s;
		String z = y + "";
		if (y < 10000)
			z = "0" + z;
		HashSet<Character> hs = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			hs.add(s.charAt(i));
			hs.add(z.charAt(i));
		}
		if (hs.size() == 10)
			return true;
		return false;
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
