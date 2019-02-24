public class PriorityQueue {

    private int heapsize;

    public PriorityQueue(int[] A){
        heapsize = 0;
    }

    int heapMaximum(int[] A){
        return A[0];
    }

    int heapExtractMax(int[] A) throws Exception {
        if(heapsize < 1)
            throw new Exception("heap underflow");
        int max = A[0];
        A[0] = A[heapsize - 1];
        heapsize = heapsize - 1;

        return 0;
    }

    void heapIncreaseKey(int[] A, int i, int key){

    }

    void maxHeapInsert(int[] A, int key){

    }

}
