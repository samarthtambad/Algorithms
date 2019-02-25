package sort;

public class QuickSort {

    private int partition(int[] A, int p, int r){
        int pivot = r;
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(A[j] <= A[pivot]){
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        i = i + 1;
        int temp = A[i];
        A[i] = A[pivot];
        A[pivot] = temp;
        return i;
    }

    public void sort(int[] A, int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            sort(A, p, q-1);
            sort(A, q+1, r);
        }
    }

}
