import java.util.Random;
import java.util.Vector;
import java.lang.String;
import java.util.Scanner;
import java.lang.StringBuilder;

class Scramble
{	
	public static void main(String[] args) 
	{
		//Read the input from standard input 
		Scanner s = new Scanner(System.in);
		Vector<String> lines = new Vector<String>();
		Vector<Vector<String>> mat = new Vector<Vector<String>>();
		
		boolean done = false;
		while (!done)
		{
			System.out.println("MAIN");
			lines = str2vec(s, "\n");
			mat = vec2matrix(lines, " ");
			scramble(mat);
			mat2stdOut(mat);
			if (!s.hasNext())
				done = true;
		}
	}

	public static Vector<String> str2vec(Scanner s, String delimiter)
	{
		Vector<String> words = new Vector<String>();
		String input = "";
		s.useDelimiter(delimiter);
		boolean done = false;
		int i = 0;		//testing!!!
		while (!done)
		{
			try {
				
				System.out.println("\ni: " + i + " IN: hasNextLine: " + s.hasNextLine() + 
						"\thasNext: " + s.hasNext() );
				input = s.next();
				System.out.println(".next() returned");

				System.out.println("i: " + i + " OUT: hasNextLine: " + s.hasNextLine() + 
						"\thasNext: " + s.hasNext() );
				i++;

				/*
				if (!s.hasNextLine())
					System.out.println("XXX");
				*/
				//System.out.println("hasNextLine" + s.hasNextLine());
				words.add(input);
			}
			catch (Exception e){
				//System.out.println("EOF reached");
				//Catched the exception as a result of EOF input
				done = true;
			}
		}
		return (words);
	}

	//Each vector is split into columns by the delimiter and put into a row
	//corresponding to the index of the original vector.
	public static Vector<Vector<String>> vec2matrix(
			Vector<String> lines, String delimiter)
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
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				letters++;
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				letters++;
		}
		return (letters);
	}


	public static String swapChar(String word, int i, int j)
	{
		StringBuilder word_sb = new StringBuilder(word);

		word_sb.replace(i, i + 1, word.substring(j, j+1));
		word_sb.replace(j, j + 1, word.substring(i, i+1));
		return(word_sb.toString());
	}

	//Shuffles characters around, shuffles letters within the range
	//Inclusive of the boundaries 'start' and 'end'
	public static String wordShuffle(String word, int start, int end)
	{
		Random rnd = new Random();
		int swapInd = -1;
		// i is the index of the char to be swapped
		// the shuffle algorithm should use the range 1->i-1 to find a swap with
		// location i.
		for (int i = end; i > start; i--)
		{
			//make a random number within the range [start, i)
			swapInd = rnd.nextInt(i - start) + start;
			//swap that index with the terminal character
			word = swapChar(word, swapInd, i);
		}
		return (word);
	}

	public static void scramble(Vector<Vector<String>> mat)
	{
		int len = 0;

		for (int row = 0; row < mat.size(); row++)
		{
			for (int col = 0; col < mat.get(row).size(); col++)
			{
				//Find length of string, excluding punctuation
				len = wordLen(mat.get(row).get(col));
				if (len > 3)
				{
					mat.get(row).set(col, 
						wordShuffle(mat.get(row).get(col), 1, 
						wordLen(mat.get(row).get(col)) - 2)); //one for index difference, one for 
					//Given length define the range of indicies to scramble
					//Scramble the letters within the range 
				}
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


}
