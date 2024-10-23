import java.util.ArrayList;

//storing in a matrix is costly space wise
//
public class p1_graph_representation {
    public static void main(String[] args) {
        int n = 3, m = 3;

        //adjacency matrix
        int[][] adj = new int[n+1][m+1];

        // 1 - 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //2 - 3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //1 - 3
        adj[1][3] = 1;
        adj[3][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(2).add(3);
        adjList.get(3).add(2);

        adjList.get(1).add(3);
        adjList.get(3).add(1);

        for(int i=1; i<=n; i++){
            for(int j=0; j<adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
