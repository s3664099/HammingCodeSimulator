import java.util.Random;
import java.util.Scanner;

// Do the ASCII class
// create a new class to specifically do the hammed code
//		fix up the code reuse.
// move numberHamming to its own class


public class HammerMain {
	
	Scanner entry = new Scanner(System.in);
	
	private int NUM_MIN = 0; //minimum for an 8-bit integer
	private int NUM_MAX = 127; //maximum for an 8-bit integer
	private int BIN_MIN = 0; //minimum length of binary number
	private int BIN_MAX = 11; //maximum length of binary number
	private Random random = new Random(); // sets up the random number method
	
	private boolean correct=false; //value used to determine correct input

	public void run() {
				
		//asks user if they wish to use even or odd parities.
		System.out.println("Do you want (e)ven or (o)dd parity?");
		String parityType = stringQuery("e", "o");
		
		//get number between 0 and 127 from the user	
		int number = intQuery();
			
		//generates a random number between 0 and 11 for the error
		int rnd = random.nextInt(BIN_MAX - BIN_MIN +1)+ BIN_MIN;
			
		//passes the number and parity type through to Hamming Class
		NumberHamming numberHamming = new NumberHamming(number,parityType,rnd);
		numberHamming.numberHamming();
	}
	
	//method to obtain a numerical input. Expected responses passed through
	public int intQuery()
	{
		correct = false; //resets the value to confirm correct entry
		int query;
		
		System.out.println("Please enter a number between "+NUM_MIN+" and "+NUM_MAX);

		do {
			query = entry.nextInt();
			String flush = entry.nextLine(); // flushes out any extraneous characters
			
			if (query >= NUM_MIN && query <= NUM_MAX)
			{
				correct = true;
			} else {
				System.out.println("Please enter a number between "+NUM_MIN+" and "+NUM_MAX);
			}
		} while(!correct);
		
		correct = false; //resets the value
		
		return query;
	}
	
	//method to obtain a string input. Expected responses passed through
	public String stringQuery(String a, String b)
	{
		String query="";
		
		do {
			
			query = entry.nextLine();
			
			//compares entry with expected responses
			if (query.contentEquals(a) || query.contentEquals(b))
			{
				correct = true; 
			} else {
				
				System.out.println("This is not a valid response.");
				System.out.println("Please enter "+a+" or "+b);
			}
			
			
		} while(!correct);
		
		correct=false; //resets value
		
		return query;
		
	}

		/*
		 * user enters a message
		 * message is divided into individual characters
		 * each character is changed into the number represented by the ASCII table
		 * number between 1 and 256 (generating a 16 bit code)
		 * user asked if they want even or odd parity
		 * 
		 * number is then converted into its binary representation
		 * An array of 12 values is set up.
		 * Arrays 0,1,3 and 7 are left blank (these are for the parity bits)
		 * Array is boolean
		 * Second array for the values covered by the parity bits:
		 * 0 - 2,4,6,8,10
		 * 1 - 2,5,6,9,10
		 * 2 - 4,5,6 (0,0)
		 * 3 - 8,9,10 (0,0) 
		 * 
		 * 
		 * Number divided by two. If the mod of the number is 0 then value is false
		 * if mod of number is 1 then value is true.
		 * 
		 * Array is read (skipping parity bits), and false is reported as 0 and true is reported as 1
		 * 
		 * The party bits are then read.
		 * If bit is 1 then 1 is added to the value.
		 * If bit is 0, then it is skipped.
		 * If final result is odd/even then false (0) is placed into the parity bit
		 * If final result is even/odd then true (1) is placed into the parity bit
		 * final number is printed out.
		 * 
		 * Number is sent
		 * A random number is selected and the bit is flipped.
		 * 
		 * Program notes whether even or odd
		 * Each of the parity bits are added up.
		 * If the result is odd/even recorded as true (error)
		 * If the result is even/odd recorded as false (no error)
		 * values placed into a parity checker array
		 * array converted to binary, and then into a number
		 * presents the number of the error
		 * 
		 * flips the bit.
		 * 
		 * 
		 */

}
