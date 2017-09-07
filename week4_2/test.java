package week4_2;

public class test {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][] {
                {true, true, true, false, true, false, false},
                {true, true, true, true, false, false, false},
                {true, false, true, true, false, false, false}
        };
        TetrisGrid grid1 = new TetrisGrid(grid);
        grid1.clearRows();
        grid = grid1.getGrid();
        for(int j = grid[0].length-1; j>=0; j--){
            for(int i = 0; i<grid.length; i++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}