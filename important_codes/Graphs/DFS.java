package important_codes;

import java.util.*;

public class DFS {
	public static void dfsOnAdjacencyList(LinkedList<Integer>[] graph, int curr, boolean[] vis) {
		if (vis[curr])
			return;
		vis[curr] = true;
		System.out.println(curr);
		for (int x : graph[curr]) {
			dfsOnAdjacencyList(graph, x, vis);
		}
	}
}
