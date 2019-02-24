import ds.Heap;

public class PriorityQueue {

    private Heap heap;

    public PriorityQueue(int[] A){
        heap = new Heap(A);
    }

    int heapMaximum(int[] A){
        return A[0];
    }

    int heapExtractMax(int[] A){
        if(heap.heapsize < 1)
            System.out.println("heap underflow");
        int max = A[0];
        A[0] = A[heap.heapsize - 1];
        heap.heapsize = heap.heapsize - 1;
        heap.maxHeapify(A, 0);
        return max;
    }

    void heapIncreaseKey(int[] A, int i, int key){
        if(key < A[i])
            System.out.println("new key smaller than current key");
        A[i] = key;
        int p = heap.parent(i);
        while (i > 0 && A[p] < A[i]){
            int temp = A[i];
            A[i] = A[p];
            A[p] = temp;
            i = p;
            p = heap.parent(i);
        }
    }

    void maxHeapInsert(int[] A, int key){
        heap.heapsize = heap.heapsize + 1;
        A[heap.heapsize - 1] = (int) Float.NEGATIVE_INFINITY;
        heapIncreaseKey(A, heap.heapsize - 1, key);
    }

}
