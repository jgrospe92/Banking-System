
import java.util.Scanner;
import java.util.ArrayList;

public class Login {

    // Account Array
    ArrayList<Accounts> listOfAccounts = new ArrayList<>();
    {
        listOfAccounts.add(new Accounts(1234, 9999, 500));
    }

    // New Account variables for creating ArrayList
    // Variables for adding multiple accounts
    int newAccountNum;
    int newAccountPass;
    int newInitialBalance;
    int indexBalance;

    // Use this for current balance
    int currentBalance = listOfAccounts.get(indexBalance).getAccountBalance();

    // Current account
    Accounts currentAccount;

    // Variables needed to log in
    int input_number, input_password;


    // Passing a reference of the current balance to Banking
    Banking bank = new Banking(this, currentBalance);
  
    // Method to take user input
    public void acceptInput() throws Exception {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("***********************************************");
            System.out.print("Enter your account number: ");
            input_number = input.nextInt();
            System.out.print("Enter your account password: ");
            input_password = input.nextInt();

        } catch (java.util.InputMismatchException e) {
            String msg = "Invalid Input, Try again!";
            System.out.println(msg);
            input.nextLine(); // discard input so user can try again
            acceptInput();
            
        }

    }

    // New Account
    public void newAccount() throws Exception {
        Scanner input = new Scanner(System.in);
        boolean response;

        do {
            System.out.println("***********************************************");
            System.out.println("Would You like to create a new Account:(y/n)");
            response = (input.next().charAt(0) == 'y') ? true : false;
            try {
                if (response) {
                    System.out.println("***********************************************");
                    System.out.println("Enter new Account Number:");
                    newAccountNum = input.nextInt();
                    System.out.println("Enter new Password Number:");
                    newAccountPass = input.nextInt();
                    System.out.println("Initial Balance: ");
                    newInitialBalance = input.nextInt();
    
                    listOfAccounts.add(new Accounts(newAccountNum, newAccountPass, newInitialBalance));
                    System.out.println("Created Account successfully");
                    
                }

            } catch (java.util.InputMismatchException e) {
                String msg = "Invalid Input, Try again!";
                System.out.println(msg);
                input.nextLine(); // discard input so user can try again
                newAccount();
            }
            
        } while (response);
    }

    // Verify if the user input is matched
    public void verify() throws Exception {
        boolean noActiveAccount = false;

        for (int i = 0; i < listOfAccounts.size(); i++) {

            if (input_number == listOfAccounts.get(i).getAccountNum()) {

                noActiveAccount = true;
                currentBalance = listOfAccounts.get(i).getAccountBalance();
                indexBalance = listOfAccounts.indexOf(listOfAccounts.get(i));
                currentAccount = listOfAccounts.get(i);
                bank.setBalance(currentBalance);
                
                if (input_password == listOfAccounts.get(i).getAccountPassword()) {
                    System.out.println("<>Login successful<>");
                    System.out.println(" ");
                    System.out.println("Your current Balance is:  " + bank.getBalance() + " Rupees");
                    System.out.println("***********************************************");
                    Menu menu = new Menu(bank, this);
                    menu.showMenu();
                    break;

                } else if (input_password != listOfAccounts.get(i).getAccountPassword()) {
                    System.out.println("Incorrect login credentials");
                    String invalid_acntNumber = "Invalid Password";
                    InvalidBankTransaction loginFailed = new InvalidBankTransaction(invalid_acntNumber);
                    System.out.println(loginFailed.getMessage());
                    throw loginFailed;
                }

            } else {
                System.out.println("Searching Account...");
                noActiveAccount = false;
                //continue;
            }
            
        }
        if (!noActiveAccount) {
            System.out.println("Account does not exist...\nTry again!");
            acceptInput();
            verify();
        }
    }

    // max balance of the Array
    public void maxOrmin() {
        Scanner input = new Scanner(System.in);
        int choiceNum;
        Accounts max = new Accounts();
        Accounts min = new Accounts();
        max = listOfAccounts.get(0);
        min = listOfAccounts.get(0);
        System.out.println("Press 1 for Max\nPress 2 for Min");
        choiceNum = input.nextInt();

        if (choiceNum == 1) {
            
            for (int i = 1; i < listOfAccounts.size(); i++) {
                if (listOfAccounts.get(i).getAccountBalance() > max.getAccountBalance()) {
                    max = listOfAccounts.get(i);
                }
            }
            System.out.println("Account with Max Balance: ");
            max.showAccount();
          
        } else if (choiceNum == 2) {

            for (int i = 1; i < listOfAccounts.size(); i++) {
                if (listOfAccounts.get(i).getAccountBalance() < min.getAccountBalance()) {
                    min = listOfAccounts.get(i);
                }

            }
            System.out.println("Account with Min Balance: ");
            min.showAccount();
        
        }
    }

    // update current balance in the ArrayList
    public void updateAccountBalance(int amount){
        listOfAccounts.get(indexBalance).setInitialbalance(amount);

    }

    public void sortByBalance(ArrayList<Accounts> x){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to sort it by: ");
        System.out.println("1. Ascending\n2. Descending");
        System.out.println("Enter input: ");
        int pickAnumber = input.nextInt();
        ArrayList<Accounts> tempList = new ArrayList<>(x);
        Accounts tempAcc = new Accounts();
        
        if (pickAnumber == 1) {

            for(int i = 0; i < tempList.size() - 1; i++) {
                int counter = i;

                for(int j = i + 1; j < tempList.size(); j++){

                    
                    if (tempList.get(counter).getAccountBalance() > tempList.get(j).getAccountBalance()) {
                        counter = j;
                    }
                   
                }
                tempAcc = tempList.get(i);
                tempList.set(i, tempList.get(counter));
                tempList.set(counter, tempAcc);
               
            }
            System.out.println(" "); 
            System.out.println("Sorting in Ascending order..."); 
            for (int k = 0; k < tempList.size(); k++) {
                tempList.get(k).showAccAndBalance();;
            }

        }
        else if (pickAnumber == 2 ) {

            for(int i = 0; i < tempList.size() - 1; i++) {
                int counter = i;

                for(int j = i + 1; j < tempList.size(); j++){

                    
                    if (tempList.get(counter).getAccountBalance() < tempList.get(j).getAccountBalance()) {
                        counter = j;
                    }
                   
                }
                tempAcc = tempList.get(i);
                tempList.set(i, tempList.get(counter));
                tempList.set(counter, tempAcc);
               
            }
            System.out.println(" "); 
            System.out.println("Sorting in Descending order..."); 
            for (int k = 0; k < tempList.size(); k++) {
                tempList.get(k).showAccAndBalance();;
            }
        }
        
    }

    public void searchAccountNumber(){
        Scanner input = new Scanner(System.in);
        int searchNum;
        boolean foundIt = false;
        System.out.println("Enter the Account number you want to find: ");
        searchNum = input.nextInt();
        Accounts tempAccounts = new Accounts();

        for(Accounts acc: listOfAccounts){
            System.out.println("Searching...");
            if (searchNum == acc.accountNumber) {
                tempAccounts = acc;
                foundIt = true;
                    
            }
        }
        if(foundIt) {
            System.out.println(" ");
            System.out.println("Found it!");
            tempAccounts.showAccAndBalance();;
              
        } else {
            System.out.println(" ");
            System.out.println("Account does not exist!");
        }
       
       
    }

    // Transfer account balance
    public void transferBalance(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the account number you wishes to transfer: ");
        int transferNumber = input.nextInt();
        int tempIndex = 0;
        int inputTransferBalance;
        int balanceToTransfer;
        Accounts transferTempAcc = new Accounts();
        boolean accountFound = false;

        for(Accounts acc: listOfAccounts){
            System.out.println("Searching...");
            if (transferNumber == acc.getAccountNum()) {
                
                tempIndex = listOfAccounts.indexOf(acc);
                transferTempAcc = acc;
                accountFound = true;
                    
            }
          
        }
        if (accountFound) {
            System.out.println("Enter the amount to transfer: ");
            inputTransferBalance = input.nextInt();

            if (inputTransferBalance < currentAccount.getAccountBalance()) {

                balanceToTransfer = (inputTransferBalance + listOfAccounts.get(tempIndex).getAccountBalance());
                // update the balance list;
                listOfAccounts.get(tempIndex).setInitialbalance(balanceToTransfer);
                System.out.println("The amount: " + inputTransferBalance + " is successfully transferred");
    
                int minusCurrentBalance = (currentAccount.getAccountBalance() - inputTransferBalance);
                currentAccount.setInitialbalance(minusCurrentBalance);
    
                System.out.println("Your new balance is: " + currentAccount.getAccountBalance());

            } else {
                System.out.println("Insufficient fund ");
                System.out.println("Your current balance is: " + currentAccount.getAccountBalance());
            }

        } else {
            System.out.println("Account does not exist\nTry again! ");
        }
     
    }
    // Login into different account Method
    public void changeAccount() throws Exception{
        System.out.println("Enter the account and password you wishes to login: ");
        acceptInput();
        verify();
    }
}
