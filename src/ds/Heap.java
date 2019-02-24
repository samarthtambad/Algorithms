package ds;

public class Heap {

    public int heapsize;

    public Heap(int[] A){
        heapsize = 0;
        buildMaxHeap(A);
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

    public void buildMaxHeap(int[] A){
        heapsize = A.length;
        for(int i = A.length/2; i >= 0; i--){
            maxHeapify(A, i);
        }
    }

}
