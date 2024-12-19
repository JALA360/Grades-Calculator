import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SimpleBanking {
    private String accountName;
    private String accountNumber;
    private double accountBalance;
    private String password;
    private List<String> transactionHistory;

    public SimpleBanking(String name, String number, double balance) {
        this.accountName = name;
        this.accountNumber = number;
        this.accountBalance = balance;
        this.password = "123"; // Default password
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: $" + balance);
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getPassword() {
        return password;
    }

    public void viewInformation() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Transaction History: " + transactionHistory);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Successfully deposited $" + amount);
            System.out.println("Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void transfer(SimpleBanking targetAccount, double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to " + targetAccount.getAccountName());
            System.out.println("Successfully transferred $" + amount + " to " + targetAccount.getAccountName());
            System.out.println("Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }

    public void updateAccountInfo(String newName, String newNumber) {
        this.accountName = newName;
        this.accountNumber = newNumber;
        System.out.println("Account information updated successfully!");
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password updated successfully!");
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SimpleBanking> accounts = new ArrayList<>();
        accounts.add(new SimpleBanking("John Doe", "123456789", 1000.00)); // Sample account
        accounts.add(new SimpleBanking("Jane Smith", "987654321", 1500.00)); // Sample account

        int choice;
        do {
            System.out.println("\nWelcome to Simple Banking");
            System.out.println("\t1. Create Account");
            System.out.println("\t2. Select Account");
            System.out.println("\t3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter account name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    SimpleBanking newAccount = new SimpleBanking(name, number, balance);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully!");
                }
                case 2 -> {
                    System.out.println("Select an account by number:");
                    for (SimpleBanking account : accounts) {
                        System.out.println("\tAccount Number: " + account.getAccountNumber() + ", Name: " + account.getAccountName());
                    }
                    String selectedAccountNumber = sc.next();
                    SimpleBanking selectedAccount = null;

                    for (SimpleBanking account : accounts) {
                        if (account.getAccountNumber().equals(selectedAccountNumber)) {
                            selectedAccount = account;
                            break;
                        }
                    }

                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    // Verify password before allowing operations
                    System.out.print("Enter account password: ");
                    String inputPassword = sc.next();

                    if (!selectedAccount.verifyPassword(inputPassword)) {
                        System.out.println("Incorrect password. Access denied.");
                        break;
                    }

                    int accountChoice;
                    do {
                        System.out.println("\nSelected Account: " + selectedAccount.getAccountName());
                        System.out.println("\t1. View account information");
                        System.out.println("\t2. Deposit");
                        System.out.println("\t3. Withdraw");
                        System.out.println("\t4. Transfer Funds");
                        System.out.println("\t5. Update Account Information");
                        System.out.println("\t6. Change Password");
                        System.out.println("\t7. Exit to main menu");
                        System.out.print("Enter your choice: ");
                        accountChoice = sc.nextInt();

                        switch (accountChoice) {
                            case 1 -> selectedAccount.viewInformation();
                            case 2 -> {
                                try {
                                    System.out.print("Enter deposit amount: ");
                                    double amount = sc.nextDouble();
                                    selectedAccount.deposit(amount);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.next(); // Clear the invalid input
                                }
                            }
                            case 3 -> {
                                try {
                                    System.out.print("Enter withdrawal amount: ");
                                    double amount = sc.nextDouble();
                                    selectedAccount.withdraw(amount);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.next(); // Clear the invalid input
                                }
                            }
                            case 4 -> {
                                System.out.println("Select target account for transfer:");
                                for (SimpleBanking account : accounts) {
                                    if (!account.getAccountNumber().equals(selectedAccount.getAccountNumber())) {
                                        System.out.println("\tAccount Number: " + account.getAccountNumber() + ", Name: " + account.getAccountName());
                                    }
                                }
                                String targetAccountNumber = sc.next();
                                SimpleBanking targetAccount = null;

                                for (SimpleBanking account : accounts) {
                                    if (account.getAccountNumber().equals(targetAccountNumber)) {
                                        targetAccount = account;
                                        break;
                                    }
                                }

                                if (targetAccount == null) {
                                    System.out.println("Target account not found.");
                                    break;
                                }

                                try {
                                    System.out.print("Enter transfer amount: ");
                                    double amount = sc.nextDouble();
                                    selectedAccount.transfer(targetAccount, amount);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.next(); // Clear the invalid input
                                }
                            }
                            case 5 -> {
                                sc.nextLine(); // Consume newline
                                System.out.print("Enter new account name: ");
                                String newName = sc.nextLine();
                                System.out.print("Enter new account number: ");
                                String newNumber = sc.nextLine();
                                selectedAccount.updateAccountInfo(newName, newNumber);
                            }
                            case 6 -> {
                                System.out.print("Enter new password: ");
                                String newPassword = sc.next();
                                selectedAccount.changePassword(newPassword);
                            }
                            case 7 -> System.out.println("Exiting to main menu.");
                            default -> System.out.println("Invalid choice. Please try again.");
                        }
                    } while (accountChoice != 7);
                }
                case 3 -> System.out.println("Thank you for using our service!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}