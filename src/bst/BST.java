package bst;

public class BST {
    BSTNode root;

    public void BST(){
        this.root = null;
    }

    public void inorderTreeWalk(BSTNode x){
        if(x != null){
            inorderTreeWalk(x.left);
            System.out.println(x.key);
            inorderTreeWalk(x.right);
        }
    }

    public BSTNode search(BSTNode x, int key){
        if(x == null || x.key == key)
            return x;
        if(key < x.key)
            return search(x.left, key);
        else
            return search(x.right, key);
    }

    public void insert(int key){

    }
}
