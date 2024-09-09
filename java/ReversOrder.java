
import java.util.Scanner;

public class ReversOrder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number = ");
        int x = input.nextInt();
        // int x = 1234;

        System.out.print("The Reverse Number is = ");
        for (int i = 1; i <= 4; i++) {
            int a = x % 10;
            x /= 10;
            System.out.print(a);
        }
    }
}
