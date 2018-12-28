
public class HammedBinary {
	
	private boolean[] binaryCode = new boolean[11]; //array to store the binary values
	private boolean[] errorCode = new boolean[4]; //array to store the binary values for a potential error
	private int[] PARITY = new int[] {0,1,3,7}; //location of the parity bits
	private int[][] PARITYCOVERAGE = new int[][]{ //values covered by the parity bits
		{2,4,6,8,10},
		{2,5,6,9,10},
		{4,5,6,0,0},
		{8,9,10,0,0},
	};
	
	private String parityType; //stores whether we are using even/odd parity
	private BinaryNumber binaryNumber;
	
	public HammedBinary(String parityType, BinaryNumber binaryNumber)
	{
		this.parityType = parityType;
		this.binaryNumber = binaryNumber;
		createHammed(); //initiates parity bits
	}
	
	//method to initiate parity bits
	//places bits from the binary number into a binary
	//number that includes the parity bits
	private void createHammed()
	{
		int j=0;
		boolean skip = false;
		
		
		for (int i=0;i<binaryCode.length; i++)
		{	
			//checks to see if the bit is a parity bit
			for (int k=0; k<PARITY.length;k++)
			{
				//if it is a parity bit, it skips
				if (i==PARITY[k])
				{
					skip=true;
				} 

			}
			
			if (skip)
			{
				skip=false;
			} else {
				
				//if it is not a parity bit, it places the value into the bit position
				binaryCode[i]=binaryNumber.getBitValue(j);
				j++;
			}

		}
	}
	
	//method to add the parity bits
	public void addParity()
	{
		int checker=0; //variable to determine how many 1's in the number
		int row;
			
		//loops through the array identifying parity coverage
		for (row=0;row<PARITYCOVERAGE.length; row++)
		{
				
			//calls the method to count the number of parity bits
			checker = counter(row, false); 
			
			int compare = 0; //the default value (odd parity)
				
			//checks whether it is even or odd parity
			if (parityType.contentEquals("e"))
			{
				//value for even parity
				compare=1;
			}
							
			//checks to see if the result is even or odd
			if (checker%2 ==compare) 
			{
				//sets parity bit to 1, if parity is even/odd
				binaryCode[PARITY[row]]=true;
			} else {
						
				//otherwise the bit is 0
				binaryCode[PARITY[row]]=false;
			}
						
		}
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
	
	//Method checks for an error in the code
	public int errorChecker()
	{
		boolean error = false;
		int checker=0; //variable to determine how many 1's in the number
		int row;
		
		//loops through the array identifying parity coverage
		for (row=0;row<PARITYCOVERAGE.length; row++)
		{
			
			//calls the method to count the number of parity bits
			checker = counter(row, true); 
	
			int compare = 0; //the default value (odd parity)
			
			//checks whether it is even or odd parity
			if (parityType.contentEquals("e"))
			{
				//value for even parity
				compare=1;
			}

			//checks to see if the result is even or odd
			if (checker%2 ==compare) 
			{
				error=true;
				
				//sets parity bit to 1, if parity is even/odd
				errorCode[row]=true;
			} else {
					
				//otherwise the bit is 0
				errorCode[row]=false;
			}
		}
		
		//if an error has been detected
		if (error)
		{
			
			//passes the binary code to the covertor
			//and returns the location of the error
			return (binaryNumber.decimalConverter(errorCode)-1);
				
		}
		
		//if there is no error, returns a negative value
		return -1;
					
	}
		
	//method counts the number of 1s in area covered by the parity bit
	public int counter(int row, boolean inclParity)
	{
		int checker = 0;
			
		//checks to see whether we are including the parity bit in this calculation
		if (inclParity)
		{
			//checks value of parity bit. If one adds to checker
			if(binaryCode[PARITY[row]])
			{
				checker++;
			}
		}
			
		for (int col=0;col<PARITYCOVERAGE[row].length; col++)
		{	
			//checks value of bit location
			//if value is true, then adds one to the checker
			if (PARITYCOVERAGE[row][col]==0)
			{
				continue;
			} else if (binaryCode[PARITYCOVERAGE[row][col]])
		{
					
				checker++;
			}

		}
			
		return checker;
	}
	
	//once the error is corrected, puts results back into binary number
	public void resetBinary()
	{
		int k=0;
		
		for (int i=0;i<binaryCode.length;i++)
		{
			for (int j=0; j<PARITY.length; j++)
			{
				//if the bit is a parity bit, it is skipped
				if (i==PARITY[j])
				{
					continue;
				} else {
					
					//if it is not a parity bit, the value is sent to the binary number
					binaryNumber.setBinary(k, binaryCode[i]);
					k++;
				}
			}
		}
		
	}
	
	//Method flips the bit
	public void flipper(int bit)
	{
		if (binaryCode[bit])
		{
			//if value is true, it becomes false
			binaryCode[bit]=false;

		} else {
			
			//if value is false, it becomes true
			binaryCode[bit]=true;
		}
	}

}
