import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static ArrayList<String> input;




    public static void main(String[] args) throws IOException {
        Input in = new Input();
        input = in.getInput();
        Graph g=new Graph(input);
        System.out.println("dfs:");
        g.hasDfsPath(1,4);
        System.out.println(" ");
        System.out.println("bfs:");
        g.hasBfsPath(1,4);


    }


}
