package Sorting;

public class BubbleSort {

    int A[] = {4, 5, 2, 12, 24, 6, 9, 13, 15, 3};

    int[] sort(int A[]){
        for(int i = 0; i < A.length - 1; i++){
            for(int j = 0; j < A.length - i - 1; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
            for(int k = 0; k < A.length; k++)
                System.out.print(A[k] + " ");
            System.out.print("\n");
        }
        return A;
    }

    public static void main(String args[]){
        BubbleSort bs = new BubbleSort();
        int result[] = bs.sort(bs.A);
        System.out.println("Result: ");
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

}
