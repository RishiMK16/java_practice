import java.util.*;
public class DFS {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());   
        adj.get(0).add(1);
        adj.get(0).add(4);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        DFS Dfs = new DFS();
        System.out.println("DFS traversal of the given graph is:");
        Dfs.DfsGraph(V, adj).forEach(System.out::print);
    }

    public ArrayList<Integer> DfsGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V+1];
        visited[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfsAr(0, visited, adj, dfs); 
        return dfs;
    }
    
    public void dfsAr(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);
        for(Integer it:adj.get(node)){
            if(visited[it]==false){
                visited[it] = true;
                dfsAr(it, visited, adj, dfs);
            }
        }

    }

}
