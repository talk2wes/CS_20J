import java.util.Random;
import java.util.Vector;
import java.lang.String;
import java.util.Scanner;
import java.lang.StringBuilder;

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


	public static String swapChar(String word, int i, int j)
	{
		StringBuilder word_sb = new StringBuilder(word);
		System.out.println("A: word: \"" + word + "\" word_sb: \"" + word_sb.toString()
			+ "\"\t'" + word.charAt(i) + "' '" + word.charAt(j) + "'");
		
		word_sb.replace(i, i + 1, word.substring(j, j+1));
		
		//System.out.println("swapChar, swapped string: " + word_sb.toString());
		System.out.println("B: word: \"" + word + "\" word_sb: \"" + word_sb.toString()
			+ "\"\t'" + word.charAt(i) + "' '" + word.charAt(j) + "'");
		
		word_sb.replace(j, j + 1, word.substring(i, i+1));
		
		System.out.println("C: word: \"" + word + "\" word_sb: \"" + word_sb.toString()
			+ "\"\t'" + word.charAt(i) + "' '" + word.charAt(j) + "'");
		
		System.out.println("D: word: \"" + word + "\" word_sb: \"" + word_sb.toString()
			+ "\"\t'" + word.charAt(i) + "' '" + word.charAt(j) + "'");
		//System.out.println("swapChar, swapped string: " + word_sb.toString());
		return(word_sb.toString());
	}

	//Shuffles characters around, shuffles letters within the range
	//Inclusive of the boundaries 'start' and 'end'
	public static void wordShuffle(String word, int start, int end)
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
			System.out.println("swapInd range: [" + start
				+ ", " + (i-1) + "]" + " i = " + i);
			//swap that index with the terminal character
			System.out.println("random int Choosen: " + swapInd);
			System.out.println(" PRE swapped string: " + word);
			word = swapChar(word, swapInd, i);
			System.out.println("POST swapped string: " + word);
			

			//System.out.println("");
			


		}
	}

	public static void scramble(Vector<Vector<String>> mat)
	{
		int len = 0;

		for (int row = 0; row < mat.size(); row++)
		{
			for (int col = 0; col < mat.get(row).size(); col++)
			{
				//Find length of string, excluding punctuation
				System.out.println("\n\n");
				System.out.println(mat.get(row).get(col) + "\tlen: " + wordLen(mat.get(row).get(col)));
				len = wordLen(mat.get(row).get(col));
				if (len > 3)
				{
					System.out.println("SCRAMBLE THIS WORD");
					wordShuffle(mat.get(row).get(col), 1, 
						wordLen(mat.get(row).get(col)) - 2); //one for index difference, one for 
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
