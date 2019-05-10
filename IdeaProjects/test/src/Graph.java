import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private HashMap<Integer, Node> graph;//this is our graph that holds our node you can use node id to access each node of graph.
    private static ArrayList<String> input;//this array used to hold our input that has been read from the file.

    public Graph(ArrayList<String> input) {
        this.input = input;
        this.graph = graphGenerator();
    }

    //this function create a node based on our arraylist that created from our input to create node object.
    public static HashMap<Integer, Node> graphGenerator() {
        HashMap<Integer, Node> data = new HashMap<>();
        for (String s : input) {
            String temp[] = s.split(",");
            Node n = new Node(Integer.parseInt(temp[0]));
            n.setX(Integer.parseInt(temp[1]));
            n.setY(Integer.parseInt(temp[2]));
            data.put(Integer.parseInt(temp[0]), n);
        }
        addChildren(data);
        return data;
    }


    //this fuction add children to each node simply define each node path with other node.
    private static void addChildren(HashMap<Integer, Node> data) {
        for (String s : input) {
            String temp[] = s.split(",");
            for (int i = 3; i < temp.length; i++) {
                data.get(Integer.parseInt(temp[0])).addChild(data.get(Integer.parseInt(temp[i])));
            }
        }
    }


    public boolean hasDfsPath(int source, int destination) {
        Node s = graph.get(source);
        Node d = graph.get(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasDfsPath(s, d, visited);

    }

    private boolean hasDfsPath(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.getId())) {
            return false;
        }
        visited.add(source.getId());
        System.out.print(source.getId());
        if (source.getId() == destination.getId()) {

            return true;
        }

        for (Node child : source.getChildren()) {
            if (hasDfsPath(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBfsPath(int source, int destination) {
        return hasBfsPath(graph.get(source), graph.get(destination));
    }

    private boolean hasBfsPath(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node.getId() == destination.getId()) {
                return true;
            }
            if (visited.contains(node.getId())) {
                continue;
            }
            visited.add(node.getId());
            System.out.print(node.getId());
            for (Node child : node.getChildren()) {
                nextToVisit.add(child);
            }
        }
        return false;

    }

}
