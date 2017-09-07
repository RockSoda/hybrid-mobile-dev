package week4_2;

public class TetrisGrid {
    boolean[][] grid;

    TetrisGrid(boolean[][] grid){
        if(grid.length > 0 && grid[0].length > 0){
            this.grid = grid;
        }
    }

    public boolean[][] getGrid(){
        return grid;
    }

    public void clearRows(){
        for(int i = 0; i<grid[0].length; i++){
            int counter = 0;
            for(int j = 0; j<grid.length; j++){
                if(grid[j][i]){
                    counter++;
                }
            }
            if(counter == grid.length){
                for(int j = 0; j<grid.length; j++){
                    grid[j][i] = false;
                }

                for(int m = i; m<grid[0].length-1; m++){
                    for(int n = 0; n<grid.length; n++){
                        grid[n][m] = grid[n][m+1];
                    }
                }

            }

        }

    }
}
