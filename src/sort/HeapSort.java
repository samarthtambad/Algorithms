package sort;

public class HeapSort {

    private int heapsize;

    public HeapSort(int[] A){
        heapsize = 0;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return (2 * i) + 1;
    }

    private int right(int i){
        return (2 * i) + 2;
    }

    private void maxHeapify(int[] A, int i){
        int l = left(i);
        int r = right(i);
        int largest = 0;

        if(l < heapsize && A[l] > A[i])
            largest = l;
        else
            largest = i;

        if(r < heapsize && A[r] > A[largest])
            largest = r;

        if(largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest);
        }
    }

    private void buildMaxHeap(int[] A){
        heapsize = A.length;
        for(int i = A.length/2; i >= 0; i--){
            maxHeapify(A, i);
        }
    }

    public void sort(int[] A){
        buildMaxHeap(A);
        for(int i = A.length - 1; i > 0; i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapsize = heapsize - 1;
            maxHeapify(A, 0);
        }
    }
}
