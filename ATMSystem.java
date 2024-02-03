import java.util.Scanner;

// Define the User class to store user information
class User1 {
    private String userId;
    private int pin;

    // Constructor
    protected User1(String userId, int pin) {
        this.userId = userId;
        this.pin = pin;
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }
}

// Define the Transaction class to store transaction details
class Transaction {
    private String type;
    private double amount;

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

// Define the ATM class to handle ATM functionalities
class ATM {
    private User1 user;
    private Transaction[] transactionHistory;
    private int transactionCount;

    // Constructor
    public ATM(User1 user) {
        this.user = user;
        this.transactionHistory = new Transaction[100]; // Assuming max 100 transactions
        this.transactionCount = 0;
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            Transaction transaction = transactionHistory[i];
            System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        // Implement withdrawal logic here
        // Update transaction history
        transactionHistory[transactionCount++] = new Transaction("Withdraw", amount);
    }

    // Method to transfer money
    public void transfer(double amount) {
        // Implement transfer logic here
        // Update transaction history
        transactionHistory[transactionCount++] = new Transaction("Transfer", amount);
    }

    // Method to deposit money
    public void deposit(double amount) {
        // Implement deposit logic here
        // Update transaction history
        transactionHistory[transactionCount++] = new Transaction("Deposit", amount);
    }
}

// Main class for the console-based application
public class ATMSystem {
    public static void main(String[] args) {
        // Initialize ATM
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter User PIN:");
        int pin = scanner.nextInt();
        User1 user = new User1(userId, pin);
        ATM atm = new ATM(user);

        // ATM functionalities loop
        boolean quit = false;
        while (!quit) {
            System.out.println("ATM Functionalities:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Deposit");
            System.out.println("5. Quit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.displayTransactionHistory();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to transfer:");
                    double transferAmount = scanner.nextDouble();
                    atm.transfer(transferAmount);
                    break;
                case 4:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}

