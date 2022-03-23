package brute_force_2;

import java.io.*;
import java.util.*;

public class the_sultans_successors {
	static int vis[][];
	static int board[][];
	static int max;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		while (n-- > 0) {
			board = new int[8][8];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			vis = new int[8][8];
			max = 0;
			solve(0, 0);
			String res = max + "";
			while (res.length() < 5) {
				res = " " + res;
			}
			pw.println(res);
		}
		pw.flush();
	}

	public static void solve(int currRow, int acc) {
		if (currRow == 8) {
			max = Math.max(max, acc);
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (vis[currRow][i] == 0) {
				put(currRow, i);
				solve(currRow + 1, acc + board[currRow][i]);
				remove(currRow, i);
			}
		}
	}

	public static void put(int x, int y) {
		vis[x][y]++;
		for (int i = x + 1; i < board.length; i++) {
			vis[i][y]++;
		}
		for (int i = x - 1; i >= 0; i--) {
			vis[i][y]++;
		}
		for (int i = y + 1; i < board.length; i++) {
			vis[x][i]++;
		}
		for (int i = y - 1; i >= 0; i--) {
			vis[x][i]++;
		}
		int i = x + 1;
		int j = y + 1;
		while (i < 8 && j < 8) {
			vis[i][j]++;
			i++;
			j++;
		}
		i = x + 1;
		j = y - 1;
		while (i < 8 && j >= 0) {
			vis[i][j]++;
			i++;
			j--;
		}
		i = x - 1;
		j = y - 1;
		while (i >= 0 && j >= 0) {
			vis[i][j]++;
			i--;
			j--;
		}
		i = x - 1;
		j = y + 1;
		while (i >= 0 && j < 8) {
			vis[i][j]++;
			i--;
			j++;
		}
	}

	public static void remove(int x, int y) {
		vis[x][y]--;
		for (int i = x + 1; i < board.length; i++) {
			vis[i][y]--;
		}
		for (int i = x - 1; i >= 0; i--) {
			vis[i][y]--;
		}
		for (int i = y + 1; i < board.length; i++) {
			vis[x][i]--;
		}
		for (int i = y - 1; i >= 0; i--) {
			vis[x][i]--;
		}
		int i = x + 1;
		int j = y + 1;
		while (i < 8 && j < 8) {
			vis[i][j]--;
			i++;
			j++;
		}
		i = x + 1;
		j = y - 1;
		while (i < 8 && j >= 0) {
			vis[i][j]--;
			i++;
			j--;
		}
		i = x - 1;
		j = y - 1;
		while (i >= 0 && j >= 0) {
			vis[i][j]--;
			i--;
			j--;
		}
		i = x - 1;
		j = y + 1;
		while (i >= 0 && j < 8) {
			vis[i][j]--;
			i--;
			j++;
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
