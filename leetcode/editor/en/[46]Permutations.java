//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 👍 7388 👎 146


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> inputList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> singleList = new ArrayList<>();
        recur(inputList, nums.length, 0, singleList, ret);
        return ret;
    }

    public void recur(List<Integer> il, int sz, int pos, List<Integer> sl, List<List<Integer>> ret) {
        //System.out.println(il+ " "+ sz + " " + sl + " " + ret);
        if (sl.size() == sz) {
            ret.add(sl);
            return;
        } else if (sl.size() >= sz) {
            return;
        } else if (il.size() == 0) {
            return;
        }

        for(int i=0; i<il.size(); i++) {
            List<Integer> tl = new ArrayList<>();

            tl.addAll(sl);
            tl.add(il.get(i));
            //System.out.println("tl = " + tl);
            //System.out.println("sl = " + sl);

            List<Integer> til = new ArrayList<>();
            til.addAll(il);
            til.remove(i);

            //System.out.println("--------------------");
            recur(til, sz, pos+1, tl, ret);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
