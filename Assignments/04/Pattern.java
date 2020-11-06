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
		Scanner userInput = new Scanner(System.in);
		String[] strArr = new String[FILE_LENGTH];
		
		int i = 0;
		strArr[i++] = "00000000000000000000000000000000";
		strArr[i++] = "01010101010101010101010101010101";
		strArr[i++] = "00110011001100110011001100110011";
		strArr[i++] = "01100110011001100110011001100110";
		strArr[i++] = "00001111000011110000111100001111";
		strArr[i++] = "01011010010110100101101001011010";
		strArr[i++] = "00111100001111000011110000111100";
		strArr[i++] = "01101001011010010110100101101001";
		strArr[i++] = "00000000111111110000000011111111";
		strArr[i++] = "01010101101010100101010110101010";
		strArr[i++] = "00110011110011000011001111001100";
		strArr[i++] = "01100110100110010110011010011001";
		strArr[i++] = "00001111111100000000111111110000";
		strArr[i++] = "01011010101001010101101010100101";
		strArr[i++] = "00111100110000110011110011000011";
		strArr[i++] = "01101001100101100110100110010110";
		strArr[i++] = "00000000000000001111111111111111";
		strArr[i++] = "01010101010101011010101010101010";
		strArr[i++] = "00110011001100111100110011001100";
		strArr[i++] = "01100110011001101001100110011001";
		strArr[i++] = "00001111000011111111000011110000";
		strArr[i++] = "01011010010110101010010110100101";
		strArr[i++] = "00111100001111001100001111000011";
		strArr[i++] = "01101001011110011001011010010110";
		strArr[i++] = "00000000111111111111111100000000";
		strArr[i++] = "01010101101010101010101001010101";
		strArr[i++] = "00110011110011001100110000110011";
		strArr[i++] = "01100110100110011001100101100110";
		strArr[i++] = "00001111111100001111000000001111";
		strArr[i++] = "01011010101001011010010101011010";
		strArr[i++] = "00111100110000111100001100111100";
		strArr[i++] = "01101001100101101001011001101001";

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
