package algorithms.maze3D;

public interface IMaze3DGenerator {

    public Maze3D generate(int depth, int rows, int columns);
    public long measureAlgorithmTimeMillis(int depth, int rows, int columns);
}
