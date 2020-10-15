import java.util.Scanner; 

class NameRanking
{
	private final static int 	NUM_OF_NAMES = 1000;
	private final static int 	NUM_OF_COL = 2;
	
	public static void 			main(String args[])
	{
		final String		boy[][];
		final String		girl[][];
		String				userInput = "";

		boy = file2matrix("boynames.txt");
		girl = file2matrix("girlnames.txt");

	}

	private boolean 			checkInput(String str)
	{
		boolean 				spaceFound = false;
		int 					letters = 0;
		int 					numbers = 0;

		for (int i = 0; i < str.length; i++)
		{

		}
	}
	private static String[][]	file2matrix(String filename)
	{
		File 					nameFile = new File(filename);
		Scanner 				s = new Scanner(nameFile);
		String[][] 				nameArray = new String[NUM_OF_NAMES][NUM_OF_COL];
		String 					tempStr;
		
		int 					i = 0;

		while (cin >> tempStr && i < NUM_OF_NAMES)
		{
			
		}

		//read from file
		//Break up string into two strings delimited by the space
		//check if the input is valid (i.e. name on the left, num on the right)
		//store the data into the array 
		//loop until termination 
		//if there are any issues return NULL
		return (names);
	}
}