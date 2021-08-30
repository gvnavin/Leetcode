//Given two sorted arrays nums1 and nums2 of size m and n respectively, return
//the median of the two sorted arrays.
//
// The overall run time complexity should be O(log (m+n)).
//
//
// Example 1:
//
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//
//
// Example 2:
//
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
// Example 3:
//
//
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
//
//
// Example 4:
//
//
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
//
//
// Example 5:
//
//
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
//
//
//
// Constraints:
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
// Related Topics Array Binary Search Divide and Conquer 👍 11945 👎 1658


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int fb = 0;
        int fe = nums1.length - 1;
        int sb = 0;
        int se = nums2.length - 1;

        while (true) {

            int sz1 = fe - fb + 1;
            int sz2 = se - sb + 1;

            System.out.println("fb = " + fb + " fe = " + fe + " sz1 = " + sz1 + ", sb = " + sb + " se = " + se + " sz2 = " + sz2);

            if (sz1 == 0 && sz2 == 0) {
                return 0;
            } else if (sz1 == 0 && sz2 > 0) {
                return getMedian(nums2);
            } else if (sz1 > 0 && sz2 == 0) {
                return getMedian(nums1);
            } else if (sz1 == 1 && sz2 == 1) {
                return (nums1[0] + nums2[0]) / 2;
            } else if ((sz1 == 2 && sz2 == 1) || (sz1 == 1 && sz2 == 2)) {
                int[] a = new int[]{};
                if (sz1 == 2 && sz2 == 1) {
                    a = new int[]{nums1[fb], nums1[fe], nums2[sb]};
                } else if (sz1 == 1 && sz2 == 2) {
                    a = new int[]{nums1[fb], nums2[sb], nums2[se]};
                }
                return getMedian(a);
            } else if (sz1 == 2 && sz2 == 2) {
                int[] a = new int[]{nums1[fb], nums1[fe], nums2[sb], nums2[se]};
                return getMedian(a);
            } else {
                int m1 = fb + (fe - fb) / 2;
                int m2 = sb + (se - sb) / 2;
                if (nums1[m1] < nums2[m2]) {
                    fb = m1;
                    se = m2;
                } else if (nums1[m1] > nums2[m2]) {
                    fe = m1;
                    sb = m2;
                } else if (nums1[m1] == nums2[m2]) {
                    fe = m1;
                    sb = m2;
                }
            }
        }
    }

    private double getMedian(int[] nums) {
        int mid = nums.length / 2;
        if (nums.length % 2 == 1) {
            return nums[mid];
        } else {
            return (nums[mid] + nums[mid - 1])/2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
