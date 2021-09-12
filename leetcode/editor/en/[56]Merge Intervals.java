//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics Array Sorting 👍 9237 👎 428


import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56 {

    static class ValAndFlag {
        public int v;
        public int f;
        public int ind;
        public int sum;

        public ValAndFlag(int v, int f, int ind) {
            this.v = v;
            this.f = f;
            this.ind = ind;
            sum = 0;
        }

//        @Override
//        public String toString() {
//            return "ValAndFlag{" +
//                    "v=" + v +
//                    ", f=" + f +
//                    ", ind=" + ind +
//                    ", sum=" + sum +
//                    '}';
//        }
    }

    public int[][] merge(int[][] intervals) {
        final TreeSet<ValAndFlag> valAndFlags = buildSortedIntervals(intervals);
        ArrayList<ValAndFlag> stk = new ArrayList<>();

        ArrayList<Integer> beg = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        for (ValAndFlag iv : valAndFlags) {
            int stTopSum = getStkSum(stk);
            iv.sum = stTopSum + iv.f;
            stk.add(iv);

            if (popAndPush(stk)) {
                beg.add(stk.get(0).v);
                end.add(stk.get(stk.size() - 1).v);
                stk.clear();
            }
        }

//        System.out.println("beg = " + beg);
//        System.out.println("end = " + end);

        int size = beg.size();
//        System.out.println("size = " + size);
        int[][] ret = new int[size][2];
        for (int i = 0; i < size; i++) {
            ret[i][0] = beg.get(i);
            ret[i][1] = end.get(i);
        }

//        for (int[] ints : ret) {
//            for (int anInt : ints) {
//                System.out.print(anInt + ",");
//            }
//            System.out.println();
//        }

        return ret;
    }

    private int getStkSum(ArrayList<ValAndFlag> stk) {
        if (stk.isEmpty()) {
            return 0;
        }
        return stk.get(stk.size()-1).sum;
    }

    private TreeSet<ValAndFlag> buildSortedIntervals(int[][] intervals) {
        final TreeSet<ValAndFlag> valAndFlags = new TreeSet<>(getComparator());
        for (int i = 0; i < intervals.length; i++) {
            int[] iv = intervals[i];
            valAndFlags.add(new ValAndFlag(iv[0], -1, i));
            valAndFlags.add(new ValAndFlag(iv[1], 1, i));
//            System.out.println("valAndFlags = " + valAndFlags);
        }
//        System.out.println("valAndFlags.size() = " + valAndFlags.size());
        return valAndFlags;
    }

    private Comparator<ValAndFlag> getComparator() {
        return (o1, o2) -> {
            if (o1.v != o2.v) {
                return o1.v - o2.v;
            } else if (o1.v == o2.v && o1.f == o2.f) {
                return o1.ind - o2.ind;
            } else {
                return o1.f - o2.f;
            }
        };
    }

    private boolean popAndPush(ArrayList<ValAndFlag> ivs) {
        return !ivs.isEmpty() && ivs.get(ivs.size() - 1).sum == 0;
    }

    public static void main(String[] args) {
        new Solution56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        new Solution56().merge(new int[][]{{1, 4}, {1, 5}});
        new Solution56().merge(new int[][]{{1, 4}, {4, 5}});
        new Solution56().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
