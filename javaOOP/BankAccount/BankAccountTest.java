public class BankAccountTest{
    public static void main(String[] args){
        BankAccount first = new BankAccount();
        BankAccount second = new BankAccount();
        System.out.println(first.getBankAccountNo());
        System.out.println(second.getBankAccountNo());
        System.out.println(BankAccount.getNumberOfAccounts());
        first.deposit("CheckAccount",1000);
        second.deposit("SavingsAccount",1000);
        first.withdraw("CheckAccount",50);
        second.withdraw("CheckAccount",33);
        first.getBalance();
        second.getBalance();
        System.out.println(BankAccount.gettotalAmount());
    }
}