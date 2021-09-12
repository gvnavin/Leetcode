//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 👍 4820 👎 709


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {

    @FunctionalInterface
    interface Move {
        Coord move(Coord coord);
    }

    static class MoveRight implements Move {
        public Coord move(Coord coord) {
            return coord.moveRight();
        }
    }

    static class MoveDown implements Move {
        public Coord move(Coord coord) {
            return coord.moveDown();
        }
    }

    static class MoveLeft implements Move {
        public Coord move(Coord coord) {
            return coord.moveLeft();
        }
    }

    static class MoveUp implements Move {
        public Coord move(Coord coord) {
            return coord.moveUp();
        }
    }

    private static final Move[] moves = new Move[]{
            new MoveRight(),
            new MoveDown(),
            new MoveLeft(),
            new MoveUp(),
    };
    private static final int ms = moves.length;

    class Coord {
        int i = 0;
        int j = 0;
        int dir = 0;
        int[][] m;
        int[][] vis;
        int r;
        int c;

        public Coord(int[][] m) {
            this.m = m;
            this.r = m.length;
            this.c = m[0].length;
            this.vis = new int[r][c];
        }

        Coord moveRight() {
            if (j + 1 < c && vis[i][j + 1] != 1) {
                dir = 0;
                this.j++;
                return this;
            }
            return null;
        }

        Coord moveDown() {
            if (i + 1 < r && vis[i + 1][j] != 1) {
                dir = 1;
                this.i++;
                return this;
            }
            return null;
        }

        Coord moveLeft() {
            if (j - 1 >= 0 && vis[i][j - 1] != 1) {
                dir = 2;
                this.j--;
                return this;
            }
            return null;
        }

        Coord moveUp() {
            if (i - 1 >= 0 && vis[i - 1][j] != 1) {
                dir = 3;
                this.i--;
                return this;
            }
            return null;
        }

        Coord nextCoordV2() {
            Coord nextCoord = null;
            int ti = dir;
            int cnt = 0;
            while ( (nextCoord = move(ti)) == null && cnt < ms) {
                ti = (ti+1) % ms;
                cnt ++;
            }
            return nextCoord;
        }

        private Coord move(int ti) {
            return moves[ti].move(this);
        }

//        Coord nextCoord() {
//            Coord nextCoord = null;
//            switch (dir) {
//                case 0:
//                    if ((nextCoord = moveRight()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveDown()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveLeft()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveUp()) != null) {
//                        return nextCoord;
//                    }
//                case 1:
//                    if ((nextCoord = moveDown()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveLeft()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveUp()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveRight()) != null) {
//                        return nextCoord;
//                    }
//                case 2:
//                    if ((nextCoord = moveLeft()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveUp()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveRight()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveDown()) != null) {
//                        return nextCoord;
//                    }
//                case 3:
//                    if ((nextCoord = moveUp()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveRight()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveDown()) != null) {
//                        return nextCoord;
//                    } else if ((nextCoord = moveLeft()) != null) {
//                        return nextCoord;
//                    }
//            }
//            return nextCoord;
//        }

        int get() {
            return m[i][j];
        }

        public void markVisited() {
            vis[i][j] = 1;
        }

//        public void printVisited() {
//            for (int k = 0; k < vis.length; k++) {
//                for (int l = 0; l < vis[k].length; l++) {
//                    System.out.print(vis[k][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("---------------------");
//        }
//
//        public void printCoord(String str) {
//            System.out.println(str + " i = " + i + ", j = " + j);
//        }
    }

    public List<Integer> spiralOrder(int[][] m) {
        Coord cd = new Coord(m);
        int ci = 0;
        int sz = cd.r * cd.c;

        List<Integer> ret = new ArrayList<>();
        while (ci < sz) {
            ret.add(cd.get());
            cd.markVisited();
            cd = cd.nextCoordV2();
            ci++;
        }
        return ret;
    }

//    public static void main(String[] args) {
//        new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
//        new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
