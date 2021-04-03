package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator {

    public EmptyMazeGenerator() {}


    @Override
    public Maze generate(int rows, int columns) {
        // TODO ERROR HANDLING
        return new Maze(rows,columns);
    }
}
