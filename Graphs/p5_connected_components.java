import java.util.LinkedList;
import java.util.Queue;

public class p5_connected_components {

    public static class Pair {
        int row;
        int col; 

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        char[][] grid = new char[n][m];

        grid[0][0] = '0';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '0';

        grid[1][0] = '0';
        grid[1][1] = '1';
        grid[1][2] = '1';
        grid[1][3] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '0';

        grid[4][0] = '1';
        grid[4][1] = '1';
        grid[4][2] = '0';
        grid[4][3] = '1';

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid){
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                //not visited but is a land component is the starting of an island, counting it as one component
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }

        return count;
    }

    private static void bfs(int row, int col, int[][] vis, char[][] grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int ro = q.peek().row;
            int co = q.peek().col;

            q.remove();

            //for traversing all 8 directions 
            for(int delrow = -1; delrow<=1; delrow++){
                for(int delcol = -1; delcol<=1; delcol++){
                    int nrow = ro + delrow;
                    int ncol = co + delcol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
