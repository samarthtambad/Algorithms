package sort;
import java.util.Random;

public class QuickSort {

    private int partition(int[] A, int p, int r, boolean randomized){
        if(randomized){
            Random rand = new Random();
            int randidx = p + rand.nextInt(r - p + 1);
            int temp = A[r];
            A[r] = A[randidx];
            A[randidx] = temp;
        }
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

    public void sort(int[] A, int p, int r, boolean randomized){
        if(p < r){
            int q = partition(A, p, r, randomized);
            sort(A, p, q-1, randomized);
            sort(A, q+1, r, randomized);
        }
    }

}
