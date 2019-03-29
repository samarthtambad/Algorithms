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

    /* This implements the same top-down approach as before but uses memoization to remember the solutions to
    the sub-problems. Therefore, it computes each sub-problem only once. It has time-complexity of O(n^2) */
    public int cutRodTopDown(int[] p, int n){
        int[] r = new int[n + 1];
        for(int i = 0; i <= n; i++)
            r[i] = -1000;
        return cutRodTopDownAux(p, n, r);
    }

    private int cutRodTopDownAux(int[] p, int n, int[] r){
        if(r[n] >= 0) return r[n];

        int maxPrice;
        if(n == 0) maxPrice = 0;
        else {
            maxPrice = -1000;
            for (int i = 1; i <= n; i++) {
                maxPrice = Math.max(maxPrice, p[i] + cutRodTopDownAux(p, (n - i), r));
            }
        }
        r[n] = maxPrice;
        return r[n];
    }

    /* This implements a bottom-up approach that solves all the dependent sub-problems first before trying to
    solve the current problem. It also doesn't compute the sub-problems more than once. Therefore, it has a time
    complexity of O(n^2). */
    public int cutRodBottomUp(int[] p, int n){
        int[] r = new int[n + 1];
        r[0] = 0;
        for(int j = 1; j <= n; j++){
            int maxPrice = - 1000;
            for(int i = 1; i <= j; i++){
                if(maxPrice < p[i]+r[j-i]){
                    maxPrice = p[i]+r[j-i];
                }
            }
            r[j] = maxPrice;
        }
        return r[n];
    }

    // Compare the different approaches for rod-cutting w.r.t. running time
    public void compareRodCutMethods(int[] p, int n){
        long startTime, endTime, totalTime;
        int maxPrice = 0;

        startTime = System.nanoTime();
        maxPrice = cutRodNaive(p, n);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Naive - price: " + maxPrice + ", time: " + totalTime);

        startTime = System.nanoTime();
        maxPrice = cutRodTopDown(p, n);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Top Down - price: " + maxPrice + ", time: " + totalTime);

        startTime = System.nanoTime();
        maxPrice = cutRodBottomUp(p, n);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Bottom Up - price: " + maxPrice + ", time: " + totalTime);
    }

}
