//Given a string s, determine if it is a palindrome, considering only 
//alphanumeric characters and ignoring cases. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 👍 2394 👎 4276


import java.util.Locale;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution125 {

    public boolean isPalindrome(String s) {

        int beg = 0;
        int end = s.length()-1;

        while (end >= 0 && beg <= end) {

//            System.out.println("1 beg : " + beg + ", end : " + end + ", " + s.charAt(beg) + " " + s.charAt(end));

            while(beg < s.length() && !isAlphaNumeric(s.charAt(beg))) {
//                System.out.println("beg : " + beg + ", " + s.charAt(beg));
                beg++;
            }

            while (end >= 0 && !isAlphaNumeric(s.charAt(end))) {
//                System.out.println("end : " + end + ", " + s.charAt(end));
                end--;
            }

//            System.out.println("2 beg : " + beg + ", end : " + end + ", " + s.charAt(beg) + " " + s.charAt(end));
            char bc = beg < s.length() ? s.charAt(beg) : ' ';
            char ec = end >= 0 ? s.charAt(end) : ' ';
            char cbc = getChar(bc);
            char cec = getChar(ec);
//            System.out.println("3 cbc : " + cbc + ", cec : " + cec);

            if (cbc != cec) {
                return false;
            }

            beg++;
            end--;
        }

        return true;
    }

    boolean isAlphaNumeric(char a) {
        return ((a >='a' && a <= 'z') || (a >='A' && a <= 'Z') || (a >= '0' && a <= '9'));
    }

    char getChar(char a) {
        if (a >='a' && a <= 'z') {
            return (char) (a - 32);
        }
        return a;
    }

    public static void main(String[] args) {
        new Solution125().isPalindrome("");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
