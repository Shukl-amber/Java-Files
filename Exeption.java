public class Exeption {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: ArrayIndexOutOfBoundsException");
        }
    }
}
