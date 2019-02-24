package sort;

public class HeapSort {

    private int[] a;

    public HeapSort(int[] A){
        a = A;
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int left(int i){
        return (2 * i) + 1;
    }

    public int right(int i){
        return (2 * i) + 2;
    }

    public void maxHeapify(int[] A, int i){

    }

}
