//Given an integer array nums where every element appears three times except 
//for one, which appears exactly once. Find the single element and return it. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,3,2]
//Output: 3
// Example 2: 
// Input: nums = [0,1,0,1,0,1,99]
//Output: 99
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each element in nums appears exactly three times except for one element 
//which appears once. 
// 
// Related Topics Array Bit Manipulation 👍 3065 👎 421


//leetcode submit region begin(Prohibit modification and deletion)
class Solution137 {
    public int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;
        int thrice = 0;

        for (int num : nums) {
            twos = twos | (ones & num);
            ones = ones ^ num;
            thrice = ones & twos;
            ones = ones & (~thrice);
            twos = twos & (~thrice);
        }

        return ones;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
