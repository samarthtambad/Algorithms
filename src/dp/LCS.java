package dp;

/*
    To implement an algorithm to find the longest common sub-sequence of two strings (as a measure of similarity between two strings).
    It has many practical applications, one of them being comparing two DNA sequences comprising of {A, C, G, T} and judging similarity.

    Input: String s1, String s2
    Output: Return length of LCS and also print the longest common sub-sequence of the two input strings.

 */

public class LCS {

    public final class Solution{
        String s1;
        String s2;
        int[][] c;
        char[][] b;
        int m;
        int n;

        public Solution(String s1, String s2, int[][] c, char[][] b){
            this.s1 = s1;
            this.m = s1.length();
            this.s2 = s2;
            this.n = s2.length();
            this.c = c;
            this.b = b;
        }

        public void printLCS(){
            System.out.println("Input 1: " + s1);
            System.out.println("Input 2: " + s2);
            System.out.print("Output: ");
            printLCSAux(m, n);
        }

        private void printLCSAux(int i, int j){
            if (i == 0 || j == 0)
                return;
            if(b[i][j] == 'd'){
                printLCSAux(i - 1, j - 1);
                System.out.print(s1.charAt(i - 1));
            } else if(b[i][j] == 'u'){
                printLCSAux(i - 1, j);
            } else {
                printLCSAux(i, j - 1);
            }
        }

        public String getS1() {
            return s1;
        }

        public String getS2() {
            return s2;
        }
    }

    public Solution findLCS(String s1, String s2){
        int m = s1.length();    //rows => s1
        int n = s2.length();    //columns => s2
        int[][] c = new int[m+1][n+1];
        char [][] b = new char[m+1][n+1];
        for(int i = 1; i <= m; i++){
            c[i][0] = 0;
            b[i][0] = ' ';
        }
        for(int i = 0; i <= n; i++){
            c[0][i] = 0;
            b[0][i] = ' ';
        }
        for(int i = 1; i <= m; i++){    // rows
            for(int j = 1; j <= n; j++){    // columns
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 'd';  //left-up diagonal direction
                } else if(c[i - 1][j] > c[i][j - 1]){
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 'u';  //up direction
                } else{
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 'l';  //left direction
                }
            }
        }
        return new Solution(s1, s2, c, b);
    }

}
