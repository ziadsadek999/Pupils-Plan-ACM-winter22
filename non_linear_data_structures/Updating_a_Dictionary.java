package non_linear_data_structures;
import java.util.*;
import java.io.*;

public class Updating_a_Dictionary{

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			String Old = sc.nextLine();
			String[] OldArr;
			if (Old.length() > 2)
				OldArr = Old.substring(1, Old.length() - 1).split(",");
			else {
				OldArr = new String[0];
			}
			String New = sc.nextLine();
			String[] NewArr;
			if (New.length() > 2)
				NewArr = New.substring(1, New.length() - 1).split(",");
			else {
				NewArr = new String[0];
			}
			HashMap<String, String> oldHM = new HashMap<String, String>();
			HashMap<String, String> newHM = new HashMap<String, String>();
			TreeSet<String> added = new TreeSet<>();
			TreeSet<String> removed = new TreeSet<>();
			TreeSet<String> changed = new TreeSet<>();
			boolean flag = true;
			for (int i = 0; i < OldArr.length; i++) {
				String[] s = OldArr[i].split(":");
				
				oldHM.put(s[0], s[1]);
			}
			for (int i = 0; i < NewArr.length; i++) {
				String[] s = NewArr[i].split(":");
				
				if (!oldHM.containsKey(s[0])) {
					added.add(s[0]);
					flag = false;
				} else {
					if (!oldHM.get(s[0]).equals(s[1]) ) {
						changed.add(s[0]);
						flag = false;
					}
				}
				newHM.put(s[0], s[1]);
			}
			for (int i = 0; i < OldArr.length; i++) {
				String[] s = OldArr[i].split(":");
				if (!newHM.containsKey(s[0])) {
					removed.add(s[0]);
					flag = false;
				}
			}
			if (flag) {
				pw.print("No changes");
			} else {
				boolean f = true;
				if (!added.isEmpty()) {
					if (!f) {
						pw.println();
					}
					pw.print("+");
					while (!added.isEmpty()) {
						pw.print(added.pollFirst());
						if (added.size() != 0) {
							pw.print(",");
						}
					}

					f = false;

				}
				if (!removed.isEmpty()) {
					if (!f) {
						pw.println();
					}
					pw.print("-");
					while (!removed.isEmpty()) {
						pw.print(removed.pollFirst());
						if (removed.size() != 0) {
							pw.print(",");
						}
					}
					f = false;

				}
				if (!changed.isEmpty()) {
					if (!f) {
						pw.println();
					}
					pw.print("*");
					while (!changed.isEmpty()) {
						pw.print(changed.pollFirst());
						if (changed.size() != 0) {
							pw.print(",");
						}
					}
				}
			}
			pw.println();
			pw.println();
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

