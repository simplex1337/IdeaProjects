import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Graph {

    private static int currentIndex = -1;
    private int[][] graph;
    private ArrayList gam_loop;

    public Graph() throws Exception {
        this.graph = parse_graph("src/graph");
        this.gam_loop = parse_loop("src/loop");
    }

    private int[][] parse_graph(String file) throws Exception {
        FileInputStream inFile = new FileInputStream(file);
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        String[] numbers = text.split("\\D");
        int i, j;
        int n = next(numbers), m = n;
        int matrix[][] = new int[n][m];

        for (i = 0; i < n; ++i)
            for (j = 0; j < m; ++j)
                matrix[i][j] = next(numbers);

//        for (i = 0; i < n; ++i, System.out.println())
//            for (j = 0; j < m; ++j)
//                System.out.print(matrix[i][j] + " ");
        return matrix;
    }

    public void make_isomorphic(int[][] graph) {
        int[][] h = new int[graph.length][graph.length];
        System.out.println(getGam_loop());
        ArrayList<Integer> loop= new ArrayList<Integer>(); //copy of gam_loop
        loop = (ArrayList<Integer>) getGam_loop().clone();
        Collections.shuffle(loop);
        System.out.println(getGam_loop());
        System.out.println(loop);
        //TODO: shuffle(1-8); создать матрицу смежности с сохраненными связями по шафлу; убрать все, что сверху

//        for (int i = 0; i < h.length; ++i, System.out.println())
//            for (int j = 0; j < h.length; ++j)
//                System.out.print(h[i][j] + " ");
    }

    private static Integer next(String numbers[]) {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    private ArrayList<Integer> parse_loop(String path) throws IOException {
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
//        for (int i = 0; i < integers.size(); i++) {
//            System.out.print(integers.get(i) + " ");
//        }
        return integers;
    }

    public int[][] getGraph() {
        return graph;
    }

    public ArrayList getGam_loop() {
        return gam_loop;
    }
}
