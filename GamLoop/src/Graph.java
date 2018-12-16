import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Graph {

    private static int currentIndex = -1;
    private int[][] graph;
    private int[][] iso_g; //iso_g = r[i][j] || h
    private ArrayList<Integer> gam_loop;
    private ArrayList<Integer> _iso_num;
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

    public int[][] ask_prepare() {
//        ArrayList<Integer> iso_num= new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> iso_num= new ArrayList<Integer>(Arrays.asList(6,3,4,2,0,1,7,5));
//        Collections.shuffle(iso_num);
        int h[][] = make_isomorphic(getGraph(), iso_num);
        ArrayList<Integer> iso_gam_loop = get_iso_gam_loop(iso_num);
        ArrayList<Integer> iso_gam_loop_value = new ArrayList<Integer>();
//        System.out.println(iso_gam_loop);
        int[][] _h = new int[graph.length][graph.length];
        int[][] f = new int[graph.length][graph.length];
        Random rnd = new Random();
        for (int i = 0; i < _h.length; ++i)
            for (int j = 0; j < _h.length; ++j)
                _h[i][j] = conc_ints(rnd.nextInt(10000), h[i][j]);

//        print_g(_h);
        print_g(graph);
        System.out.println(gam_loop + "\n" + iso_gam_loop);
        System.out.println(iso_num);
        print_g(h);
        for (int i = 0; i < iso_gam_loop.size() - 1; i++) {
            iso_gam_loop_value.add(_h[iso_gam_loop.get(i + 1)][iso_gam_loop.get(i)]);
        }
        System.out.println(iso_gam_loop_value);
        for (int i = 0; i < _h.length; ++i)
            for (int j = 0; j < _h.length; ++j)
                f[i][j] = mod_pow(_h[i][j], d, n); //матрица, которую мы передаем бобу
        this.iso_g = _h;
        this._iso_num = (ArrayList<Integer>) iso_num.clone();
        return f;
    }

    public void process() {
        Scanner sc = new Scanner(System.in);
        boolean answer;
        while (true) {
            int[][] f = ask_prepare();
            System.out.println("You have got the graph. Which question do u want to" +
                    " ask?\n1) What is gam loop for graph H?\n" +
                    "2)Do H isomorphic to G?\nOr how many times we need to ask?");
            int flg = sc.nextInt();
            if (flg != 2 && flg != 1) {
                Random rnd = new Random();
                for (int i = 0; i < flg; i++) {
                    if (!asking(rnd.nextInt(2) + 1, f))
                        System.out.println("Something went wrong! Warning!");
                }
                System.out.println("Asking complete with success!");
                break;
            }
            answer = asking(flg, f);
            if (flg == 2)
                if (answer)
                    System.out.println("\nThis graph is isomorphic. Succeed!\n");
                else System.out.println("This graph is not isomorphic! Warning!\n");

            if(flg == 1)
                if (answer)
                    System.out.println("\nGam loop was found. Succeed!\n");
                else System.out.println("Gam loop is wrong. Warning!\n");

        }
    }

    public boolean asking(int flg, int[][] f) {
        if (flg == 2) {
            return is_isomorphic(graph, iso_g, _iso_num, f);
        }
        else if (flg ==1) {
            return true;
        }
            else {
                System.out.println("flag value is incorrect");
                return false;
            }
    }

    public ArrayList<Integer> get_iso_gam_loop(ArrayList<Integer> iso_num) {
        ArrayList<Integer> iso_gam_loop = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        for (int i = 0; i < iso_num.size(); i++) {
            iso_gam_loop.set(gam_loop.indexOf(i), iso_num.get(i));
        }
//        System.out.println(gam_loop);
//        System.out.println(iso_num);
//        System.out.println(iso_gam_loop);
        return iso_gam_loop;
    }

    public int[][] make_isomorphic(int[][] graph, ArrayList<Integer> iso_num) {
        int[][] h = new int[graph.length][graph.length];
        for (int i = 0; i < h.length; ++i)
            for (int j = 0; j < h.length; ++j)
                h[i][j] = graph[iso_num.get(i)][iso_num.get(j)];
        return h;
    }

    public boolean is_isomorphic(int[][] graph, int[][] iso_g, ArrayList<Integer> iso_num, int[][] f) {
//        print_g(iso_g);
//        System.out.println();
//        print_g(make_isomorphic(graph, iso_num));
        int[][] ses = make_isomorphic(graph, iso_num);
        int[][] h = new int[graph.length][graph.length];
        for (int i = 0; i < ses.length; i++)
            for (int j = 0; j < ses.length; j++)
                h[i][j] = iso_g[i][j] % 2; //h - isom graph; iso_g = r[i][j] || h
        for (int i = 0; i < ses.length; i++)
            for (int j = 0; j < ses.length; j++)
                if (ses[i][j] != h[i][j] || f[i][j] != mod_pow(iso_g[i][j], d, n))
                    return false;
        return true;
//        return Arrays.equals(make_isomorphic(graph, iso_num), iso_g);
    }

    public boolean is_gam_loop(ArrayList<Integer> iso_gam_loop_value, ArrayList<Integer> iso_gam_loop) {
        for (int i = 0; i < iso_gam_loop_value.size() - 1; i++) {
            
        }
        return true;
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
        ArrayList<Integer> integers = new ArrayList<Integer>();
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
