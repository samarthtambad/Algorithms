package dp;

public class RodCutting {

    public int cutRodNaive(int[] p, int n){
        if(n == 0) return 0;
        int maxPrice = - 1000;
        for(int i = 1; i <= n; i++){
            maxPrice = Math.max(maxPrice, p[i]+cutRodNaive(p, (n-i)));
        }
        return maxPrice;
    }

}
