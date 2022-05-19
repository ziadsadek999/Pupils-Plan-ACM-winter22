package important_codes;

import java.util.*;

public class Bipartite {
	public static boolean isBibartite(LinkedList<Integer> graph[]) {
		int[] vis = new int[graph.length];
		boolean res = true;
		for (int i = 0; i < vis.length; i++) {
			if (vis[i] == 0) {
				res &= isBipartiteHelper(i, graph, vis, 1);
			}
		}
		return res;
	}

	public static boolean isBipartiteHelper(int curr, LinkedList<Integer> graph[], int vis[], int set) {
		if (vis[curr] != 0) {
			if (vis[curr] == set)
				return true;
			return false;
		}
		vis[curr] = set;
		if (set == 1)
			set = 2;
		else
			set = 1;
		boolean res = true;
		for (int x : graph[curr]) {
			res &= isBipartiteHelper(x, graph, vis, set);
		}
		return res;
	}
}
