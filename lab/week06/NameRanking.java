import java.util.Scanner; 

class NameRanking
{
	private final static int 		NUM_OF_NAMES = 1000;
	private final static int 		NUM_OF_COL = 2;
	
	public static void 		main(String args[])
	{
		final String		boy[][];
		final String		girl[][];
		String				userInput = "";

		boy = file2matrix("boynames.txt");
		girl = file2matrix("girlnames.txt");

	}

	private static String[][]	file2matrix(String filename)
	{
		File nameFile = new File(filename);
		Scanner s = new Scanner(nameFile);
		String[][] nameArray = new String[NUM_OF_NAMES][NUM_OF_COL];
		//read from file
		//if there are any issues return NULL
		return (names);
	}
}