/**
 * CS20J-1-115304 Programming Assignment #1 Part 1
 * Filename: Words.java
 * This program is designed to generate a series of strings
 * specified by NUM_STRING and stores them into an Array List named
 * arrlst. The length of each string in arrlst is stored into strLen. 
 * The average string length is then calculated using the method average
 * of the Words class. The average length is then output to std-out.
 * Working/tested. Code Compile, works as expected.
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
	 * This calculated the average length of all of the strings stored in 
	 * the int array named strLen.
	 * 
	 * @param 	strLen	int array that stores the length of each string
	 * @return		the average length of all string lengths
	 */
	public static double average(int[] strLen){
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
		double		average = Words.average(strLen);
		double		rieSum = 0;
		
		for (int i = 0 ; i < strLen.length ; i++)
			rieSum += Math.pow(strLen[i] - average, 2);
		return (Math.pow(rieSum / strLen.length , 1/2));
	}

	/**
	 * Given the const NUM_OF_STRING, the loop generates the specified
	 * number of strings, stores the length of each string into strLen and
	 * then calls the method average to find the average length of all the
	 * strings.
	 */
	public static void main(String[] args){
		final int 	NUM_OF_STRING = (int) (Math.pow(10,6));
		final int	MAX_USER_INPUT = 79242939;
		int		userInput = 0;
		
		//DETERMINE HOW MANY STRINGS TO PROCESS 
		if (args.length == 1 
		&& Integer.parseInt(args[0]) <= MAX_USER_INPUT
		&& Integer.parseInt(args[0]) > 0)
			userInput = Integer.parseInt(args[0]);
		else
			userInput = NUM_OF_STRING;
		//exceptions are thrown for large +/- numbers	
		int[]		strLen = new int[userInput];
		ArrayList<String> arrlst = new ArrayList<String>(userInput);
		for (int i = 0 ; i < userInput ; i++){
			arrlst.add(i, Words.strGenerator());
			strLen[i] = (arrlst.get(i)).length();
		}
		System.out.printf("CS 20J Program #1 random strings\n"
				+ "");
		System.out.printf("%.1f mean length\n",
					Words.average(strLen));
		System.out.printf("%.1f std dev\n", Words.stdDev(strLen));
	}
}
