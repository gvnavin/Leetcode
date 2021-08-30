//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 8707 👎 345


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {

    static final HashMap<Character, Integer> hm = new HashMap<>();
    static final HashMap<Character, Character> cm = new HashMap<>();

    static {
        cm.put(')', '(');
        cm.put(']', '[');
        cm.put('}', '{');

        hm.put('(', 1);
        hm.put('[', 1);
        hm.put('{', 1);

        hm.put(')', -1);
        hm.put(']', -1);
        hm.put('}', -1);
    }

    public boolean isValid(String s) {
        return usingStack(s);
    }

    private boolean usingStack(String s) {
        List<Character> st = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = hm.get(c).intValue();
            if (v > 0) {
                st.add(c);
            } else {
                if (st.size() > 0) {
                    char closingBracket = cm.get(c);
                    char openingBracketInStack = st.get(st.size() - 1);
                    if (openingBracketInStack == closingBracket) {
                        st.remove(st.size() - 1);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
