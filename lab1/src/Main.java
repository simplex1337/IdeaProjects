import java.util.Random;

public class Main {
    public static void main(String[]args) {
        int[][] matrixA;
        int clmn = 3, row = 3;
        matrixA = new int[clmn][row];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < clmn; i++) {
            for (int j = 0; j < row; j++) {
                matrixA[i][j] = rnd.nextInt(256) - 128;
                //matrixA[i][j] = 1;
            }
        }
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < clmn; i++) {
                System.out.print(matrixA[i][j] + "\t");
            }
            System.out.println();
        }
        diaga(matrixA, clmn, row);
        diagb(matrixA, clmn, row);
        spiv(matrixA, clmn, row);
        spig(matrixA, clmn, row);
    }

    private static void diaga(int[][]matrixA, int clmn, int row) {
        int[] massB;
        int i = clmn - 1, n = 0;
        massB = new int[clmn * row];
        for (int cnt = 0; cnt < clmn * row; cnt++) {
            if (i < clmn && n < row && i > -1) {
                massB[cnt] = matrixA[i][n];
                System.out.print(massB[cnt] + "  ");
                i++;
                n++;
            } else {
                int tmp = n;
                if (n > (i - 1)) {
                    n = n - i + 1;
                    i = clmn - tmp;
                } else {
                    n = 0;
                    i = clmn - 1 - tmp;
                }
                cnt--;
            }
        }
        System.out.println();
    }

    private static void diagb(int[][]matrixA, int clmn, int row) {
        int[] massB;
        int i = 0, tmp = 0, n = 0;
        massB = new int[clmn * row];
        for (int cnt = 0; cnt < clmn * row; cnt++) {
            if (i < clmn && n < row && i > -1) {
                massB[cnt] = matrixA[i][n];
                System.out.print(massB[cnt] + "  ");
                i--;
                n++;
            } else {
                if (tmp >= row) {
                    n = tmp - row + 1;
                    i = clmn - 1;
                    tmp++;
                } else {
                    i = n;
                    tmp++;
                    n = 0;
                }
                cnt--;
            }
        }
        System.out.println();
    }

    private static void spiv(int[][]matrixA, int clmn, int row) {
        int[] massB;
        massB = new int[clmn * row];
        int dir = 0, m, i = (clmn - 1) / 2, n = (row - 1) / 2;
        double spur = 1;
        for (int cnt = 0; cnt < clmn * row;) {
            for (m = 0; m < Math.floor(spur); m++) {
                massB[cnt] = matrixA[i][n];
                System.out.print(massB[cnt] + " ");
                if (dir == 0 && i < clmn)
                    i++;
                if (dir == 1 && n < row)
                    n++;
                if (dir == 2 && i > -1)
                    i--;
                if (dir == 3 && n > -1)
                    n--;
                cnt++;
            }
            dir++;
            if (dir > 3)
                dir = 0;
            spur = spur + 0.5;
        }
        System.out.println();
    }

    private static void spig(int[][] matrixA, int clmn, int row) {
        int[] massB = new int[clmn * row];
        int dir = 0, m, i = 0, n = 0;
        double spur;
        if (clmn == row && row == 1)
            spur = clmn;
        else
            spur = clmn - 1;
        for (int cnt = 0; cnt < clmn * row;) {
            for (m = 0; m < spur; m++) {
                massB[cnt] = matrixA[i][n];
                System.out.print(massB[cnt] + " ");
                if (dir == 0 && i < clmn)
                    i++;
                if (dir == 1 && n < row) {
                    n++;
                    if (m == 0 && spur != clmn - 1)
                        spur--;
                }
                if (dir == 2 && i > -1)
                    i--;
                if (dir == 3 && n > -1) {
                    n--;
                    if (m == 0)
                        spur--;
                }
                cnt++;
            }
            dir++;
            if (dir > 3)
                dir = 0;
        }
        System.out.println();
    }

}
