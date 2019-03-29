import dp.RodCutting;

public class Test {
    public static void main(String args[]){
        int n = 10;
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        RodCutting cut = new RodCutting();
        cut.compareRodCutMethods(p, n);
    }
}
