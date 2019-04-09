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


}
