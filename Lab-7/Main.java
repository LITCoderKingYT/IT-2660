class Main {
  public static void main(String[] args) {
    String[] vertices = {"Liberal Arts", "Student Services", "Health Careers & Sciences", "Health Technologies Center", "Recreation Center", "Technology Learning Center", "Business & Technology", "Theatre"};

    int[][] edges = {
      {0,1}, {1,0}, {1,2}, {2,1}, {2,3}, {3,2}, {3,4}, {4,3}, {4,5}, {5,4}, {5,6}, {6,5}, {6,7}, {7,6}, {0,7}, {7,0}
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    System.out.println("Path from Business & Technology to Health Technologies Center: ");
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();

    System.out.println("Path from Business & Technology to Student Services: ");
    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();

    System.out.println("Path from Business & Technology to Recreation Center: ");
    dfs.printPath(graph.getIndex("Recreation Center"));
    System.out.println();

    dfs.printTree();
  }
}