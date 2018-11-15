import java.util.ArrayList;
import java.util.Random;

public class Table {

    private int p;
    private ArrayList<Player> players;
    private int[] cards;

    public Table(int n) {
        this.p = get_big_prime(1500, 2500);
        this.players = get_players(n);
        this.cards = get_cards();
    }

    private ArrayList<Player> get_players(int n) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(p));
        }
        return players;
    }

    public void distribution() {
         for(Player player:players) {
             code_cards(player.getC());
//             System.out.println();
         }
         // раздаем по 2 карты каждому
         // каждый просит остальных расшифровать карты
         // потом расшифровывает сам и узнает свои карты
    }

    public void code_cards(int c) {
        int[] coded_cards = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            coded_cards[i] = mod_pow(cards[i], c, p);
        }
        shuffleArray(coded_cards);
        this.cards = coded_cards;
        for (int i = 0; i < cards.length; i++) {
            System.out.print(" " + cards[i]);
        }
    }

    public static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    private int mod_pow(long a, long pow, long mod) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            pow >>= 1;
        }
        return (int) res;
    }

    private int[] get_cards() {
        int[] cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i + 2;
        }
        return cards;
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

    private int get_big_prime(int low, int high) {
        Random random = new Random();
        int x;
        do x = random.nextInt(high - low) + low; while(!is_prime(x));
        return x;
    }
}
