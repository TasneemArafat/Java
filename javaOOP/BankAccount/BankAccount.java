import java.util.Random;
public class BankAccount{
    private String accountNumber = "";
    private double checkBalance = 0;
    private double savingsBalance = 0;
    private static int numberOfAccounts = 0;
    private static double totalAmountOfMoney = 0;

    private String randomAccountNo(){
        Random r = new Random();
        String temp = "";
        for(int i=0; i<10;i++){
            temp += r.nextInt(0+9);
        }
        return temp;
    }

    public BankAccount(){
        this.accountNumber = randomAccountNo();
        numberOfAccounts++;
    }

    public String getBankAccountNo(){
        return this.accountNumber;
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public double getCheckBalance(){
        return this.checkBalance;
    }

    public double getSavingskBalance(){
        return this.savingsBalance;
    }

    public void getBalance(){
        System.out.println("Checking Balance: "+this.getCheckBalance() +" $");
        System.out.println("Savings Balance: "+this.getSavingskBalance() +" $");
    }

    public void deposit(String accountName, double money){
        if (accountName == "CheckAccount"){
            this.checkBalance += money;
            totalAmountOfMoney+= money;
        }
        else if(accountName == "SavingsAccount"){
            this.savingsBalance += money;
            totalAmountOfMoney+= money;
        }
        else{
            System.out.println("Account name incorrect, please choose either CheckAccount OR SavingsAccount !");
        }
    }

    public void withdraw(String accountName, double money){
        if (accountName == "CheckAccount"){
            if(this.checkBalance < money){
                System.out.println("Not enough money to withdrwa from this account!");
            }
            else{
            this.checkBalance -= money;
            totalAmountOfMoney-= money;
            }
        }
        else if(accountName == "SavingsAccount"){
            if(this.savingsBalance < money){
                System.out.println("Not enough money to withdrwa from this account!");
            }
            else{
            this.savingsBalance -= money;
            totalAmountOfMoney-= money;
            }
        }
        else{
            System.out.println("Account name incorrect, please choose either CheckAccount OR SavingsAccount !");
        }

    }

    public static double gettotalAmount(){
        return totalAmountOfMoney;
    }
}