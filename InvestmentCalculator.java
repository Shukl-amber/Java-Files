import java.util.*;

class InvestmentCalculator {
    public static double value(double amount, double rate, int years) {
        for (int i = 0; i < years; i++)
            amount = amount * Math.pow((1 + (rate / 1200)), 12);
        return amount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        double amount = sc.nextDouble();
        System.out.print("Enter interest rate (%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        System.out.println("Years\tFuture Value");
        for (int i = 1; i <= years; i++) {
            System.out.printf("%d\t%.2f\n", i, value(amount, rate, i));
        }

        sc.close();
    }
}