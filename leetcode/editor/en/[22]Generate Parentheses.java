//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 👍 9445 👎 376


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        recur("", n*2, 0, ret);
        return ret;
    }

    private void recur(String s, int len, int flag, List<String> ret) {

        if (s.length() == len && flag == 0) {
            ret.add(s);
            return;
        } else if (s.length() >= len && flag != 0) {
            return;
        }

        if (flag == 0) {
            recur(s + "(", len , flag + 1, ret);
        } else if (flag > 0) {
            recur(s + "(", len , flag + 1, ret);
            recur(s + ")", len , flag - 1, ret);
        } else if (flag < 0) {
            recur(s + ")", len, flag - 1, ret);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
