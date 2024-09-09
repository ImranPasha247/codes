import java.util.Scanner;
public class Lucky
{
	public static void main(String args[])
	{
		Scanner cal = new Scanner(System.in);

		int a = cal.nextInt();
		int d1 = a / 1000;          // First digit
		int d2 = (a / 100) % 10;    // Second digit
		int d3 = (a / 10) % 10;     // Third digit
		int d4 = a % 10;			//Fouth digit
		    if((d1 + d2) == (d3 + d4))
			{
				System.out.println("The number " + a + " is a lucky number since " + d1 + " + " + d2 + " = " + d3 + " + "+ d4);
			} 	
			else{
				System.out.println("The number " + a + " is not a lucky number since " + d1 + d2 + "!=" + d3 + d4);
			}
	}
}