import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p2_bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 9;

        for(int i=0; i<=V; i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(1).add(6);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(2);

        adj.get(4).add(2);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(8);

        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(5);
        adj.get(8).add(7);

        adj.get(9).add(6);

        System.out.println(bfs(V, adj));
    }

    //1 based indexing
    public static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean[] visited = new boolean[V+1];
        //boolean[] visited = new boolean[V]; for 0 based indexing
        Queue<Integer> q = new LinkedList<>();

        //q.add(0); for 0 based indexing
        q.add(1);

        //visited[0] = true; for 0 based indexing
        visited[1] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)){
                if(visited[it] == false){
                    q.add(it);
                    visited[it] = true;
                }
            }
        }
        return bfs;
    }
}
