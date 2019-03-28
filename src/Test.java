import dp.RodCutting;

public class Test {
    public static void main(String args[]){
        RodCutting cut = new RodCutting();
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int maxPrice = cut.cutRodNaive(p, 10);
        System.out.println(maxPrice);
    }
}
