package bst;

public class BST {
    BSTNode root;

    public BST(){
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

    public void insert(BSTNode z){
        BSTNode y = null;
        BSTNode x = this.root;
        while (x != null){
            y = x;
            if (z.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.p = y;
        if (y == null)
            this.root = z;
        else if (z.key < y.key)
            y.left = z;
        else y.right = z;
    }

    private void transplant(BSTNode u, BSTNode v){
        if (u.p == null)
            this.root = v;
        else if (u == u.p.left)
            u.p.left = v;
        else u.p.right = v;
        if (v != null)
            v.p = u.p;
    }

    public void delete(BSTNode z){
        BSTNode y = null;
        if (z.left == null)
            transplant(z, z.right);
        else if (z.right == null)
            transplant(z, z.left);
        else {
            y = minimum(z.right);   //successor in the sub-tree
            if (y.p != z) {  //if successor is not direct child
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

}
