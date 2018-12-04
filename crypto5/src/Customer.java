import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class Customer {

    private int cash;
    private Bank bank;

    public Customer(Bank bank) {
        this.cash = 1000;
        this.bank = bank;
    }

    public boolean spend_banknote(int banknote) throws NoSuchAlgorithmException {
        int n;
        Random rnd = new Random();
        n = rnd.nextInt(bank.getN() - 3) + 2;
        int[] f_n = bank.getHash(n);
        int[] s = new int[f_n.length];

        for (int i = 0; i < s.length; i++) {
            s[i] = bank.mod_pow(f_n[i], bank.getC(), bank.getN());
        }

        if(bank.check_banknote(n, banknote, s)) {
            bank.add_banknote(n, banknote);
            this.setCash(this.getCash() - banknote);
            return true;
        }
        else return false;
    }

    public boolean spend_money(int m) throws NoSuchAlgorithmException {
        int money = m;
        if (getCash() - money < 0) {
            System.out.println("You dont have this amount of money on your bank account\n" +
                    "Declining operation\n");
            return false;
        }
        int _1000 = money / 1000; money %= 1000;
        int _100 = money / 100; money %= 100;
        int _10 = money / 10; money %= 10;
        int _5 = money / 5; money %= 5;
        int _1 = money;
        for (int i = 0; i < _1000; i++) {
            spend_banknote(1000);
        }

        for (int i = 0; i < _100; i++) {
            spend_banknote(100);
        }

        for (int i = 0; i < _10; i++) {
            spend_banknote(10);
        }

        for (int i = 0; i < _5; i++) {
            spend_banknote(5);
        }

        for (int i = 0; i < _1; i++) {
            spend_banknote(1);
        }
        System.out.println("You have been successfully spend $" + m);
        return true;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }


}
