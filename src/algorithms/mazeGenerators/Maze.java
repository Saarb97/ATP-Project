package algorithms.mazeGenerators;

import javafx.geometry.Pos;
import java.util.concurrent.ThreadLocalRandom;


public class Maze {
    private Position start;
    private Position end;
    private int[][] maze;
    public Maze(Position start,Position end,int[][] maze) {
        // TODO ERROR HANDLING
        this.start = start;
        this.end = end;
        this.maze = maze;
    }

    public Maze(int rows, int columns) {
        // TODO ERROR HANDLING
        this.maze = new int[rows][columns];
        setRandomStartAndEndPos();
    }

    public void print() {
        for (int i = 0; i <= maze.length - 1; i++) {
            System.out.print("{ ");
            for (int j = 0; j <= maze[i].length-1; j++) {
                if (start.getRowIndex() == i & start.getColumnIndex() == j)
                    System.out.print("S ");
                else if (end.getRowIndex() == i & end.getColumnIndex() == j)
                    System.out.print("E ");

                else
                    System.out.print(maze[i][j] + " ");
            }
            System.out.println("}");
        }
    }

    public Position getStartPosition() {
        return new Position(start);
    }

    public Position getGoalPosition() {
        return new Position(end);
    }

    public Position RandomPositionOnEdge(int rows,int columns) {
        int row = ThreadLocalRandom.current().nextInt(0, rows);
        int column = ThreadLocalRandom.current().nextInt(0, columns);

        return null;
    }

    public void SetPos (int i, int j,int value)  {
        // TODO ERROR HANDLING
        maze[i][j] = value;
    }
    public void SetPos (Position pos,int value)  {
        // TODO ERROR HANDLING
        maze[pos.getRowIndex()][pos.getColumnIndex()] = value;
    }

    public void setRandomStartAndEndPos () {
        int rows =maze.length;
        int columns = maze[0].length;
        int startRow,startCol,endRow,endCol;
        startRow= ThreadLocalRandom.current().nextInt(0, rows); //deciding on a starting row
        if (startRow == 0 || startRow == rows-1) // if the starting row is 0 or the last row, the starting column can be
                                                // any column, else, the starting column is the left or right wall
            startCol = ThreadLocalRandom.current().nextInt(0, columns);
        else {
            startCol = ThreadLocalRandom.current().nextInt(0, 2); //left or right walls of the maze
            if (startCol == 1)
                startCol = columns-1; //changing to the right side wall.
        }
        while (true) {
            endRow = ThreadLocalRandom.current().nextInt(0, rows);
            if (Math.abs(endRow-startRow) > (columns/10)*5)  //searching for a end point which is at least
                break;                                       // 50% up\down the Maze from the start point (relative to maze size)
        }
        if (endRow == 0 || endRow == rows-1) // same as starting row and starting column positioning
            endCol = ThreadLocalRandom.current().nextInt(0, columns);
        else {                      // put the end position on the other side of the maze from the start position
            if (startCol == 0)
                endCol = columns-1;
            else
                endCol = 0;

        }
        this.start = new Position(startRow,startCol);
        this.end = new Position(endRow,endCol);
    }


}
