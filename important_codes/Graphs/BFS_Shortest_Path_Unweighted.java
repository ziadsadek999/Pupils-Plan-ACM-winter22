package important_codes.Graphs;

import java.awt.Point;
import java.util.*;

public class BFS_Shortest_Path_Unweighted {

	// A function that return the minimum number of edges you pass on to reach your
	// target, if the target is unreachable, return -1.
	public static int shortestPath(int from, int to, LinkedList<Integer> graph[]) {
		boolean vis[] = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		int cost = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			while (n-- > 0) {
				int curr = q.poll();
				if (!vis[curr]) {
					if (curr == to)
						return cost;
					vis[curr] = true;
					for (int neighbour : graph[curr]) {
						q.add(neighbour);
					}
				}
			}
			cost++;
		}
		return -1;
	}

	// A function that returns a linked list of the nodes visited along the shortest
	// path.
	public static LinkedList<Integer> getNodesShortestPath(int from, int to, LinkedList<Integer> graph[]) {
		int vis[][] = new int[2][graph.length];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(from, -1));
		boolean isFound = false;
		while (!q.isEmpty() && !isFound) {
			int n = q.size();
			while (n-- > 0) {
				Point curr = q.poll();
				if (vis[0][curr.x] == 0) {
					vis[0][curr.x] = 1;
					vis[1][curr.x] = curr.y;
					if (curr.x == to) {
						isFound = true;
						break;
					}
					for (int neighbour : graph[curr.x]) {
						q.add(new Point(neighbour, curr.x));
					}
				}
			}
		}
		if (!isFound)
			return null;
		LinkedList<Integer> res = new LinkedList<Integer>();
		int curr = to;
		while (curr != -1) {
			res.addFirst(curr);
			curr = vis[1][curr];
		}
		return res;
	}
}
