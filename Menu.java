import java.util.Scanner;
public class Menu {
    // Reference of Banking and Login
    private Banking bb;
    private Login lg;
    public Menu(Banking b, Login lg) {
        this.bb = b;
        this.lg = lg;
    }
    
    int chosenNum; 

    public void returnToMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("Would you like to continue: (y/n)");
        String response = input.next();
        System.out.println("***********************************************");
        if (response.equals("y")) {
            showMenu();
        } else {
            System.out.println("Thank you for banking with us!");
            
        }
        input.close();
    }
    public void showMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        optionNumber();
        try {
            choice(input.nextInt());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Thank you for banking with us!");
          
        }  
    }

    public void optionNumber() {
            System.out.println("Please Select an option below");
            System.out.println("Press 1 to Deposit Amount");
            System.out.println("Press 2 to Withdraw Amount");
            System.out.println("Press 3 to View Balance");
            System.out.println("Press 4 to show the max/min of an Account's balance:");
            System.out.println("Press 5 to sort and display all balance:");
            System.out.println("Press 6 to search for an account number:");
            System.out.println("Press 7 to transfer balance to another account:");
            System.out.println("Press 8 to login to a different account");
            System.out.println("Press any key to Exit");
            System.out.println(" ");
            System.out.println("Press a key: ");  
    }
    public void choice(int option) throws Exception {
        Scanner input = new Scanner(System.in);
        switch (option) {

            case 1:
                System.out.println("***********************************************");
                System.out.println("Enter the amount to be deposited");
                int amount = input.nextInt();
                bb.deposit(amount);
                lg.updateAccountBalance(bb.getBalance());
                returnToMenu();
                break;

            case 2:
                System.out.println("***********************************************");
                System.out.println("Enter the amount to be Withdrawn");
                int withdrawAmount = input.nextInt();
                bb.withdraw(withdrawAmount);
                lg.updateAccountBalance(bb.getBalance());
                returnToMenu();
                break;

            case 3:
                System.out.println("***********************************************");
                System.out.println("Account Number: " + lg.currentAccount.getAccountNum());
                System.out.println("Total Balance: " + bb.getBalance());
                returnToMenu();
                break;
            case 4:
                System.out.println("***********************************************");
                lg.maxOrmin();
                lg.updateAccountBalance(bb.getBalance());
                returnToMenu();
                break;
            case 5:
                System.out.println("***********************************************");
                lg.sortByBalance(lg.listOfAccounts);
                returnToMenu();
                break;
            
            case 6:
                System.out.println("***********************************************");
                lg.searchAccountNumber();
                lg.updateAccountBalance(bb.getBalance());
                returnToMenu();
                break;

            case 7:
                System.out.println("***********************************************");
                lg.transferBalance();
                returnToMenu();
                break;
                
            case 8:
                System.out.println("***********************************************"); 
                lg.changeAccount();
                break;
                
            default:
                System.out.println("Thank you for banking with us!");

                break;

        }
        input.close();
    }

}
