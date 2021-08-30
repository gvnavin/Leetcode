//Given an input string s and a pattern p, implement regular expression 
//matching with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
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
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, 
//it matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a 
//previous valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 👍 6488 👎 922


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {

    static class Unit {
        public char c;  //alphabets including '.'
        public char exp = ' '; //it will only have *

        public Unit(char c) {
            this.c = c;
        }

        public Unit(char c, char exp) {
            this.c = c;
            this.exp = exp;
        }

        @Override
        public String toString() {
            return c + "" + exp;
        }

    }

    public boolean isMatch(String s, String p) {
        List<Unit> pt = parsePattern(p);

        boolean recur = recur(s, pt, 0, 0);
//        System.out.println(recur);

        return recur;
    }

    boolean recur(String s, List<Unit> pt, int si, int pi) {
//        //System.out.println("si = " + si + ", pi = " + pi);
        if (si == s.length() && pi == pt.size()) {
            return true;
        } else if (si > s.length() && pi < pt.size()) {
            return false;
        } else if (pi >= pt.size()) {
            return false;
        }

        char inp = ' ';
        if (si < s.length()) {
            inp = s.charAt(si);
        }
        Unit unit = pt.get(pi);
        char c = unit.c;
        char exp = unit.exp;

        if ((c == inp || c == '.') && exp != '*') {
            return recur(s, pt, si + 1, pi + 1);
        } else if ((c == inp || c == '.') && exp == '*') {
            boolean recur = recur(s, pt, si, pi + 1);
            if (recur) {
                return true;
            }
            return recur(s, pt, si + 1, pi);
        } else if (c != inp && exp == '*') {
            return recur(s, pt, si, pi + 1);
        }
        return false;
    }

    private List<Unit> parsePattern(String p) {
        List<Unit> pt = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            char cn = ' ';
            if (i + 1 < p.length()) {
                cn = p.charAt(i + 1);
            }
            if (cn == '*') {
                pt.add(new Unit(c, cn));
                i++;
            } else if (c == '.') {
                pt.add(new Unit(c));
            } else {
                pt.add(new Unit(c));
            }
        }
//        printList(pt);
        return pt;
    }

    static boolean print = true;

    void printList(List<?> list) {
        if (print) {
            for (Object o : list) {
                System.out.print(o + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution10().isMatch("a", "a*a");
        new Solution10().isMatch("ab", ".*c");
        new Solution10().isMatch("a", "ab*");
        new Solution10().isMatch("aa", "a");
        new Solution10().isMatch("aa", "a*");
        new Solution10().isMatch("ab", ".*");
        new Solution10().isMatch("aab", "c*a*b");
        new Solution10().isMatch("mississippi", "mis*is*p*.");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
