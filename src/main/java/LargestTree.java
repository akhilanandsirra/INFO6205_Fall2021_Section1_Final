import java.util.*;

class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;
        for (int i = 0; i < adj[u].size(); i++)
            if (!visited.get(adj[u].get(i)))
                size += DFS(adj[u].get(i),adj, visited);
        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        int largestTree = 0;
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++){
            visited.add(false);
        }
        for (int u = 0; u < V; u++)
        {
            if (!visited.get(u)) {
                largestTree = Math.max(largestTree, DFS(u, adj, visited));
            }
        }
        return largestTree;
    }
}