import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p8_detect_cycle_undirected_graph {

    public static class Node{
        int parent;
        int child;

        public Node(int parent, int child){
            this.parent = parent;
            this.child = child;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        adjList.get(1).add(2);
        adjList.get(1).add(3);

        adjList.get(2).add(1);
        adjList.get(2).add(5);

        adjList.get(3).add(1);
        adjList.get(3).add(4);
        adjList.get(3).add(6);

        adjList.get(4).add(3);

        adjList.get(5).add(2);
        adjList.get(5).add(7);

        adjList.get(6).add(3);
        adjList.get(6).add(7);

        adjList.get(7).add(5);
        adjList.get(7).add(6);

        System.out.println(isCycle(n, adjList));
    }

    //using bfs

    //TC : O(N+2E) + O(N) [this is when there are multiple components in the graph]
    //SC : O(N) + O(N) ~ O(N)
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList){
        boolean[] vis = new boolean[V+1]; 
        for(int i = 0; i<=V; i++){
            vis[i] = false;
        }

        // for(int i = 0; i<=V; i++){
        //     if(vis[i] == false){
        //         if(checkForCycle(i, adjList, vis)){
        //             return true;
        //         }
        //     }
        // }

        for(int i = 0; i<=V; i++){
            if(vis[i] == false){
                if(dfsCheckCycle(i, -1, adjList, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[src] = true;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(-1, src));

        while(!q.isEmpty()){
            int parent = q.peek().parent;
            int node = q.peek().child;

            q.remove();

            for(int adjNode : adjList.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.add(new Node(node, adjNode));
                }
                else if(adjNode != parent){
                    return true;
                }
            }
        }
        return false;
    }

    //using dfs

    //TC : 
    static boolean dfsCheckCycle(int node, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        
        for(int adjNode : adjList.get(node)){
            if(vis[adjNode] == false){
                if(dfsCheckCycle(adjNode, node, adjList, vis)){
                    return true;
                }
            }
            else if(parent != adjNode){
                return true;
            }
        }
        return false;
    }


}
