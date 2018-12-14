import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Graph {

    private static int currentIndex = -1;
    private int[][] graph;
    private ArrayList gam_loop;
    private int p, q, n, c, d;

    public Graph() throws Exception {
        this.graph = parse_graph("src/graph");
        this.gam_loop = parse_loop("src/loop");
        this.p = get_big_prime();
        this.q = get_big_prime();
        this.n = p * q;
        int f = (p - 1) * (q - 1);
        Random rnd = new Random();
        do
            this.d = rnd.nextInt((int)f - 2);
        while (gcd(d, f) != 1);
        this.c = (int) ext_gcd(d, f) + f;
    }

    public void ask_prepare() {
        ArrayList<Integer> iso_num= new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        Collections.shuffle(iso_num);
        int h[][] = make_isomorphic(getGraph(), iso_num);
        int[][] _h = new int[graph.length][graph.length];
        int[][] f = new int[graph.length][graph.length];
        //TODO: метод, возвраща гамильтонов цикл в изоморфном графе
        Random rnd = new Random();
        for (int i = 0; i < _h.length; ++i, System.out.println())
            for (int j = 0; j < _h.length; ++j)
                _h[i][j] = conc_ints(rnd.nextInt(10000), h[i][j]);
        for (int i = 0; i < _h.length; ++i, System.out.println())
            for (int j = 0; j < _h.length; ++j)
                f[i][j] = mod_pow(_h[i][j], d, n); //матрица, которую мы передаем бобу

    }

    public int[][] make_isomorphic(int[][] graph, ArrayList<Integer> iso_num) {
        int[][] h = new int[graph.length][graph.length];
        for (int i = 0; i < h.length; ++i)
            for (int j = 0; j < h.length; ++j)
                h[i][j] = graph[iso_num.get(i)][iso_num.get(j)];
        return h;
    }

    public boolean is_isomorphic(int[][] graph, int[][] iso_g, ArrayList<Integer> iso_num) {
        return Arrays.equals(make_isomorphic(graph, iso_num), iso_g);
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

    public void print_g(int[][] g) {
        for (int i = 0; i < g.length; ++i, System.out.println())
            for (int j = 0; j < g.length; ++j)
                System.out.print(g[i][j] + " ");
    }

    public int conc_ints(int a, int b) {
        return Integer.parseInt(Integer.toString(a) + Integer.toString(b));
    }

    public int mod_pow(long a, long pow, long mod) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            pow >>= 1;
        }
        return (int) res;
    }

    public long ext_gcd(long a, long b ) { //ax + by = d
        if (b == 0) {
            long ans[] = {a, 1, 0};
            return ans[1];
        }
        long q, r;
        long x[] = {0, 0, 1};
        long y[] = {0, 1, 0};
        while (b > 0) {
            q = a / b;
            r = a - q * b;
            x[0] = x[2] - q * x[1];
            y[0] = y[2] - q * y[1];

            a = b;
            b = r;
            x[2] = x[1];
            x[1] = x[0];
            y[2] = y[1];
            y[1] = y[0];
        }
        long ans[] = {a, x[2], y[2]};
        return ans[1]; // d, x, y
    }

    public long gcd(long a, long b) {
        return (b != 0) ? gcd(b, a % b) : a;
    }

    private boolean is_prime(int p) {
        if (p <= 1)
            return false;

        int b = (int) Math.pow(p, 0.5);

        for (int i = 2; i <= b; ++i) {
            if ((p % i) == 0 ) return false;
        }
        return true;
    }

    public int get_big_prime() {
        Random random = new Random();
        int x;
        do x = random.nextInt(500) + 500; while(!is_prime(x)  || !is_prime((x - 1) / 2));
        return x;
    }

    public int[][] getGraph() {
        return graph;
    }

    public ArrayList getGam_loop() {
        return gam_loop;
    }
}
