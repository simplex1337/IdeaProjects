import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Bank bank = new Bank();
        Customer customer = new Customer(bank);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Your bank account : $" + customer.getCash() +
                    "\nEnter count of money: ");
            customer.spend_money(sc.nextInt());
            if (customer.getCash() == 0) {
                System.out.println("You don't have money. Bye-bye!");
                break;
            }
        }

    }
}
