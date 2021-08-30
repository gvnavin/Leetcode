//Given a signed 32-bit integer x, return x with its digits reversed. If 
//reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed 
//or unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics Math 👍 5483 👎 8203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution7 {
    public int reverse(int x) {

        if (!(x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE)) {
            return 0;
        }

        int ori = x;
        x = Math.abs(x);
        long ret = 0;
        while (x > 0) {
//            String s = "";
//            s = s + x + " ";
            ret = ret * 10 + (x % 10);
//            s = s + (x % 10) + " ";
            x = x / 10;
//            s = s + x + " ";
//            s = s + ret + " ";
//            System.out.println(s);
        }

        if (!(ret >= Integer.MIN_VALUE && ret <= Integer.MAX_VALUE)) {
            return 0;
        }

        if (ori < 0) {
            return (int) (ret * -1);
        }
        return (int) ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
