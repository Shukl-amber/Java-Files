public class Exeption {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[4]=10/10;
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Error");
        } catch (ArithmeticException e){
            System.out.println("Arithmatic Error");
        } finally {
            System.out.println("Final Block");
        }
    }
}
