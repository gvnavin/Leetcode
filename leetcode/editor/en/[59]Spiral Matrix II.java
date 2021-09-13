//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 👍 1971 👎 143


//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {

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

        void put(int v) {
            m[i][j] = v;
        }

        public void markVisited() {
            vis[i][j] = 1;
        }

        public void printValues() {
            for (int k = 0; k < m.length; k++) {
                for (int l = 0; l < m[k].length; l++) {
                    System.out.print(m[k][l] + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------");
        }

        public void printCoord(String str) {
            System.out.println(str + " i = " + i + ", j = " + j);
        }

        public void printVisited() {
            for (int k = 0; k < vis.length; k++) {
                for (int l = 0; l < vis[k].length; l++) {
                    System.out.print(vis[k][l] + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------");
        }

    }
    
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        Coord cd = new Coord(m);
        Coord temp = cd;
        int ci = 0;
        int sz = cd.r * cd.c;

        while (ci < sz) {
            cd.put(ci+1);
            cd.markVisited();
            cd = cd.nextCoordV2();
            ci++;
        }
//        temp.printValues();
        return temp.m;
    }

    public static void main(String[] args) {
        new Solution59().generateMatrix(4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
