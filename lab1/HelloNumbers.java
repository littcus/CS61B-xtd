public class HelloNumbers {
    public static void main(String[] args) {
        int x = 1;
        int sum = 0;
        while (x <= 10) {
            System.out.println(sum + " ");
            sum = sum + x;
            x = x + 1;
        }
    }
}
