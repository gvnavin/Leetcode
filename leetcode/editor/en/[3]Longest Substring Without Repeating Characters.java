//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 16798 👎 807


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> locVisited = new HashSet<>();

        int beg = 0;
        int end = 0;
        int max = 0;
        int l = s.length();

        while (beg <= end && beg < l && end < l) {
            char c = s.charAt(end);

            int localMax = end - beg;
            max = Math.max(localMax, max);

            //shrink
            while (locVisited.contains(c)) {
                locVisited.remove(s.charAt(beg));
                beg++;
            }
            locVisited.add(c);
            end++;
        }

        int localMax = end - beg;
        max = Math.max(localMax, max);

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
