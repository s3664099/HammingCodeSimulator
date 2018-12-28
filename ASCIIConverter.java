import java.util.Scanner;

public class ASCIIConverter {
	
	private String message;
	Scanner entry = new Scanner(System.in);
	HammerMain ham = new HammerMain();
	
	//selects the parity to be used, and the users
	//enters the message to be hammed.
	public void inputMessage()
	{
		ham.selectParity();
		System.out.println("Please Enter a Message");
		message = entry.next();
	}
	
	//This method splits up the string into individual characters
	//creates the ASCII value of the characters and them hams each of them
	public void SplitUpString()
	{
		//loops through the message
		for (int i=0; i<message.length(); i++)
		{
			//gets the character at the section of the message
			char character = message.charAt(i);
			System.out.println("Hamming character "+character);
			
			//converts the character into its corresponding ASCII value
			int ascii = (int) character;
			System.out.println("The ASCII of "+character+" is "+ascii);

			//passes the number through the hamming simulator
			ham.hamNumber(ascii);
			
			System.out.println("Press Enter to Continue to next number");
			entry.nextLine();
			System.out.println();
			
		}
	}
	
}
