package non_linear_data_structures;
import java.util.*;
import java.io.*;

public class The_Department_of_Redundancy_Department{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder in = new StringBuilder();
		//Thread.sleep(5000);
		while(sc.ready()) {
			in.append(sc.nextLine());
			in.append(" ");
		}
		
		
		String s = in.toString();
		StringTokenizer st = new StringTokenizer(s);
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		while(st.hasMoreTokens()) {
			String x = st.nextToken();
			hm.put(x, hm.getOrDefault(x, 0)+1);
		}
		st = new StringTokenizer(s);
		while(st.hasMoreTokens()) {
			String x = st.nextToken();
			if(hm.containsKey(x)) {
				pw.println(x+" "+hm.get(x));
				hm.remove(x);
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

