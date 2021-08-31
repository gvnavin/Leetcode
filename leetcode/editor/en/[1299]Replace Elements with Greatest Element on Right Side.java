//Given an array arr, replace every element in that array with the greatest 
//element among the elements to its right, and replace the last element with -1. 
//
// After doing so, return the array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [17,18,5,4,6,1]
//Output: [18,6,6,6,1,-1]
//Explanation: 
//- index 0 --> the greatest element to the right of index 0 is index 1 (18).
//- index 1 --> the greatest element to the right of index 1 is index 4 (6).
//- index 2 --> the greatest element to the right of index 2 is index 4 (6).
//- index 3 --> the greatest element to the right of index 3 is index 4 (6).
//- index 4 --> the greatest element to the right of index 4 is index 5 (1).
//- index 5 --> there are no elements to the right of index 5, so we put -1.
// 
//
// Example 2: 
//
// 
//Input: arr = [400]
//Output: [-1]
//Explanation: There are no elements to the right of index 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁵ 
// 
// Related Topics Array 👍 924 👎 154


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int[] ret = new int[arr.length];

        if (ret.length > 0) {
            ret[ret.length-1] = -1;
        }
        int max = arr[arr.length-1];

        for (int i = arr.length-2; i >= 0; i--) {
            ret[i] = max;
            if (arr[i] > max) {
                max = arr[i];
            }
        }

//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j]+" ");
//        }
//        System.out.println();
//        for (int j = 0; j < ret.length; j++) {
//            System.out.print(ret[j]+" ");
//        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
