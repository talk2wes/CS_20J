/* Wesley Johanson	Pengo: wjohanso		Talk2wes@gmail.com
 * Filename: Pattern.java
 * Assignment 4: Pattern Matching
 */

import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * The program reads a file into a string array, then outputs the index of the 
 * array most simliar to the user inputted string. outputs "error" if the 
 * difference of the strings is greater than 'MAX_DIF'.
 *
 * Status: working and tested. Compiles and runs.
 * @author Wesley Johanson, talk2wes@gmail.com
 * @since java 14.0.2 2020-07-14
 */

 class Pattern
 {
	final static int MAX_DIF = 7;	//Max str diff to be considered a match
	final static int FILE_LENGTH = 32;

	public static void main (String[] args)
	{
		final String FILENAME = "patterns.txt";	
		Scanner file;
		Scanner userInput = new Scanner(System.in);
		String[] strArr = new String[FILE_LENGTH];
		
		//Check if the file opened had any exceptions
		try
		{
			file = new Scanner(new File(FILENAME));
			//Store the file into an array
			for (int i = 0; file.hasNextLine(); i++)
				strArr[i] = file.nextLine();
			file.close();
		}catch(Exception e)
		{
			System.err.println("File reading error");
		}

		//run the program
		try
		{
			while (userInput.hasNextLine())
			{
				String input = userInput.nextLine();
				int index = findIndex(strArr, input);
				
				if (input.equals(""))
					System.out.print("");
				else if (index == -1)
					System.out.println("error");
				else
					System.out.println(index);
			}
		}catch(Exception e) {}
	}	

	/**
	 * Finds the index of the most simlar string in the array to the user
	 * input. -1 is returned as a sentinel value for differences greater
	 * than 'MAX_DIF'
	 */
	public static int	findIndex(String[] strArr, String input)
	{
		int smallestDiff = 10000;	
		int smallestInd = -1;		//Sentinel Value

		//determine if the input is of the correct speicifications
		if (input.length() != FILE_LENGTH)
			return -1;
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) < '0' || input.charAt(i) > '1')
				return -1;

		//find the most similar string
		for (int i = 0; i < strArr.length; i++)
		{
			int diff = findDiff(strArr[i], input);
			if (diff < smallestDiff)
			{
				smallestInd = i;
				smallestDiff = diff;
			}
		}
		
		//Check if difference is below the exclusion threshold
		if (smallestDiff <= MAX_DIF)
			return smallestInd;
		else
			return -1;
	}
	
	/**
	 * Finds the number of characters that are differ in two different
	 * strings.
	 */
	public static int findDiff(String str, String input)
	{
		int diff = 0;
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) != str.charAt(i))
				diff++;
		return diff;
	}
}
