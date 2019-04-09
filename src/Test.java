import dp.MartixChainMultiplication;

import java.util.Arrays;

public class Test {
    public static void main(String args[]){
        MartixChainMultiplication matmul = new MartixChainMultiplication();
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] s = matmul.computeMatrixChainOrder(p);
        for(int i = 0; i < s.length; i++)
            System.out.println(java.util.Arrays.toString(s[i]));
//        matmul.printOptimalOrder(s, 0, (p.length - 1) - 1);
    }
}
