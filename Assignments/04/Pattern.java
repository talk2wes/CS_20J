/* Wesley Johanson	Pengo: wjohanso		Talk2wes@gmail.com
 * Filename: Pattern.java
 * Assignment 4: Pattern Matching
 */

import java.lang.*;
import java.util.*;
import java.io.*;

 class Pattern
 {
	final int MAX_DIF = 7;	//Min str diff to be considered a match

	public static void main (String[] args)
	{
		System.out.println("Hello cruel COVID world");
		final String FILENAME = "patterns.txt";	
		Scanner file;
		Scanner userInput = new Scanner(System.in);
		String[] strArr = new String[32];
		
		//Check if the file opened had any exceptions
		try
		{
			file = new Scanner(new File(FILENAME));
			//Store the file into an array
			for (int i = 0; file.hasNextLine(); i++)
			{
				strArr[i] = file.nextLine();
				System.out.println("strArr:" + strArr[i]);
			}
			file.close();
		}catch(Exception e)
		{
			System.out.println("File reading error");
		}
		
		//test that I actually stored the file into the array
		for (int i = 0; i < 32; i++)
			System.out.println(strArr[i]);
		
		//run the program
		try
		{
			while (userInput.hasNextLine())
			{
				String input = userInput.nextLine();
				System.err.println("userInput:" + input); //testing
				//int index = findIndex(strArr, input);
			}
		}catch(Exception e) {}
	}	

	public int	findIndex(String[] strArr, String input)
	{
		int smallestDiff = 10000;
		int smallestInd = -1;		//Sentinel Value

		//determine if the input is of the correct speicifications
		if (input.length() != 32)
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

	public int findDiff(String str, String input)
	{
		int diff = 0;
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) != str.charAt(i))
				diff++;
		return diff;
	}
		



 }
