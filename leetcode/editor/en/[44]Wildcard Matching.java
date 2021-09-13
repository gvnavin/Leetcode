//Given an input string (s) and a pattern (p), implement wildcard pattern 
//matching with support for '?' and '*' where: 
//
// 
// '?' Matches any single character. 
// '*' Matches any sequence of characters (including the empty sequence). 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not 
//match 'b'.
// 
//
// Example 4: 
//
// 
//Input: s = "adceb", p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' 
//matches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input: s = "acdcb", p = "a*c?b"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length, p.length <= 2000 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '?' or '*'. 
// 
// Related Topics String Dynamic Programming Greedy Recursion 👍 3647 👎 162


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {
    public boolean isMatch(String s, String p) {
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
