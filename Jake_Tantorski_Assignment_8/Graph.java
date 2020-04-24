import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Graph {
	private Vertex vertexList[];
	private int adjMat[][]; //adjacency matrix
	private LinkedList<LinkedList<Integer>> adjlist; //adjacency list
	private int vertexcycleflag[]; //for detecting cycles
	private int nVerts;
	private Stack<Integer> theStack; //for DFS
	private Queue theQueue; //for BFS

	public static void main(String[] args) {

		char[] element = {'0','1','2','3','4','5'};
		Graph theGraph = new Graph(element.length);
		 for(char s :element){
		   theGraph.addVertex(s);
		  }
		theGraph.addEdge(0,1);
		theGraph.addEdge(0,2);
		theGraph.addEdge(1,2);
		theGraph.addEdge(1,3);
		theGraph.addEdge(2,3);
		theGraph.addEdge(3,4);
		theGraph.addEdge(4,0);
		theGraph.addEdge(4,1);
		theGraph.addEdge(4,5);
		theGraph.detectcycle();
		theGraph.printList(element.length);
	}

	public void printList(int n){
		for (int i = 0; i < n; i++) {
        System.out.print("Node " + i + " is adjacent to: ");
        for (int j = 0; j < n; j++) {
            if (adjMat[i][j] == 1) {
                System.out.print(j + " ");
            }
        }
        System.out.print("\n");
    }
	}


	 public Graph(int n) {

		  vertexList = new Vertex[n];
		  vertexcycleflag = new int[n];//For detecting cycles, nodes are either -1, 0, or 1

		  for  (int i = 0; i < n; i++) {
			  vertexcycleflag[i] = -1; //Initially, all nodes are -1
		  }

		  //adj matrix
		  adjMat = new int[n][n];
		  nVerts = 0;
		  for (int i = 0; i < n; i++) {
		   for (int j = 0; j < n; j++) {
		    adjMat[i][j] = 0;
		   }
		  }

		  //adj list

		  adjlist = new LinkedList<LinkedList<Integer>>();
		  for (int i = 0; i < n; i++) {

				adjlist.add(new LinkedList<Integer>());
			}

		  theStack = new Stack<Integer>();
		  theQueue = new Queue();
		 }



	public void addVertex(char nodename) {// add vertex
		vertexList[nVerts++] = new Vertex(nodename);
	}

	public void addEdge(int start, int end) {// directed
		//adj matrix
		adjMat[start][end] = 1;

		//adjMat[end][start] = 1; for undirected graph
		//adj list

		if(!adjlist.get(start).contains(end))
			adjlist.get(start).add(end);

		/* if(!adjlist.get(end).contains(start))
			adjlist.get(end).add(start); // for undirected graph
		*/

	}

	public void displayVertex(int v) {// print vertex label
		System.out.print(vertexList[v].lable);
	}

	public int getAdjUnvisitedVertex(int v) {// get an unvisited connected vertex
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}


	//Get a connected vertex that is not 1
	public int getAdjVert(int vertex)
	{
		for (int i = 0; i < nVerts; i++)
		{
			if (adjMat[vertex][i] == 1 && vertexcycleflag[i]!=1) {
				return i;
			}
		}
		return -1;
	}

	public boolean dfscycle(int vertex) {
			for(int i = 0; i <vertexcycleflag.length; i++)
				vertexcycleflag[i] = -1;
			theStack.clear();
			//Initially, all nodes are -1

			//Visit the starting node
			vertexcycleflag[vertex] = 0;
			displayVertex(vertex);
			theStack.push(vertex);


			while (!theStack.isEmpty()) {

				int nextTo = getAdjVert(theStack.peek());
				// find a nextTo that is not 1
				if (nextTo == -1)
				{
					// all nextTos are visited
					int b = theStack.pop();
					vertexcycleflag[b] = 1;
				}
				else if (vertexcycleflag[nextTo] == 0)
					// exist a nextTo that is 0
					return true;
				else
				{
					// no nextTos 0, but exist nextTos unvisited
					vertexcycleflag[nextTo]= 0;
					displayVertex(nextTo);
					theStack.push(nextTo);
				}
			}
			return false;
	}

	public void detectcycle() {
		boolean flag = false;
		for (int i = 0; i <vertexcycleflag.length; i++) {
			// call dfscycle from each vertext i
			if (dfscycle(i)) {
				flag = true;
				break;
			}
		}
		System.out.println(" Does the graph contain a cycle? "+ flag);
	}








	public void dfs() {// DFS using stack

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;// Reset the wasvisited matrix
		}
		//Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(nVerts);

		//Visit the starting node
		vertexList[randNum].wasVisited = true;
		displayVertex(randNum);
		theStack.push(randNum);

		while (!theStack.isEmpty()) {
			int nextTo = getAdjUnvisitedVertex(theStack.peek());
			if (nextTo == -1) {
				theStack.pop();
			} else {
				vertexList[nextTo].wasVisited = true;
				displayVertex(nextTo);
				theStack.push(nextTo);
			}
		}


	}




	public void bfs() {// BFS using a queue

		for (int j = 0; j < nVerts; j++) {
				vertexList[j].wasVisited = false; // Reset the wasvisited matrix
		}
		//Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(nVerts);

		//Visit the starting node
		vertexList[randNum].wasVisited = true;
		displayVertex(randNum);
		theQueue.insert(randNum);


		while (!theQueue.isEmpty()) {
			int currentv = theQueue.remove();
			int nextTo;
			while ((nextTo = getAdjUnvisitedVertex(currentv)) != -1) {
				vertexList[nextTo].wasVisited = true;
				displayVertex(nextTo);
				theQueue.insert(nextTo);
			}
		}


	}

}
