package important_codes.Graphs;

import java.util.*;

public class Topological_Sort {
	public static int[] topoSort(ArrayList<Integer>[] graph) {
		boolean vis[] = new boolean[graph.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i])
				topoSortHelper(graph, vis, stack, i);
		}
		int[] res = new int[graph.length];
		int i = 0;
		while (!stack.isEmpty())
			res[i++] = stack.pop();
		return res;

	}

	public static void topoSortHelper(ArrayList<Integer>[] graph, boolean[] vis, Stack<Integer> st, int curr) {
		if (vis[curr])
			return;
		vis[curr] = true;
		for (int x : graph[curr])
			topoSortHelper(graph, vis, st, x);
		st.push(curr);
	}
}
