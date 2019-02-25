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
        System.out.println("pivot: " + A[pivot]);
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
        System.out.println(java.util.Arrays.toString(java.util.Arrays.copyOfRange(A, p, r+1)));
        return i;
    }

    public void sort(int[] A, int p, int r){
        if(p < r){
            int q = partition(A, p, r, false);
            sort(A, p, q-1);
            sort(A, q+1, r);
        }
    }

}
