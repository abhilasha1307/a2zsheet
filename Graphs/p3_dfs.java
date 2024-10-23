import java.util.ArrayList;
import java.util.Stack;

public class p3_dfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;

        for(int i = 0; i<=V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);

        adj.get(6).add(2);

        adj.get(7).add(3);
        adj.get(7).add(8);

        adj.get(8).add(4);
        adj.get(8).add(7);

        System.out.println(dfs(V, adj));
        System.out.println(dfsIterative(V, adj));
    }

    public static ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1]; //V+1 because we are considering a 1 based graph
        // vis[1] = true;
        dfsOnGraph(vis, 1, adj, dfs);
        return dfs;
    }

    public static void dfsOnGraph(boolean[] visited, int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for(Integer it : adj.get(node)){
            if(visited[it] == false){
                visited[it] = true;
                dfsOnGraph(visited, it, adj, dfs);
            }
        }

    }

    public static ArrayList<Integer> dfsIterative(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs = new ArrayList<>();

        boolean[] visited = new boolean[V+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while(!stack.isEmpty()){
            int temp = stack.peek();
            stack.pop();

            dfs.add(temp);

            for(Integer it : adj.get(temp)){
                if(!visited[it]){
                    stack.push(it);
                    visited[it] = true;
                }
            }
        }

        return dfs;
    }
}
