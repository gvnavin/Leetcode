//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 12890 👎 774


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {
        int sl = s.length();
        int[][] dp = new int[sl][sl];

        // Fill each row with 1.0
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxl = -1;
        int si = 0;

        for (int l = 1; l <= sl; l++) {
            int lind = Integer.MAX_VALUE;
            //println("l = " + l);
            for (int cx = 0; cx + l <= sl; cx++) {
                int cy = cx + l - 1;
                int px = cx + 1;
                int py = cy - 1;
                //println("cx = " + cx + " cy = " + cy + ", px = " + px + " py = " + py);
                //println("s.charAt(cx) = " + s.charAt(cx) + "  s.charAt(cy) = " + s.charAt(cy));
                if (s.charAt(cx) == s.charAt(cy)) {
                    //println("if (s.charAt(cx) == s.charAt(cy)) {");
                    if (px >= 0 && py >= 0 && px < sl && py < sl && px < py) {
                        //println("if (px >= 0 && py >= 0 && px < sl && py < sl && px < py) {");
                        if (dp[px][py] != -1) {
                            //println("if (dp[px][py] != -1) {");
                            dp[cx][cy] = 1;
                            lind = Math.min(lind, cx);
                        }
                    } else {
                        //println("} else {");
                        dp[cx][cy] = 1;
                        lind = Math.min(lind, cx);
                    }
                }
            }
            if (lind != Integer.MAX_VALUE) {
                si = lind;
                maxl = l;
            }
        }

        //println("si = " + si);
        //println("maxl = " + maxl);
        String substring = s.substring(si, si + maxl);
        println("substring = " + substring);
        return substring;
    }

    static boolean print = false;

    void print2dArray(int[][] dp) {
        if (print) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    print(dp[i][j] + " ");
                }
                println();
            }
        }
    }

    void println() {
        if (print) {
            System.out.println();
        }
    }

    void println(String s) {
        if (print) {
            System.out.println(s);
        }
    }

    void print(String s) {
        if (print) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {
        new Solution5().longestPalindrome("cc");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
