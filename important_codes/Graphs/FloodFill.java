package important_codes;

public class FloodFill {
	// Every cell in the given grid is either 0 which means it is an empty cell or
	// -1 which means that this cell has an obstacle.
	// When you are in row i column j, you can move to row i column j+1, row i
	// column j-1, row i+1 column j or row i-1 column j, unless you go outside the
	// bounds of the grid or you hit an obstacle.
	// This method is called on a certain cell at row i and column j, after the
	// method finishes executing, all the cells reachable from this cell will
	// contain the number 1 instead of zero.

	public void floodFill(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0)
			return;
		grid[i][j] = 1;
		floodFill(grid, i + 1, j);
		floodFill(grid, i - 1, j);
		floodFill(grid, i, j + 1);
		floodFill(grid, i, j - 1);
	}
}
