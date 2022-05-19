package important_codes.Graphs;

import java.util.*;

public class Is_Directed_Acyclic_Graph {
	public static boolean isCyclic(ArrayList<Integer>[] graph) {
		int[] pos = new int[graph.length];
		int[] sorted = topoSort(graph);
		for (int i = 0; i < sorted.length; i++) {
			pos[sorted[i]] = i;
		}
		for (int i = 0; i < graph.length; i++) {
			for (int x : graph[i]) {
				if (pos[x] < pos[i])
					return true;
			}
		}
		return false;
	}

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
