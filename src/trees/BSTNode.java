package trees;

public class BSTNode {
    int key;
    BSTNode left;
    BSTNode right;
    BSTNode p;

    public BSTNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.p = null;
    }

    public int getKey(){
        return key;
    }

}
