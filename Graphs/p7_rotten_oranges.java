import java.util.LinkedList;
import java.util.Queue;

/**
 * p7_rotten_oranges
 */

//SC : O(N*M)
//TC : O(N*M) + 4*O(N*M) ~ O(N*M)
public class p7_rotten_oranges {
    public static class Orange {
        int row;
        int col; 
        int time;

        public Orange(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        int[][] grid = new int[n][m];

        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[0][2] = 2;

        grid[1][0] = 0;
        grid[1][1] = 1;
        grid[1][2] = 1;

        grid[2][0] = 2;
        grid[2][1] = 1;
        grid[2][2] = 1;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(rottenOranges(grid));
    }

    static int rottenOranges(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<Orange> q = new LinkedList<>();

        int countFresh = 0;

        for(int i= 0 ; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Orange(i, j, 0));
                }else{
                    visited[i][j] = 0;
                }

                if(grid[i][j] == 1){
                    countFresh++;
                }

            }
        }

        return bfs(grid, visited, q, countFresh);

    }

    private static int bfs(int[][] grid, int[][] visited, Queue<Orange> q, int countFresh){
        int n = grid.length;
        int m = grid[0].length;

        int finalTime = 0;
        int count = 0;

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};

        while(!q.isEmpty()){
            Orange orange = q.poll();
            int ro = orange.row;
            int co = orange.col;
            int time = orange.time;

            finalTime = Math.max(finalTime, time);

            for(int i = 0;i<4; i++){
                int nrow = ro + dRow[i];
                int ncol = co + dCol[i];
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol<m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Orange(nrow, ncol, time+1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        //compared to check if all the fresh oranges are converted to rotten oranges or not, if not return -1
        if(countFresh != count) return -1;
        return finalTime;
    }
}