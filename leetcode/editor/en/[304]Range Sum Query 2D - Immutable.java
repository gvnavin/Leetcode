//Given a 2D matrix matrix, handle multiple queries of the following type: 
//
// 
// Calculate the sum of the elements of matrix inside the rectangle defined by 
//its upper left corner (row1, col1) and lower right corner (row2, col2). 
// 
//
// Implement the NumMatrix class: 
//
// 
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix 
//matrix. 
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
//elements of matrix inside the rectangle defined by its upper left corner (row1, 
//col1) and lower right corner (row2, col2). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 
//3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
//Output
//[null, 8, 11, 12]
//
//Explanation
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 
//0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// At most 10⁴ calls will be made to sumRegion. 
// 
// Related Topics Array Design Matrix Prefix Sum 👍 2019 👎 231


//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int r;
    int c;
    int[][] sum;

    public NumMatrix(int[][] m) {
        r = m.length;
        c = m[0].length;
        sum = m;

        columnSum();
        rowSum();

//        for (int[] x : m)
//        {
//            for (int y : x)
//            {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------------------------------------");
//        for (int[] x : sum)
//        {
//            for (int y : x)
//            {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }
    }

    private void rowSum() {
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j];
            }
        }
    }

    private void columnSum() {
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i][j];
            }
        }
    }

    public int sumRegion(int i, int j, int r, int c) {

        int totalSum = sum[r][c];
        int topSum = 0;
        int leftSum = 0;

        int topLeftSum = 0;
        int topLeftX = -1;
        int topLeftY = -1;

        if (i == 0) {
            topSum = 0;
        } else {
            topSum = sum [i-1][c];
            topLeftX = i-1;
        }

        if (j == 0) {
            leftSum = 0;
        } else {
            leftSum = sum[r][j-1];
            topLeftY= j-1;
        }

        if (topLeftX != -1 && topLeftY != -1) {
            topLeftSum = sum[topLeftX][topLeftY];
        }

        int ret = totalSum - (topSum + leftSum - topLeftSum);

        return ret;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
