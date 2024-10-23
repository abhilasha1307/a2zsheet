// SC : O(N) + O(N) = 2*O(N) ~ O(N); where N is the number of vertices
// TC : O(N) + O(N + 2E) [starting node on which dfs will be called + dfs which will vary depending on the neighbour nodes]

import java.util.ArrayList;
import java.util.Stack;

public class p4_number_of_provinces {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjMat = new ArrayList<>();
        adjMat.add(new ArrayList<Integer>());
        adjMat.get(0).add(0,1);
        adjMat.get(0).add(1,0);
        adjMat.get(0).add(2,1);

        adjMat.add(new ArrayList<Integer>());
        adjMat.get(1).add(0,0);
        adjMat.get(1).add(1,1);
        adjMat.get(1).add(2,0);

        adjMat.add(new ArrayList<Integer>());
        adjMat.get(2).add(0,1);
        adjMat.get(2).add(1,0);
        adjMat.get(2).add(2,1);

        System.out.println(numOfProvinces(3, adjMat));
    }

    //TC for this function : O(n)
    public static int numOfProvinces(int V, ArrayList<ArrayList<Integer>> adjMat){
        int provinces = 0;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<=V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<V; i++){
            for(int j = 0; j<V; j++){
                if(adjMat.get(i).get(j) == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                provinces++;
                dfs(i, adjList, vis);
            }
        }

        return provinces;
    }

    //TC for this function : O(v) + O(2e)
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        Stack<Integer> stk = new Stack<>();
        stk.push(node);
        visited[node] = 1;

         while(!stk.isEmpty()){
            int tempNode = stk.peek();
            stk.pop();

            for(Integer it : adjList.get(tempNode)){
                if(visited[it] == 0){
                    stk.push(it);
                    visited[it] = 1;
                }
            }
        }

    }
}
