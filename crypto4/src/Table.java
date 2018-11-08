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

    private int[] get_cards() {
        int[] cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i + 1;
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
