import java.util.Scanner;

/*
 * Check balance, deposite, withdraw, previous transaction and exit
 */

public class App {

    private static String userName = "";
    private static String userId = "";

    public static void main(String[] args) {

        login();
        BankMenu menu1 = new BankMenu(userName, userId);
        menu1.showMenu();
    }

    public static void print(String text) {
        System.out.println(text);
    }

    private static void login() {
        print("");
        print("");
        print("");
        print("");
        print("");
        print("===========================================================================");
        print("Welcome, before continue please enter your user name and your personal ID :");
        print("===========================================================================");
        print("");

        Scanner scanner = new Scanner(System.in);

        print("Enter your name : ");
        userName = scanner.nextLine();
        print("Enter your personal ID : ");
        userId = scanner.nextLine();
        print("");
    }
}

class BankMenu {
    String userName;
    String userId;
    int currentBalance;
    int previousTransaction;

    BankMenu(String uName, String uId) {
        this.userName = uName;
        this.userId = uId;
    }

    void deposit(int amount) {
        if (amount > 0) {
            currentBalance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            currentBalance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            App.print("Last operation :");
            App.print("--> Deposited : " + previousTransaction);

        } else if (previousTransaction < 0) {
            App.print("Last operation :");
            App.print("--> Withdrawn : " + Math.abs(previousTransaction));
        } else {
            App.print("Sorry, no transaction has been found.");
        }
    }

    public void showMenu() {
        Scanner menuScanner = new Scanner(System.in);
        String option = "";

        App.print("===========================================================================");
        App.print("Welcome back " + userName + " (User ID : " + userId + ")");
        App.print("===========================================================================");
        App.print("");
        App.print("A. Check current balance");
        App.print("B. Deposit");
        App.print("C. Withdraw");
        App.print("D. Check the last transaction");
        App.print("E. Exit the app");
        App.print("");

        while (!option.equals("e") && !option.equals("E")) {
            App.print("===========================================================================");
            App.print("Please select one of the options below :");
            App.print("===========================================================================");

            option = menuScanner.next();

            switch (option) {
                case "A":
                case "a":
                    App.print("-----------------------------");
                    App.print("Current Balance : " + currentBalance);
                    App.print("-----------------------------");
                    App.print("\n");
                    break;

                case "B":
                case "b":
                    App.print("-----------------------------");
                    App.print("Enter the amont you want to deposit : ");
                    App.print("-----------------------------");
                    App.print("\n");
                    int amountDeposited = menuScanner.nextInt();
                    deposit(amountDeposited);
                    App.print("\n");
                    break;

                case "C":
                case "c":
                    App.print("-----------------------------");
                    App.print("Enter the amont you want to withdraw : ");
                    App.print("-----------------------------");
                    App.print("\n");
                    int amountWithdrawn = menuScanner.nextInt();
                    withdraw(amountWithdrawn);
                    App.print("\n");
                    break;

                case "D":
                case "d":
                    getPreviousTransaction();
                    App.print("\n");
                    break;

                case "E":
                case "e":
                    App.print("\n");
                    App.print("===========================================================================");
                    App.print("You're successfully disconnected. Thank's for your trust.");
                    App.print("===========================================================================");
                    option = "E";
                    break;

                default:
                    App.print("Error, you're not allowed to do that. Please select a valid option.");
                    break;
            }
        }

    }
}