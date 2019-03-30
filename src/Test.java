import dp.LCS;

public class Test {
    public static void main(String args[]){
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        LCS lcs = new LCS();
        lcs.findLCS(s1, s2).printLCS();
    }
}
