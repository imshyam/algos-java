import java.util.LinkedList;

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
}

public class GraphAdjacencyList {
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
  }
  
}