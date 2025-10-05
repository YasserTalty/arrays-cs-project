package samplearrays;

public class BankAccount{
    String name;
    double currentBalance;
    double[] transactions=new double[1000];
    int transactionCount=0;

    public BankAccount(String name,int startingBalance){
        this.name=name;
        this.currentBalance=startingBalance;
        transactions[transactionCount++]=startingBalance;
    }

    public void deposit(double amount){
        if(amount>0){
            currentBalance+=amount;
            transactions[transactionCount++]=amount;
            System.out.println(name+" deposited $"+amount+". New balance: $"+currentBalance);
        }else{
            System.out.println("Error: Invalid deposit amount $"+amount);
        }
    }

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Error: Invalid withdrawal amount $"+amount);
        }else if(amount>currentBalance){
            System.out.println("Error: Insufficient funds for withdrawal of $"+amount);
        }else{
            currentBalance-=amount;
            transactions[transactionCount++]=-amount;
            System.out.println(name+" withdrew $"+amount+". New balance: $"+currentBalance);
        }
    }

    public void displayTransactions(){
        System.out.println("\nTransactions for "+name+":");
        for(int i=0;i<transactionCount;i++){
            double t=transactions[i];
            if(t>=0){
                System.out.println("Deposit: $"+t);
            }else{
                System.out.println("Withdrawal: $"+(-t));
            }
        }
    }

    public void displayBalance(){
        System.out.println(name+"'s current balance: $"+currentBalance);
    }

    public static void main(String[] args){
        BankAccount john=new BankAccount("John Doe",100);

        // ----- DO NOT CHANGE -----
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();
        // ----- DO NOT CHANGE -----
    }
}
