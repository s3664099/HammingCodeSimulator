
public class BinaryNumber {

	private int asciiNumber; //int which stores the number to be converted
	private boolean[] binaryCode = new boolean[8]; //array to store the binary values
	
	//Constructor to initialise 8-bit character
	public BinaryNumber(int asciiNumber) {

		this.asciiNumber = asciiNumber;
	}
	
	//method to print out the binary number
	public String toString()
	{
		String binary = ""; //string to store the binary number
		
		//loops through each of the bit positions
		for (int i=binaryCode.length-1; i>=0; i--)
		{
			
			//checks the value of the bit
			if (binaryCode[i]==false)
			{
				//if the boolean is false, then the bit is a 0
				binary+="0";
			} else {
				
				//since there are only two states, if it is not 0, then it is 1
				binary+="1";		
			}
		}		
		//returns the binary number as a string
		return binary;
	}
	
	//method to generate the binary number
	public void binaryGenerator()
	{
		
		int number = asciiNumber; //variable for generating binary number
		
		//loops through each of the bit positions
		for(int i=0; i<binaryCode.length; i++)
		{
			
			//if bit is not a parity bit determines whether it is a 0 or 1
			//the bit is then stored in the particular bit
			if (number%2==1)
			{
				//if the mod 2 of the number is 1, the bit is 1
				binaryCode[i]=true;
			} else {
				
				//if the mod 2 of the number is 0, the bit is 0
				binaryCode[i]=false;
			}
			
			//the number is then divided by two (rounded down)
			//to determine the next bit
			number/=2;
		}
		
	}

	
	//method to return a decimal number from binary
	public int decimalConverter(boolean[] number)
	{
		//number to be returned
		int value=0;
		
		//checks each of the bits
		for (int i=0;i<number.length; i++)
		{
			//if the bit is 1, the value is increase by the 2^ bit position
			if(number[i])
			{
				value+=(int) Math.pow(2, i);
			}
		}
		
		//returns the value
		return value;
	}
	
	public boolean getBitValue(int i)
	{
		// returns the value of the binary number at position i
		return binaryCode[i];
	}
	
	//returns the entire binary number
	public boolean[] getBinaryNumber()
	{
		return binaryCode;
	}
	
	public void setBinary(int i, boolean value)
	{
		// returns the value of the binary number at position i
		binaryCode[i] = value;
	}
	
}
