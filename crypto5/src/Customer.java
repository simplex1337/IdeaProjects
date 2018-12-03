import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Customer {

    private int cash;
    private Bank bank;

    public Customer(Bank bank) {
        this.cash = 1000;
        this.bank = bank;
    }

    public void spend_banknote(int banknote) throws NoSuchAlgorithmException {
        int n, r;
        Random rnd = new Random();
        n = rnd.nextInt(bank.getN() - 3) + 2;
        int[] f_n = bank.getHash(n);
        int[] _n = new int[f_n.length];
        int[] s = new int[f_n.length];
        int[] _s = new int[f_n.length];
        do {
            r = rnd.nextInt(bank.getN() - 3) + 2;
        } while (bank.gcd(r, bank.getN()) != 1);
        int r_inv = (int) bank.ext_gcd(r, bank.getN()) + bank.getN(); //инверсия говно, переделать
        System.out.println("r inv = " + r_inv);
        for (int i = 0; i < f_n.length; i++) {
            _n[i] = (bank.mod_pow(r, bank.getD(), bank.getN()) * (f_n[i] % bank.getN())) % bank.getN();
            s[i] = bank.mod_pow(_n[i], bank.getC(), bank.getN());
            _s[i] = (s[i] * r_inv) % bank.getN();
//            System.out.print(" " + _s[i]);
        }
        System.out.println("f(n) = " + f_n[0] + " calc = " + bank.mod_pow(s[0], bank.getD(), bank.getN()));

        bank.add_banknote(n, banknote);
        this.setCash(this.getCash() - banknote);

    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }


}
