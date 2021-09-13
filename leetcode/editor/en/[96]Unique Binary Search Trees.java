//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 5513 👎 206


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public int numTrees(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return f(n);
    }

    private int f(int v) {

        if (memo.containsKey(v)) {
            return memo.get(v);
        }

        if (v == 0 || v == 1) {
            memo.put(v, 1);
            return 1;
        }

        int ret = 0;
        for (int i = 0; i < v; i++) {
            int val = f(i) * f(v-i-1);
            ret += val;
        }
        memo.put(v, ret);
        return ret;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
