class Bankaccount {
    int AccNo, Aadhar;
    String Name;
    double ROI, Balance;

    public Bankaccount() {}

    public void openaccount(int AccNo, int Aadhar, String Name, double ROI, double Balance) {
        this.AccNo = AccNo;
        this.Aadhar = Aadhar;
        this.Name = Name;
        this.ROI = ROI;
        this.Balance = Balance;
    }

    public void deposit(double amount) {
        Balance += amount;
        System.out.println("Amount deposited successfully");
    }

    public void closeaccount() {
        String name=Name;
        Balance = 0;
        AccNo = 0;
        Aadhar = 0;
        Name = "NULL";
        ROI = 0;
        Balance = 0;
        System.out.println("Account closed successfully for " + name);
    }

    public void updateintrest() {
        Balance += (Balance)* (ROI/100);
        System.out.println("Intrest updated successfully");
    }

    public void display() {
        System.out.println("\nAccount Number: " + AccNo);
        System.out.println("Aadhar Number: " + Aadhar);
        System.out.println("Name: " + Name);
        System.out.println("Rate of Intrest: " + ROI + "%");
        System.out.println("Balance: " + Balance + "\n");
    }

}

interface Debitable {
    void withdraw(double amount);
}

class FixedDeposit extends Bankaccount implements Debitable {
    int lockin, accage;

    public FixedDeposit(int Aadhar, String Name, double Balance, int lockin, int accage) {
        super();
        int accno = 55;
        Double ROI;
        for (int i = 0; i < 3; i++) {
            accno *= 10;
            accno += (int) (Math.random() * 10);
        }
        if (lockin>=1 && lockin<=2)
            ROI = 6.0;
        else if (lockin>2 && lockin<=5) 
            ROI = 6.5;
        else if (lockin<=0){
            System.out.println("Invalid lockin period");
            ROI=0.0;
        }else
            ROI = 7.0;

        super.openaccount(accno,Aadhar,Name,ROI,Balance);
        this.lockin = lockin;
        this.accage = accage;
        System.out.println("Fixed Deposit account opened successfully");
    }

    @Override
    public void withdraw(double amount) {
        if (Balance >= amount) {
            Balance -= amount;
            System.out.println("Amount withdrawn successfully Current Balance: " + Balance);
        } else
            System.out.println("Insufficient balance");
    }

    @Override
    public void closeaccount() {
        if (accage < lockin) {
            System.out.println("Account age less than lock in period 5% deducted: " + (Balance * 0.05));
            Balance = 0;
            return;
        }
        super.closeaccount();
    }

    public void updateintrest(double NewROI) {
        Balance+= (Balance)*(NewROI/100)*lockin;
        System.out.println("Intrest updated successfully");
    }

    public void display() {
        super.display();
        System.out.println("Lockin period: " + lockin + " years");
        System.out.println("Account age: " + accage + " years\n");
    }

}

class Savingsaccount extends Bankaccount implements Debitable{

    @Override
    public void withdraw(double amount) {
        if (Balance >= amount) {
            Balance -= amount;
            System.out.println("Amount withdrawn successfully Current Balance: " + Balance);
        } else
            System.out.println("Insufficient balance");
    }

    public Savingsaccount(int Aadhar, String Name, double Balance) {
        super();
        int accno = 11;
        for (int i = 0; i < 3; i++) {
            accno *= 10;
            accno += (int) (Math.random() * 10);
        }
        super.openaccount(accno, Aadhar, Name, 4.0, Balance);
        System.out.println("Savings account opened successfully");
    }

    public void display() {
        super.display();
    }

}

public class Bankaccountmain{
    public static void main(String[] args) {
        Bankaccount B1 = new Bankaccount();
        B1.openaccount(00001, 694202469, "Amber", 4, 1000);
        B1.display();
        B1.deposit(1000);
        B1.display();
        B1.closeaccount();
        B1.display();

        FixedDeposit FD1 = new FixedDeposit(123456789, "Pranav", 1000, 2, 1);
        FD1.display();
        FD1.withdraw(100);
        FD1.display();
        FD1.closeaccount();
        FD1.display();

        Savingsaccount S1 = new Savingsaccount(123456789, "Anurag", 10000);
        S1.display();
        S1.withdraw(2000);
        S1.display();
        S1.closeaccount();
        S1.display();
    }
}