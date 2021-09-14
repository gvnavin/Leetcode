//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; No extra white spaces, 
//square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any 
//digits and that digits are only for those repeat numbers, k. For example, there 
//won't be input like 3a or 2[4]. 
//
// 
// Example 1: 
// Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// Example 2: 
// Input: s = "3[a2[c]]"
//Output: "accaccacc"
// Example 3: 
// Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// Example 4: 
// Input: s = "abc3[cd]xyz"
//Output: "abccdcdcdxyz"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
// Related Topics String Stack Recursion 👍 5889 👎 262


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution394 {

    class PatternAndEndIndex {
        String pattern;
        int endIndex;

        public PatternAndEndIndex(String pattern, int endIndex) {
            this.pattern = pattern;
            this.endIndex = endIndex;
        }
    }

    class Unit {
        int cnt;
        String pattern;
        String decoded;

        public Unit(String cnt, String pattern) {
            this.cnt = Integer.parseInt(cnt);
            this.pattern = pattern;
            this.decoded = pattern.repeat(this.cnt);
        }

        public Unit(int cnt, char pattern) {
            this.cnt = cnt;
            this.pattern = String.valueOf(pattern);
            this.decoded = this.pattern.repeat(this.cnt);
        }

        @Override
        public String toString() {
            return "Unit{" +
                    "cnt=" + cnt +
                    ", pattern='" + pattern + '\'' +
                    ", decoded='" + decoded + '\'' +
                    '}';
        }
    }

    public String decodeString(String s) {

        do {
            List<Unit> units = new ArrayList<>();
            buildUnits(s, units);
//            System.out.println("units = " + units);
            StringBuilder sb = new StringBuilder();
            for (Unit unit : units) {
                sb.append(unit.decoded);
            }
            s = sb.toString();
//            System.out.println("s = " + s);
        } while (s.indexOf('[') != -1);
//        System.out.println("ret = " + s);
        return s;
    }

    private void buildUnits(String s, List<Unit> units) {
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (isNumeric(charAt)) {
                i = getUnit(s, units, i);
            } else {
                Unit unit = new Unit(1, charAt);
                units.add(unit);
            }
        }
    }

    private int getUnit(String s, List<Unit> units, int i) {
        int ind = s.indexOf('[', i);
        String cnt = s.substring(i, ind);
        PatternAndEndIndex pi = extractPattern(s, ind);
        Unit unit = new Unit(cnt, pi.pattern);
        units.add(unit);
        i = pi.endIndex;
        return i;
    }


    private PatternAndEndIndex extractPattern(String s, int ind) {
        ArrayList<Character> stk = new ArrayList<>();
        for (int j = ind; j < s.length(); j++) {
            if (s.charAt(j) == '[') {
                stk.add('[');
            } else if (s.charAt(j) == ']') {
                stk.remove(stk.size()-1);
                if(stk.isEmpty()) {
                    return new PatternAndEndIndex(s.substring(ind + 1, j), j);
                }
            }
        }
        return new PatternAndEndIndex("", -1);
    }

    private boolean isNumeric(char charAt) {
        return charAt >= '0' && charAt <= '9';
    }

//    public static void main(String[] args) {
//        new Solution394().decodeString("10[a]2[bc]");
//        new Solution394().decodeString("3[a]2[bc]");
//        new Solution394().decodeString("3[a2[c]]");
//        new Solution394().decodeString("2[abc]3[cd]ef");
//        new Solution394().decodeString("abc3[cd]xyz");
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
