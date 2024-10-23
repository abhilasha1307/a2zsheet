import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p6_flood_fill {
    public static class Pair {
        int row;
        int col; 

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        int[][] grid = new int[n][m];

        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;

        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;

        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 1;

        // grid[3][0] = '0';
        // grid[3][1] = '0';
        // grid[3][2] = '0';
        // grid[3][3] = '0';

        // grid[4][0] = '1';
        // grid[4][1] = '1';
        // grid[4][2] = '0';
        // grid[4][3] = '1';

        int sr = 1;
        int sc = 1;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int newColour = 2;
        int[][] floodFill = floodFill(grid, sr, sc, newColour);

        System.out.println();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(floodFill[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] floodFill(int[][] grid, int sr, int sc, int newColour){
        int n = grid.length;
        int m = grid[0].length;

        int[][] floodFill = new int[n][m];
        floodFill = grid;

        // bfs(sr, sc, floodFill, newColour, floodFill[sr][sc], visited);
        dfs(sr, sc, floodFill, grid, newColour, floodFill[sr][sc]);
        return floodFill;
    }

    private static void bfs(int sr, int sc, int[][] floodFill, int[][] grid, int newColour, int initialColour){
        floodFill[sr][sc] = newColour;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int n = floodFill.length;
        int m = floodFill[0].length;

        while(!q.isEmpty()){
            int ro = q.peek().row;
            int co = q.peek().col;

            q.remove();

            //for traversing all 4 directions 
            for(int delrow = -1; delrow<=1; delrow++){
                int nrow = ro + delrow;
                if(nrow >= 0 && nrow < n && floodFill[nrow][co] != newColour && grid[nrow][co] == initialColour){
                    floodFill[nrow][co] = newColour;
                    q.add(new Pair(nrow, co));
                }
            }

            for(int delcol = -1; delcol<=1; delcol++){
                int ncol = co + delcol;
                if(ncol >= 0 && ncol < m && floodFill[ro][ncol] != newColour && grid[ro][ncol] == initialColour){
                    floodFill[ro][ncol] = newColour;
                    q.add(new Pair(ro, ncol));
                }

            }
        }
    }

    private static void dfs(int sr, int sc, int[][] floodFill, int[][] grid, int newColour, int initialColour){
        floodFill[sr][sc] = newColour;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(sr, sc));
        int n = floodFill.length;
        int m = floodFill[0].length;

        while(!stack.isEmpty()){
            int ro = stack.peek().row;
            int co = stack.peek().col;

            stack.pop();

            for(int delrow = -1; delrow<=1; delrow++){
                int nrow = ro + delrow;
                if(nrow >= 0 && nrow < n && floodFill[nrow][co] != newColour && grid[nrow][co] == initialColour){
                    floodFill[nrow][co] = newColour;
                    stack.push(new Pair(nrow, co));
                }
            }

            for(int delcol = -1; delcol<=1; delcol++){
                int ncol = co + delcol;
                if(ncol >= 0 && ncol < m && floodFill[ro][ncol] != newColour && grid[ro][ncol] == initialColour){
                    floodFill[ro][ncol] = newColour;
                    stack.push(new Pair(ro, ncol));
                }

            }

        }
    }
}
