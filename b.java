import java.util.Scanner;
class Account{
    String name;
    String account_n;
    String account_type;
    double bal;

    public Account(String name,String account_n,String account_type,double bal){
        this.name = name;
        this.account_n = account_n;
        this.account_type = account_type;
        this.bal = bal;

    }

    void deposit(double amount){
        bal += amount;
        System.out.println("Deposit successful. Updated balance: "+ bal);
    }

    void displaybal(){
        System.out.println("Current balance: "+ bal);
    }

     public void withdraw(double amount) {
        if (amount > bal) {
            System.out.println("Insufficient balance.");
        } else {
            bal -= amount;
            System.out.println("Withdrawal successful. Updated balance: ₹" + bal);
        }
    }
}

// Savings Account class
class Sav_acct extends Account {
    private double interestRate = 0.05; // 5% annual interest

    public Sav_acct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    public void computeAndDepositInterest(int years) {
        double interest = bal * Math.pow(1 + interestRate, years) - bal;
        bal += interest;
        System.out.println("Interest of ₹" + interest + " deposited. Updated balance: ₹" + bal);
    }
}

// Current Account class
class Cur_acct extends Account {
    private double minimumBalance = 1000.0;
    private double serviceCharge = 100.0;

    public Cur_acct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    
    public void withdraw(double amount) {
        if (amount > bal) {
            System.out.println("Insufficient balance.");
        } else {
            bal -= amount;
            System.out.println("Withdrawal successful. Updated balance: ₹" + bal);
            checkMinimumBalance();
        }
    }

    private void checkMinimumBalance() {
        if (bal < minimumBalance) {
            bal -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of ₹" + serviceCharge + " imposed.");
            System.out.println("Updated balance after penalty: ₹" + bal);
        }
    }

    public void issueChequeBook() {
        System.out.println("Cheque book issued to " + name);
    }
}

// Main Bank class to test functionality
public class b{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        System.out.println("Enter account number:");
        String accNum = sc.nextLine();

        System.out.println("Enter account type (Savings/Current):");
        String type = sc.nextLine();

        System.out.println("Enter initial deposit:");
        double deposit = sc.nextDouble();

        if (type.equalsIgnoreCase("Savings")) {
            Sav_acct sav = new Sav_acct(name, accNum, deposit);
            sav.deposit(500);
            sav.computeAndDepositInterest(2);
            sav.withdraw(300);
            sav.displaybal();
        } else if (type.equalsIgnoreCase("Current")) {
            Cur_acct cur = new Cur_acct(name, accNum, deposit);
            cur.deposit(1000);
            cur.issueChequeBook();
            cur.withdraw(2500);
            cur.displaybal();
        } else {
            System.out.println("Invalid account type.");
        }

        sc.close();
    }
}



    
