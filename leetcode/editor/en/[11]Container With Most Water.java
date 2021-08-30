//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
//of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the 
//x-axis forms a container, such that the container contains the most water. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: height = [4,3,2,1,4]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: height = [1,2,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics Array Two Pointers Greedy 👍 11300 👎 770


//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    public int maxArea(int[] h) {
        int beg = 0;
        int end = h.length-1;

        int max = 0;
        while (beg < end) {
            int loMax = Math.min(h[beg], h[end]) * (end - beg);
            max = Math.max(loMax, max);
            if (h[beg] < h[end]) {
                beg ++;
            } else {
                end--;
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
