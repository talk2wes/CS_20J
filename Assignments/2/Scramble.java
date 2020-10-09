/**
 * CS20J-1-115304 Programming Assignment #2
 * Filename: Scramble.java
 * This program takes input from STDIN, scrambles the characters in each word 
 * and outputs the scrambled words to STDOUT. First and last characters 
 * are not scrambled. Newlines and whitespace info is conserved.
 * 
 * Working/tested. Code Compile, works as expected.
 * 
 * @Author Wesley Johanson, talk2wes@gmail.com, Pengo: wjohanso
 * @Version: 1.0
 * @Since Fall 2020 Semester. Java 14.0.2 
 */
import java.util.Random;
import java.util.Vector;
import java.lang.String;
import java.util.Scanner;
import java.lang.StringBuilder;

class Scramble
{	
	public static void 					main(String[] args) 
	{
		Scanner 						s = new Scanner(System.in);
		Vector<String> 					lines = new Vector<String>();
		Vector<Vector<String>> 			mat = new Vector<Vector<String>>();
		
		while (s.hasNext())
		{
			lines = str2vec(s, "\n");
			mat = vec2matrix(lines, " ");
			scramble(mat);
			mat2stdOut(mat);
		}
	}

	/**
	 * Generates a vector of lines from a scanner object, delimited by 
	 * the parameter given. (newline in this context)
	 *
	 * @param s 			Scanner to get a line of text
	 * @param delimiter 	delimiter to break up string into vector elements
	 * @return 				A vector of words
	 */
	public static Vector<String> 		str2vec(Scanner s, String delimiter)
	{
		Vector<String> 					words = new Vector<String>();
		String 							input = "";
		
		s.useDelimiter(delimiter);
		input = s.next();
		words.add(input);
		return (words);
	}

	/**
	 * Generates a matrix of words from a vector containing lines. 
	 * 
	 * @param 		lines		A vector that contains multiple lines of text
	 * @param 		delimiter 	Delimiter to break up each vector into words
	 * @return 					A matrix of words
	 */
	public static Vector<Vector<String>>	vec2matrix( Vector<String> lines,
														String delimiter)
	{
		Vector<Vector<String>> 			mat = new Vector<Vector<String>>();
		String 							tempStr = "";
		String[] 						words;
		Vector<String> 					splitStr = new Vector<String>();

		for(int row = 0; row < lines.size() ; row++)
		{
			tempStr = lines.get(row);			
			words = tempStr.split(delimiter);
			splitStr = new Vector<String>();

			for (int col = 0; col < words.length; col++)
				splitStr.add(words[col]);	
			mat.add(splitStr);
		}
		return (mat);
	}

	/**
	 * Find the length of a word in a string. Only counts alphabetical 
	 * characters.
	 * 
	 * @param 		str 		string that contains a word
	 * @return 					the number of alphabet characters found
	 */
	public static int 					wordLen(String str)
	{
		int 							letters = 0;

		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				letters++;
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				letters++;
		}
		return (letters);
	}

	/**
	 * Swaps the characters in a string at the indicies provided: i, j
	 * 
	 * @param 	word 		A string that constains a word
	 * @param 	i 			index to be swapped with index j
	 * @param 	j 			index to be swapped with index i
	 * @return 				The string with swapped characters
	 */
	public static String 				swapChar(String word, int i, int j)
	{
		StringBuilder 					word_sb = new StringBuilder(word);

		word_sb.replace(i, i + 1, word.substring(j, j+1));
		word_sb.replace(j, j + 1, word.substring(i, i+1));
		return(word_sb.toString());
	}

	/**
	 * Shuffles the characters in a string within the boundaries provided.
	 * Inclusive of the boundaries provided.
	 * 
	 * @param 		word 		the string containing a word
	 * @param 		start 		The start of the swapping range
	 * @param 		stop 		The end of the swapping range
	 * @return 					A word (string) with shuffled characters
	 */
	public static String 				wordShuffle(String word, int start, 
													int end)
	{
		Random 							rnd = new Random();
		int 							swapInd = -1;
		
		for (int i = end; i > start; i--)
		{
			swapInd = rnd.nextInt(i - start + 1) + start;
			word = swapChar(word, swapInd, i);
		}
		return (word);
	}

	/**
	 * Scrambles all of the words in the matrix given.
	 * 
	 * @param 		mat 	A matrix of words
	 */
	public static void 					scramble(Vector<Vector<String>> mat)
	{
		int len = 0;

		for (int row = 0; row < mat.size(); row++)
		{
			for (int col = 0; col < mat.get(row).size(); col++)
			{
				len = wordLen(mat.get(row).get(col));
				if (len > 3)
				{
					mat.get(row).set(col, 
						wordShuffle(mat.get(row).get(col), 1, 
						wordLen(mat.get(row).get(col)) - 2));
				}
			}
		}
	}

	/**
	 * Outputs all of the words in the matrix given.
	 *
	 * @param 		mat 	A matrix of words
	 */
	public static void 					mat2stdOut(Vector<Vector<String>> mat)
	{
		String 							delimiter = " ";

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
