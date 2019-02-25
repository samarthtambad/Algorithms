import sort.QuickSort;

public class Test {
    public static void main(String args[]){
        int[] A = {5, 6, 10, 3, 4, 2, 9, 1, 8, 7};
        System.out.println(java.util.Arrays.toString(A));
        QuickSort sort = new QuickSort();
        sort.sort(A, 0, A.length - 1);
        System.out.println(java.util.Arrays.toString(A));
    }
}
