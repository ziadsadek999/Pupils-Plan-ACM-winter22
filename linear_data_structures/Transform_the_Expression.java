
package linear_data_structures;import java.util.*;
import java.io.*;

public class Transform_the_Expression {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.nextLine();
			StringBuilder res = new StringBuilder();
			Stack<Character> st = new Stack<Character>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					res.append(s.charAt(i));
				} else {
					if(s.charAt(i)=='(') {
						st.push(s.charAt(i));
					}
					else {
						if(s.charAt(i)==')') {
							while(st.peek()!='(') {
								res.append(st.pop());
							}
							st.pop();
						}
						else {
							if(st.isEmpty()||st.peek()=='('||getPriority(st.peek())<=getPriority(s.charAt(i))) {
								st.push(s.charAt(i));
							}
							else {
								while(st.peek()!='('&&getPriority(st.peek())>=getPriority(s.charAt(i))) {
									res.append(st.pop());
								}
								st.push(s.charAt(i));
							}
						}
					}

				}
			}
			pw.println(res);
		}
		pw.flush();
	}

	public static int getPriority(char x) {
		switch (x) {
		case '+':
			return 1;
		case '-':
			return 2;
		case '*':
			return 3;
		case '/':
			return 4;
		default:
			return 5;
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

