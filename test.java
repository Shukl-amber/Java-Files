class InvestmentCalculator {
    public static double calculateFutureValue(double amount, double rate, int years) {
        return amount * Math.pow(1 + rate / 1200, years * 12);
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
            System.out.printf("%d\t%.2f\n", i, calculateFutureValue(amount, rate, i));
        }
    }
}