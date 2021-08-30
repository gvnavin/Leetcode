//Given an array of integers nums and an integer target, return indices of the 
//two numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may 
//not use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n²) time 
//complexity? Related Topics Array Hash Table 👍 23806 👎 793


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] twoSum(int[] n, int target) {

        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            HashSet<Integer> indices = mp.getOrDefault(n[i], new HashSet<>());
            indices.add(i);
            mp.put(n[i], indices);
        }

        int fn = -1;
        int sn = -1;
        for (int i = 0; i < n.length; i++) {
            int diff = target - n[i];
            fn = i;
            boolean containsKey = mp.containsKey(diff);

            if (containsKey) {
                HashSet<Integer> indices = mp.get(diff);
                if (indices.contains(i)) {
                    Iterator<Integer> iterator = indices.iterator();
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
                        if (next != fn) {
                            sn = next;
                            return new int[]{fn, sn};
                        }
                    }
                } else {
                    sn = indices.iterator().next();
                    return new int[]{fn, sn};
                }

            }
        }

        return new int[]{fn, sn};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
