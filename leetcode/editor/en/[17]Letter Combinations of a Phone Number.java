//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 7164 👎 565


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    static HashMap<Character, String> mp = new HashMap<>();
    static {
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        recur(digits, 0, "", ret);
        return ret;
    }

    public void recur(String digits, int p, String ps, List<String> ret) {
        if (p == digits.length()) {
            if (ps.length() > 0) {
                ret.add(ps);
            }
            return;
        }
        char c = digits.charAt(p);
        String s = mp.get(c);
        for (int i = 0; i < s.length(); i++) {
            recur(digits, p+1, ps + s.charAt(i), ret);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
