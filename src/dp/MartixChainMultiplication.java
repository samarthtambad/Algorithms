package dp;

/*
    This is an algorithm for computing the best way to multiply a group of matrices A1, A2,...,An by finding an optimal grouping of the
    matrices such that the multiplication requires the least number of scalar multiplications. Any algorithm can be used
    to implement the matrix multiplication, however, the point of this algorithm is to minimize the time required to perform
    the multiplication by optimal grouping.
    ex. Let  A1, A2, A3 be 10 x 100, 100 x 50, 50 x 80 dimensional matrices respectively. Then, the number of scalar
    multiplications for:
    (A1 A2) A3 = (10 x 100 x 50) + (10 x 50 x 80) = 90,000
    A1 (A2 A3) = (10 x 100 x 80) + (100 x 50 x 80) = 480,000
    Therefore, the second grouping takes 5 times more scalar multiplications then the first one.

    Input: p - a list of sizes of each matrix in the chain of n matrices. It will have length n+1.
    Output: the optimal grouping for efficient multiplication.

 */

public class MartixChainMultiplication {

    public void printOptimalOrder(int[][] s, int i, int j){
        if(i == j) System.out.print("A" + i);
        else {
            System.out.print("(");
            printOptimalOrder(s, i, s[i][j]);
            printOptimalOrder(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }

    public int[][] computeMatrixChainOrder(int[] p){
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][]s = new int[n][n];

        for(int l = 1; l < n; l++){
            for(int i = 0; i < n - l + 1; i++){
                int j = i + l - 1;
                m[i][j] = 65535;
                for(int k = i; k < j-1; k++){
                    int q = m[i][k] + m[k+1][j] + (p[i] * p[j + 1] * p[k + 1]);
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return s;
    }

}
