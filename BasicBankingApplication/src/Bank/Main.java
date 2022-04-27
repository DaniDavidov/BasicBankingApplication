package Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: " );
        String name = scanner.nextLine();
        System.out.print("Enter your pin: ") ;
        String pin = scanner.nextLine();

        Account account = new Account(name, pin);
        account.showMenu();
    }
}
