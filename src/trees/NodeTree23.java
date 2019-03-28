package trees;

public class NodeTree23 {
    int max;
    NodeTree23 left;
    NodeTree23 mid;
    NodeTree23 right;
    NodeTree23 p;

    public NodeTree23(int key){
        this.max = key;
        this.left = null;
        this.mid = null;
        this.right = null;
        this.p = null;
    }

    public int getMax(){
        return this.max;
    }

}
