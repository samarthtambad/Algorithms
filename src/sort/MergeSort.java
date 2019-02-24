package sort;

public class MergeSort {

    int A[] = {0, 2, 3, 5, 8, 1, 4, 6, 7, 9};
    int p = 0;
    int r = A.length;
    int q = (r-p)/2;

    int[] merge(int A[], int p, int q, int r){
        int result[] = new int[A.length];
        int i = 0, j = q, k = 0;
        while(i < q && j < r){
            if(A[i]<=A[j]){
                result[k] = A[i];
                i++;
                k++;
            }
            else{
                result[k] = A[j];
                j++;
                k++;
            }
        }
        if(i >= q){
            while(j < r){
                result[k] = A[j];
                j++;
                k++;
            }

        } else if(j >= r){
            while(i < q){
                result[k] = A[i];
                i++;
                k++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        MergeSort sort = new MergeSort();
        int result[] = sort.merge(sort.A, sort.p, sort.q, sort.r);
        System.out.println("Result: \n");
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i]);
    }

}
