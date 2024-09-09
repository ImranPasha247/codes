
import java.util.Scanner;

public class Table {

    public static void main(String args[]) {
        Scanner table = new Scanner(System.in);
        int x = table.nextInt();
        for (int i = 1; i <= x; i++) {
            System.out.println("The table of " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " × " + j + " = " + (i * j));
            }
        }
    }
}
