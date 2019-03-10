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

    public BSTNode minimum(BSTNode x){
        while (x.left != null){
            x = x.left;
        }
        return x;
    }

    public BSTNode maximum(BSTNode x){
        while (x.right != null){
            x = x.right;
        }
        return x;
    }

    public BSTNode predecessor(BSTNode x){
        if (x.left != null)
            return maximum(x.left);
        BSTNode y = x.p;
        while (y != null && x == y.left){
            x = y;
            y = y.p;
        }
        return y;
    }

    public BSTNode successor(BSTNode x){
        if (x.right != null)
            return minimum(x.right);
        BSTNode y = x.p;
        while (y != null && x == y.right){
            x = y;
            y = y.p;
        }
        return y;
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
