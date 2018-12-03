public class Customer {

    private int cash;
    private Bank bank;

    public Customer(Bank bank) {
        this.cash = 1000;
        this.bank = bank;
    }

    public void spend_banknote(int banknote) {
        int n, r, _n;
        n = bank.get_big_prime();
        do {
            r = bank.get_big_prime();
        } while (bank.gcd(r, bank.getN()) != 1);
        _n = (bank.mod_pow(r, bank.getD(), bank.getN()) * (n % bank.getN())) % bank.getN();
        


    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }


}
