package non_linear_data_structures;
import java.util.*;
import java.io.*;

public class Word_Index{
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		char x = 'a';
		for (int i = 0; i < 26; i++) {
			arr.add(x+"");
			x++;
		}
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).length()<2) {
				char z = arr.get(i).charAt(arr.get(i).length()-1);
				z++;
				while(z<='z') {
					arr.add(arr.get(i)+z);
					z++;
				}
			}
			else
				break;
		}
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).length()==2) {
				char z = arr.get(i).charAt(arr.get(i).length()-1);
				z++;
				while(z<='z') {
					arr.add(arr.get(i)+z);
					z++;
				}
			}
			else {
				if(arr.get(i).length()>2)
					break;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).length()==3) {
				char z = arr.get(i).charAt(arr.get(i).length()-1);
				z++;
				while(z<='z') {
					arr.add(arr.get(i)+z);
					z++;
				}
			}
			else {
				if(arr.get(i).length()>3)
					break;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).length()==4) {
				char z = arr.get(i).charAt(arr.get(i).length()-1);
				z++;
				while(z<='z') {
					arr.add(arr.get(i)+z);
					z++;
				}
			}
			else {
				if(arr.get(i).length()>4)
					break;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).length()==5) {
				char z = arr.get(i).charAt(arr.get(i).length()-1);
				z++;
				while(z<='z') {
					arr.add(arr.get(i)+z);
					z++;
				}
			}
			else {
				if(arr.get(i).length()>5)
					break;
			}
		}
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			hm.put(arr.get(i), i+1);
		}
		//Thread.sleep(3000);
		while(sc.ready()) {
			String s = sc.nextLine();
			pw.println(hm.getOrDefault(s,0));
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
