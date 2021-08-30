//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 12553 👎 1219


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] n) {
        List<List<Integer>> ll = new ArrayList<>();

        HashSet<String> hs = new HashSet<>();

        Arrays.sort(n);
        for (int i = 0; i < n.length; i++) {
            int j = i + 1;
            int k = n.length - 1;
            while (j < k) {
                int v = n[i] + n[j] + n[k];
                if (v == 0) {
                    String key = "" + n[i] + "" + n[j] + "" + n[k];
                    if(!hs.contains(key)) {
                    ll.add(Arrays.asList(n[i], n[j], n[k]));
                        hs.add(key);
                    }
//                    do {
                        j++;
//                    } while (j + 1 < n.length && n[j] == n[j + 1]);

//                    do {
                        k--;
//                    } while (k - 1 >= 0 && n[k] == n[k - 1]);

                } else if (v > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
