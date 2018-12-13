import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private static int currentIndex = -1;

    public Graph() throws Exception {
        int[][] graph = parse_graph("src/graph");
        ArrayList list = parse_loop("src/loop");
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
}
