public class Accounts {
    // Instance variable
    public int accountNumber, accountPassword, accountBalance;

    // default constructor
    public Accounts(){
        
    }
    // Parameterized Constructor
    public Accounts(int acNumber, int acPassword, int balance){
        this.accountNumber = acNumber;
        this.accountPassword = acPassword;
        this.accountBalance = balance;
    }
    public Accounts(int balance){

        this.accountBalance = balance;
    }
    
    // setters
    public void setAccountNum(int acNumber){
        this.accountNumber = acNumber;

    }
    public void setAccountPass(int acPass) {
        this.accountPassword = acPass;
    }
    public void setInitialbalance(int x) {
        this.accountBalance = x;
    }
    // To update balance in an ArrayList
    public void updateBalance(int x) {
        this.accountBalance = x;
    }
    // Display all info
    public void showAccount() {
        System.out.println("***********************************************");
        System.out.println("Registered Account");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Password: " + this.accountPassword);
        System.out.println("Initial Balance: " + this.accountBalance);
    }

    // Display Account and Password
    public void showAccAndBalance() {
        System.out.println("***********************************************");
        System.out.println("Registered Account");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Balance: " + this.accountBalance);
    }
    // getters
    public int getAccountNum() {
        return this.accountNumber;
    }
    public int getAccountPassword(){
        return this.accountPassword;

    }
    public int getAccountBalance(){
        return this.accountBalance;
    }

}
