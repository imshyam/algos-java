import java.util.LinkedList;
import java.util.Stack;

/*
  0------2------3
  |      |     /|
  |      |    / |
  |      |   /  |
  1------4  6   5
*/

class Graph {
  private int V; // Numver of vertices
  private LinkedList<Integer>[] adjListArray; // AdjacencyList Array

  @SuppressWarnings("unchecked")
  Graph(int V) {
    this.V = V;
    adjListArray = new LinkedList[V];
    for (int i = 0; i < V; i++) {
      adjListArray[i] = new LinkedList<>();
    }
  }

  void addEdge(int src, int dest) {
    // un directed graph
    adjListArray[src].add(dest);
    adjListArray[dest].add(src);
  }

  void printGraph() {
    for(int i = 0; i < V; i++) {
      System.out.print(i + " :: Head -> ");
      for (Integer vertex: adjListArray[i]) {
        System.out.print(vertex + " -> ");
      }
      System.out.println();
    }
  }

  private void DFSUtilStack(int fromNode, boolean[] visited) {
    Stack<Integer> stk = new Stack<>();
    stk.push(fromNode);
    visited[fromNode] = true;
    while (!stk.isEmpty()) {
      int node = stk.pop();
      System.out.print(node + " ");
      LinkedList<Integer> connections = adjListArray[node];
      for (Integer i: connections) {
        if (!visited[i]) {
          visited[i] = true;
          stk.push(i);
        }
      }
    }
  }

  private void DFSUtilRecursive(int fromNode, boolean[] visited) {
    visited[fromNode] = true;
    System.out.print(fromNode + " ");
    LinkedList<Integer> connections = adjListArray[fromNode];
    for (Integer node: connections) {
      if (!visited[node])
        DFSUtilRecursive(node, visited);
    }
  }

  void DFS(int fromNode) {
    boolean[] visited = new boolean[V];
    System.out.println("Stack: ");
    DFSUtilStack(fromNode, visited);
    System.out.println();
    visited = new boolean[V];
    System.out.println("Recursive: ");
    DFSUtilRecursive(fromNode, visited);
    System.out.println();
  }
}

public class GraphDFS {

  public static void main(String[] args) {
    Graph g = new Graph(7);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 4);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 5);
    g.addEdge(3, 6);
    g.printGraph();
    g.DFS(0);
  }

}