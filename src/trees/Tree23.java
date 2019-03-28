package trees;

import javax.xml.soap.Node;

public class Tree23 {

    NodeTree23 root;

    public Tree23(){
        this.root = null;
    }

    public NodeTree23 getRoot(){
        return this.root;
    }

    public NodeTree23 search(NodeTree23 x, int key){
        if (x == null) return null;
        else if (x.left == null && x.mid == null && x.right == null){   //x is a leaf node
            if (x.max == key) return x;
            else return null;
        }
        else {
            if (key <= x.left.max) return search(x.left, key);
            else if (key <= x.mid.max) return search(x.mid, key);
            else return search(x.right, key);
        }
    }

    public void split(NodeTree23 y){
        NodeTree23 z = y.p;
        if (z == null){     //y is a root element

        } else {

        }
    }

}
