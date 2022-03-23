package brute_force_2;

import java.io.*;
import java.util.*;

public class prime_ring_problem {
	static PrintWriter pw;
	static boolean vis[];
	static HashSet<Integer> primes;
	static ArrayList<Integer> perm;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		int c = 1;
		primes = new HashSet<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		primes.add(17);
		primes.add(19);
		primes.add(23);
		primes.add(29);
		primes.add(31);
		// Thread.sleep(3000);
		while (sc.ready()) {
			int n = sc.nextInt();
			if (c != 1)
				pw.println();
			pw.println("Case " + c + ":");
			vis = new boolean[n];
			perm = new ArrayList<Integer>();
			perm.add(1);
			vis[0] = true;
			solve(1);
			c++;
		}
		pw.flush();
	}

	public static void solve(int count) {
		if (count == vis.length) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < perm.size(); i++) {
				res.append(perm.get(i));
				if (i != perm.size() - 1)
					res.append(" ");
			}
			pw.println(res);
			return;
		}
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				int curr = i + 1;
				int prev = perm.get(perm.size() - 1);
				if (count == vis.length - 1) {
					if (primes.contains(curr + prev) && primes.contains(curr + 1)) {
						vis[i] = true;
						perm.add(curr);
						solve(count + 1);
						vis[i] = false;
						perm.remove(perm.size() - 1);
					}
				} else {
					if (primes.contains(curr + prev)) {
						vis[i] = true;
						perm.add(curr);
						solve(count + 1);
						vis[i] = false;
						perm.remove(perm.size() - 1);
					}
				}
			}
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
