
public class NumberHamming {
	
	private int number;
	private int randomNumber;
	private String parityType;
	
	public NumberHamming(int number, String parityType, int randomNumber)
	{
		this.number = number;
		this.parityType = parityType;
		this.randomNumber = randomNumber;
	}
	
	public void numberHamming()
	{
	
		//Creates new 8 bit binary number
		BinaryNumber binaryNumber = new BinaryNumber(number);
		
		System.out.println("The number "+number+" will now be converted to binary");
		//the number is converted into binary
		binaryNumber.binaryGenerator();
		
		System.out.println("The binary of "+number+" is "+binaryNumber.toString()+"\n");
		
		//Creates a hamming object for the binary number
		HammedBinary hammedBinary = new HammedBinary(parityType, binaryNumber);
		
		System.out.println("The parity bits will now be added to the binary numbers");
		
		//adds the parity bits to the binary number
		hammedBinary.addParity();
		
		System.out.println("The hammed binary of "+number+" is "+hammedBinary.toString()+"\n");
		
		System.out.println("An error will now be added to a random bit, namely the bit will be flipped");
		
		//flips the bit
		hammedBinary.flipper(randomNumber);
		
		System.out.println("The hammed binary of "+number+" with an error is "
				+hammedBinary.toString()+"\n");
		
		//checks for an error in the hammed binary number
		int errorLoc = hammedBinary.errorChecker();
		
		if (errorLoc<0)
		{
			System.out.println("There is no error");
		} else {
			System.out.println("There is an error at bit "+errorLoc);
			System.out.println("The error will now be fixed");
		}
		
		//flips the errored bit
		hammedBinary.flipper(errorLoc);
		
		System.out.println("The hammed binary is "+hammedBinary.toString()+"\n");
		
		System.out.println("The parity bits will now be removed and the number will be "
				+ "converted back into decimal");
		
		System.out.println("The original number is "+
				binaryNumber.decimalConverter(binaryNumber.getBinaryNumber()));
		
	}

}
