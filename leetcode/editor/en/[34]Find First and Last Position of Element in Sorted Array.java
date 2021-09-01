//Given an array of integers nums sorted in ascending order, find the starting 
//and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 6969 👎 230


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int beg, end;

        beg = 0;
        end = nums.length - 1;

        int low = -1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            //System.out.println("1 beg = " + beg + " end = " + end + " mid = " + mid + " nums[mid] = " + nums[mid] + " target = " + target);
            if (nums[mid] == target && (mid == 0 || (mid - 1 >= 0 && nums[mid - 1] != target))) {
                low = mid;
                break;
            } else if (nums[mid] == target && (mid == 0 || mid - 1 >= 0 && nums[mid - 1] == target)) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        if (low == -1) {
            return new int[]{-1, -1};
        }

        beg = low;
        end = nums.length - 1;
        int high = -1;
        while (beg <= end) {
            int mid = beg + (end - beg + 1) / 2;
            //System.out.println("2 beg = " + beg + " end = " + end + " mid = " + mid + " nums[mid] = " + nums[mid] + " target = " + target);
            if (nums[mid] == target && (mid == nums.length - 1 || mid + 1 < nums.length && nums[mid + 1] != target)) {
                high = mid;
                break;
            } else if (nums[mid] == target && (mid == nums.length - 1 || mid + 1 < nums.length && nums[mid + 1] == target)) {
                beg = mid + 1;
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return new int[]{low, high};
    }

    public static void main(String[] args) {
//        int[] ints = new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        for (int i: ints) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        ints = new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
//        for (int i: ints) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int[] ints = new Solution34().searchRange(new int[]{1, 4}, 4);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
