import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Bank bank = new Bank();
        Customer customer = new Customer(bank);
        customer.spend_banknote(100);
    }
}
