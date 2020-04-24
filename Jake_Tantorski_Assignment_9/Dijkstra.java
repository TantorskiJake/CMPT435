public class Dijkstra {

	// Dijkstra's algorithm to find shortest path from s to all other nodes

	public static int[] dijkstra(WeightedGraph G, int s) {

		int[] dist = new int[G.size()]; // estimated shortest known distance from "s"

		int[] pred = new int[G.size()]; // preceding node in path

		boolean[] visited = new boolean[G.size()]; // all false initially

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE; // set to infinity initially
		}

		dist[s] = 0;


		for (int i = 0; i < dist.length; i++)
		{

			int next = minVertex(dist, visited);
			// Select the next vertex to add to the tree
			// Vertex "next": not in the tree and has min dist[] value

			visited[next] = true;

			// The shortest path to vertext next is dist[next] and via pred[next].

			int[] n = G.neighbors(next);
			// Find the neighbors of vertex "next"
			/*
			Complete the function here to do relaxation on vertex "next"'s neighbors
			Hint: Follow the pseudocode of Dijkstra's algorithm in the slides
			*/
			//loop through all of the neighobrs of the vertex
			int k = 0;
			while(k<n.length)
			{
					int vert = n[k];
					// if the distance of the vertex is greater than the distance of the next vertex and the weight of the next vertex using the getWeight function
					if (dist[vert] > dist[next] + G.getWeight(next,vert))
					{
						//assigned the distance of the vertex to the distance of the next vertex and the weight of the next vertex
						dist[vert] = dist[next] + G.getWeight(next,vert);
						//assign the pred to the next vertex in the graph
						pred[vert] = next;
				 	}
					k++;
		 }
		}
		return pred; // (ignore pred[s]==0!)
	}

	private static int minVertex(int[] dist, boolean[] v) {
		int x = Integer.MAX_VALUE;
		int y = -1; // graph not connected, or no unvisited vertices
		for (int i = 0; i < dist.length; i++) {
			if (!v[i] && dist[i] < x) {
				// unvisited -- not in the tree yet, and smaller dist[]
				y = i;
				x = dist[i];
			}
		}
		return y;
	}

	public static void printPath(WeightedGraph G, int[] pred, int s, int e) {
		java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x != s) {
			path.add(0, G.getLabel(x));
			x = pred[x];
		}
		path.add(0, G.getLabel(s));
		System.out.println(path);
	}

}
