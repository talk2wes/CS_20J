import java.util.Vector;
import java.lang.String;
import java.util.Scanner;

class Scramble
{	
	public static Vector<String> str2vec(Scanner s, String delimiter)
	{
		Vector<String> words = new Vector<String>();
		String input = "";
		s.useDelimiter(delimiter);
		boolean done = false;
		while (!done)
		{
			try {
				input = s.next();
				words.add(input);
			}
			catch (Exception e){
				//Catched the exception as a result of EOF input
				done = true;
			}
		}
		return (words);
	}

	//Each vector is split into columns by the delimiter and put into a row
	//corresponding to the index of the original vector.
	public static Vector<Vector<String>> vec2matrix
		(Vector<String> lines, String delimiter)
	{
		Vector<Vector<String>> mat = new Vector<Vector<String>>();
		String tempStr = "";
		String[] words;

		//Split each line into a new column
		for(int row = 0; row < lines.size() ; row++)
		{
			//Split each string into an int array using the delimiter
			tempStr = lines.get(row);			
			words = tempStr.split(delimiter);
			System.out.println(tempStr);		//Testing
			//Add each word as an element of the vector 
			Vector<String> splitStr = new Vector<String>();
			for (int col = 0; col < words.length; col++)
				splitStr.add(words[col]);	
			//Add each vector into the matix, corresponding to row
			mat.add(splitStr);
		}
		return (mat);
	}
	
	//Find the length of the word excluding all not alphabet characters
	public static int wordLen(String str)
	{
		int letters = 0;

		for (int i = 0; i < str.length(); i++)
		{
			//System.out.println(str + "\ti: " + i + "\tchar: " + str.charAt(i));
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				letters++;
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				letters++;
		}
		return (letters);
	}

	public static void scramble(Vector<Vector<String>> mat)
	{
		for (int row = 0; row < mat.size(); row++)
		{
			for (int col = 0; col < mat.get(row).size(); col++)
			{
				//Find length of string, excluding punctuation
				System.out.println(mat.get(row).get(col) + "\tlen: " + wordLen(mat.get(row).get(col)));
				//Given length define the range of indicies to scramble
				//Scramble the letters within the range 
			}
		}

	}

	public static void mat2stdOut(Vector<Vector<String>> mat)
	{
		String delimiter = " ";
		for (int row = 0; row < mat.size(); row++)
		{
			for (int col = 0; col < mat.get(row).size(); col++)
			{
				if (col > 0)
					System.out.print(delimiter);
				System.out.print(mat.get(row).get(col));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) 
	{
		//Read the input from standard input 
		Scanner s = new Scanner(System.in);
		Vector<String> lines = new Vector<String>();
		Vector<Vector<String>> mat = new Vector<Vector<String>>();
		
		System.out.println("\nstr2vec\n");
		lines = str2vec(s, "\n");
		mat = vec2matrix(lines, " ");
		scramble(mat);
		System.out.println("mat = " + mat.toString() + "\n");
		System.out.println("\nmat2stdout\n");
		mat2stdOut(mat);
	}
}
