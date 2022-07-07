import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String name, String ID) {
        customerName = name;
        customerID = ID;
    }

    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }

    public void calculateInterest(int years) {
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println("What would you like to do?");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transactions");
        System.out.println("E. Exit");

        do {
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            
            switch(option) {
                case 'A':
                System.out.println("============================");
                System.out.println("Balance = $" + balance);
                System.out.println("============================");
                break;

                case 'B':
                System.out.println("Enter an amount to deposit: ");
                int amount = scanner.nextInt();
                deposit(amount);
                break;

                case 'C':
                System.out.println("Enter an amount to withdraw: ");
                int amount1 = scanner.nextInt();
                withdraw(amount1);
                break;

                case 'D':
                System.out.println("============================");
                getPreviousTransaction();
                System.out.println("============================");
                break;

                case 'E':
                System.out.println("Enter the number of years of accrued interest: ");
                int years = scanner.nextInt();
                calculateInterest(years);
                break;

                case 'F':
                System.out.println("============================");
                break;

                default:
                System.out.println("Error: invalid option. Please enter A, B, C, D, or E, or access services.");
                break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}