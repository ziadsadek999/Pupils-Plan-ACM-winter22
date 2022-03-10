package non_linear_data_structures;
import java.util.*;
import java.io.*;

public class Andys_First_Dictionary{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		TreeSet<String> h = new TreeSet<String>();
		Thread.sleep(3000);
		while (br.ready()) {
			String s = br.readLine().toLowerCase();
			
			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				StringBuilder r = new StringBuilder();
				while ((x >= 'a' && x <= 'z')) {
					r.append(x);
					i++;
					if (i == s.length())
						break;
					x = s.charAt(i);
				}
				if (r.toString().length() > 0) {
					h.add(r.toString());
				}
			}
		}

		while (!h.isEmpty()) {
			pw.println( h.pollFirst());
		}
		pw.flush();
	}
}

