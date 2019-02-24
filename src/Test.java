
public class Test {

    public static void main(String args[]){

        int[] A = {5, 4, 7, 8, 3, 2, 9, 1};
        System.out.println(java.util.Arrays.toString(A));
        PriorityQueue pq = new PriorityQueue(A);
        System.out.println(java.util.Arrays.toString(A));
        System.out.println(pq.heapMaximum(A));
        pq.heapExtractMax(A);
        System.out.println(java.util.Arrays.toString(A));
        pq.maxHeapInsert(A, 15);
        System.out.println(java.util.Arrays.toString(A));
    }

}
