import sort.HeapSort;

public class Test {

    public static void main(String args[]){

        int[] A = {5, 4, 7, 8, 3, 2, 9, 1};
        HeapSort sort = new HeapSort(A);
        System.out.println(sort.left(1));
        System.out.println(sort.right(1));
    }

}
