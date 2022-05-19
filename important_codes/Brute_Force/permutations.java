package important_codes;

import java.util.*;

public class permutations {
	static boolean vis[];
	static LinkedList<Integer> l;

	public static void main(String[] args) {
		vis = new boolean[3];
		l = new LinkedList<Integer>();
		int[] arr = { 1, 2, 3 };
		generate(arr);
	}

	public static void generate(int[] arr) {
		boolean done = true;
		for (int i = 0; i < arr.length; i++) {
			if (!vis[i]) {
				done = false;
				vis[i] = true;
				l.add(arr[i]);
				generate(arr);
				l.removeLast();
				vis[i] = false;
			}
		}
		if (done) {
			System.out.println(l);
		}
	}
}
