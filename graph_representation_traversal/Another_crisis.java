package graph_representation_traversal;

import java.io.*;
import java.util.*;

public class Another_crisis {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			// Constructing the graph of employees.
			int n = sc.nextInt();
			int t = sc.nextInt();
			if (n == 0 && t == 0)
				break;
			LinkedList<Integer> graph[] = new LinkedList[n + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			for (int i = 1; i <= n; i++) {
				int manager = sc.nextInt();
				graph[manager].add(i);
			}
			// We can define the problem recursively. We want to know the minimum number of
			// employees needed to file a petition in order for the petition to reach the
			// owner. We can create a recursive function called minimumEmployees that
			// answers this problem. For every employee, we will call this function on all
			// of his direct subordinates (children). We will store the answer for every
			// subordinate in a priorityqueue. After that we will get the sum of the minimum
			// t% of the answers and this will be the answer. The base case will be when we
			// reach a leaf we return 1 as the only way he can file a petition is that he
			// himself file it as he has no subordinates.
			pw.println(minimumEmployees(graph, 0, t));
		}
		pw.flush();
	}

	public static int minimumEmployees(LinkedList<Integer>[] graph, int curr, int t) {
		// base case
		if (graph[curr].size() == 0) {
			return 1;
		}
		// calculating the minimum number of subordinates needed to file the petition.
		int min = (graph[curr].size() * t) / 100;
		if ((graph[curr].size() * t) % 100 != 0)
			min++;
		PriorityQueue<Integer> subGraphsSol = new PriorityQueue<Integer>();
		// calling the problem recursively on every subordinate and storing the results
		// in the priority queue in order to get the answers sorted.
		for (int x : graph[curr]) {
			subGraphsSol.add(minimumEmployees(graph, x, t));
		}
		int res = 0;
		// Calculate the sum of the minimum t% percent of the answers.
		while (min-- > 0) {
			res += subGraphsSol.poll();
		}
		return res;
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
