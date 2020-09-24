/**
 * CS20J-1-115304 Programming Assignment #1 Part 1
 * Filename: Words.java
 * This program is designed to generate a series of strings
 * specified by NUM_STRING and stores them into an Array List named
 * arrlst. The length of each string in arrlst is stored into strLen. 
 * The mean string length is then calculated using the method mean
 * of the Words class. The mean length is then output to std-out.
 * Working/tested. Code Compile, works as expected.
 * 
 * NOTE: Should the program output stats and "generate" data when
 * the user inputs 0 as the number of strings to generate? 
 * right now the program is designed to ignore that input and use the default
 *
 * @Author Wesley Johanson, talk2wes@gmail.com, Pengo: wjohanso
 * @Version: 1.0
 * @Since Fall 2020 Semester. Java 14.0.2 2020-07-14
 */
import java.util.ArrayList;
import java.util.Random; 
import java.lang.Math;
import java.lang.StringBuilder;
import java.util.Scanner;

public class Words{
	/**
	 * This outputs a randomly generated string of capital letters, with
	 * minimum length of 1. All letters have equal pseudo-random chance of
	 * being selected (1/26). Once the first letter is choosen, there is a
	 * probability (p=1/27) that a letter or end of string will be choosen.
	 * 
	 * @return	str	Randomly generated string
	 */
	public static String strGenerator(){
		StringBuilder str = new StringBuilder();
		int letter = Words.randNum('A', 'Z');
		while (letter != 'Z' + 1){
			str.append((char) letter);
			letter = Words.randNum('A', 'Z' + 1);
		}
		return (str.toString());
	}

	/**
	 * This calculated the mean length of all of the strings stored in 
	 * the int array named strLen.
	 * 
	 * @param 	strLen	int array that stores the length of each string
	 * @return		the mean length of all string lengths
	 */
	public static double mean(int[] strLen){
		double total = 0;
		for (int i = 0; i < strLen.length; i++)
			total += strLen[i];
		return (total / strLen.length);
	}

	public static int randNum(int min, int max){
		Random rng = new Random();
		return (Math.abs(rng.nextInt() % (max - min + 1)) + min);
	}
	
	public static double stdDev(int strLen[]){
		double		mean = Words.mean(strLen);
		double		rieSum = 0;
	
		for (int i = 0 ; i < strLen.length ; i++)
			rieSum += Math.pow(strLen[i] - mean, 2);
		rieSum /= strLen.length;
		return (Math.sqrt(rieSum));
	}

	/**
	 * Given the const NUM_OF_STRING, the loop generates the specified
	 * number of strings, stores the length of each string into strLen and
	 * then calls the method mean to find the mean length of all the
	 * strings.
	 */
	public static void main(String[] args){
		final int 	NUM_OF_STRING = (int) (Math.pow(10,6));
		final int	MAX_USER_INPUT = 79242939;
		int		userInput = 0;
		final String	HEADER;
		HEADER = "CS 20J Program #1: Random Strings   "
			+ "Wesley Johanson Talk2wes@gmail.com\n"
			+ "Generates N strings (10^6 w/o parameter) and stats "
			+ "about the dataset\n";
	
		//DETERMINE HOW MANY STRINGS TO PROCESS 
		try
		{
			if (args.length == 1 
				&& Integer.parseInt(args[0]) <= MAX_USER_INPUT
				&& Integer.parseInt(args[0]) > 0)
				userInput = Integer.parseInt(args[0]);
			else
				userInput = NUM_OF_STRING;
		}
		catch(Exception e)
		{
			userInput = NUM_OF_STRING;
		}

		//declare the array and arraylist
		int[]		strLen = new int[userInput];
		ArrayList<String> arrlst = new ArrayList<String>(userInput);
		//Gen strings and store them	
		for (int i = 0 ; i < userInput ; i++){
			arrlst.add(i, Words.strGenerator());
			strLen[i] = (arrlst.get(i)).length();
		}
		System.out.printf(HEADER);
		System.out.printf("%d random strings generated\n"
				+ "first string: %s\n"
				+ "last string: %s\n"
				+ "%.1f mean length\n"
				+ "%.1f std dev\n",
				userInput, 
				arrlst.get(0),
				arrlst.get(userInput - 1),
				Words.mean(strLen),
				Words.stdDev(strLen));
	}
}
