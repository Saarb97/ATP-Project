package test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;
import java.util.ArrayList;

public class RunSearchOnMaze {
    static boolean x = true;

    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
        while(x) {
            Maze maze = mg.generate(1000, 1000);
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            long startTime = System.currentTimeMillis();
            solveProblem(searchableMaze, new BreadthFirstSearch()); //BFS
            long finishTime = System.currentTimeMillis();
            System.out.print("Time: ");
            System.out.println(finishTime - startTime);
            /*
            startTime = System.currentTimeMillis();
            solveProblem(searchableMaze, new DepthFirstSearch()); //DFS
            finishTime = System.currentTimeMillis();
            System.out.print("Time: ");
            System.out.println(finishTime - startTime);
            */
            startTime = System.currentTimeMillis();
            solveProblem(searchableMaze, new BestFirstSearch()); //Best
            finishTime = System.currentTimeMillis();
            System.out.print("Time: ");
            System.out.println(finishTime - startTime);

            x = false;
        }


    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm
            searcher) {
//Solve a searching problem with a searcher
        SearchableMaze SM = (SearchableMaze)domain;
        Solution solution = searcher.solve(domain);
        if (solution == null) {
            SM.getMaze().print();
            System.out.println("------------------------------------------");
            x = false;
        }
        else
            System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
//Printing Solution Path
/*
                System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }*/
    }
}
