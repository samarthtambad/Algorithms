package dp;

public class RodCutting {

    /* Naive implementation - Repeatedly computes sub-problems over and over again.
    It has a time complexity of O(2^n) */
    public int cutRodNaive(int[] p, int n){
        if(n == 0) return 0;
        int maxPrice = - 1000;
        for(int i = 1; i <= n; i++){
            maxPrice = Math.max(maxPrice, p[i]+cutRodNaive(p, (n-i)));
        }
        return maxPrice;
    }

    /* It implements the same top-down approach as before but uses memoization to remember the solutions to
    the sub-problems. Therefore, it computes each sub-problem only once. It has time-complexity of O(n^2) */
    public int cutRodTopDown(int[] p, int n){
        int[] r = new int[n];
        for(int i = 0; i < n; i++)
            r[i] = -1000;
        return cutRodMemoized(p, n, r);
    }

    private int cutRodMemoized(int[] p, int n, int[] r){
        if(r[n] >= 0)
            return r[n];
        if(n == 0)
            return 0;
        int maxPrice = - 1000;
        for(int i = 1; i <= n; i++){
            maxPrice = Math.max(maxPrice, p[i]+ cutRodMemoized(p, (n-i), r));
        }
        r[n] = maxPrice;
        return r[n];
    }



}
