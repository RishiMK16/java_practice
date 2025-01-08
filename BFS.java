import java.util.*;
class BFS{
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
        BFS bfs = new BFS();
        System.out.println("BFS traversal of the given graph is:");
        bfs.bfsGraph(V, adj).forEach(System.out::print);
    }
    public ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[V];
        v[0] = true;
        q.add(0);
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer it: adj.get(node)){
                if(v[it]==false){
                    v[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}