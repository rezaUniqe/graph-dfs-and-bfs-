import java.util.ArrayList;

public class Node {
    public int getId() {
        return id;
    }

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<>();
    }

    public void addChild(Node n) {
        this.children.add(n);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    private int id;
    private int x;
    private int y;
    private ArrayList<Node> children;


}
