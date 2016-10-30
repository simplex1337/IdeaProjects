import java.util.Random;

/**
 * Created by alex on 30.10.16.
 */
public class Main {
    public static void main(String[]args) {
        Random rnd = new Random(System.currentTimeMillis());
        int[][] a1;
        int g = rnd.nextInt(10);
        a1 = new int[g][];
        for(int i = 0; i<a1.length; i++) {
            int n = rnd.nextInt(20);
            a1[i] = new int [n];
        }
        for(int i = 0; i<a1.length; i++) {
            for(int j = 0; j<a1[i].length; j++) {
                a1[i][j] = rnd.nextInt(256) - 128;
                System.out.print(a1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
