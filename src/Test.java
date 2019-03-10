import bst.*;

public class Test {
    public static void main(String args[]){
        BST tree = new BST();
        tree.insert(new BSTNode(1));
        tree.insert(new BSTNode(2));
        tree.insert(new BSTNode(3));
        tree.insert(new BSTNode(4));
        tree.insert(new BSTNode(5));
        tree.inorderTreeWalk(tree.getRoot());
        BSTNode b = tree.minimum(tree.getRoot());
        System.out.println(b.getKey());
        BSTNode c = tree.maximum(tree.getRoot());
        System.out.println(c.getKey());
        tree.delete(b);
        tree.inorderTreeWalk(tree.getRoot());
        tree.delete(c);
        tree.inorderTreeWalk(tree.getRoot());
    }
}
