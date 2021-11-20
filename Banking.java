import java.util.Scanner;

public class Banking {

     // Initial Amount or balance
     public int balance_amount;

    // Reference Login
    private Login ll;
    public Banking(Login ll, int b) {
        this.ll = ll;
        this.balance_amount = b;
        
    }
    // Scanner input
    Scanner input = new Scanner(System.in);

    // Constructor
    Banking() {

    }
    
     
    // Use to access Login Method
    public void initiate() throws Exception {
        Login userLogin = new Login();
        userLogin.newAccount();
        userLogin.acceptInput();
        userLogin.verify();

    }

    // Get balance method
    public int getBalance() {
        return ll.currentAccount.getAccountBalance();
    }

    // Set balance
    public void setBalance(int b) {
        this.balance_amount = b;
    }
    public void upDateBalance(){
        Accounts acc = new Accounts();
        acc.updateBalance(balance_amount);
    }

    // Deposit and update balance
    public void deposit(int amount) {
        InvalidBankTransaction negativeAmount;
        negativeAmount = new InvalidBankTransaction("Invalid Amount");
    
        if (amount < 0) {
            System.out.println(negativeAmount.getMessage());
            System.out.println("Deposit value cannot be negative");

        } else {
            //this.balance_amount += amount;
            int newBalance = ll.currentAccount.getAccountBalance() + amount;
            System.out.println(amount + " deposited Successfully");
            System.out.println("Total Balance: " + newBalance);
            ll.updateAccountBalance(newBalance);

        }
    }

    // Withdraw and update balance
    public void withdraw(int amount) {
        int totalDiff;

        if (ll.currentAccount.getAccountBalance() >= amount) {
            if (amount > 0) {
                totalDiff = ll.currentAccount.getAccountBalance() - amount;
                System.out.println("Please collect your " + amount + " Rupees");
                System.out.println("Total Balance: " + totalDiff);
                ll.updateAccountBalance(totalDiff);

            } else {
                 totalDiff = ll.currentAccount.getAccountBalance() + amount;
                System.out.println("Please collect your " + amount + " Rupees");
                System.out.println("Total Balance: " + totalDiff);
                ll.updateAccountBalance(totalDiff);
            }

        } else {
            System.out.println("Insufficient fund");
            System.out.println("Total Balance: " + ll.currentAccount.getAccountBalance());
        }

    }

    
}
