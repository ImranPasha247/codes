
import java.util.Scanner;

public class SumOfNumber {

    public static void main(String[] args) {
        Scanner cal = new Scanner(System.in);
        int a = cal.nextInt(), sum = 0;
        int i = 1;
        while (i <= 4) {
            int x = a % 10;
            a = a / 10;
            sum = sum + x;
            i++;
        }
        System.out.println(sum);

    }
}
