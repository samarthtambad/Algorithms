package sort;
import ds.Heap;

public class HeapSort {

    private Heap heap;

    public HeapSort(int[] A){
        heap = new Heap(A);
    }

    public void sort(int[] A){
        heap.buildMaxHeap(A);
        for(int i = A.length - 1; i > 0; i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heap.heapsize = heap.heapsize - 1;
            heap.maxHeapify(A, 0);
        }
    }
}
