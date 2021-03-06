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
		return ( total / strLen.length);
	}

	public static int randNum(int min, int max){
		Random rng = new Random();
		return (Math.abs(rng.nextInt() % (max - min + 1)) + min);
	}

	/**
	 * Given the const numOfString, the loop generates the specified
	 * number of strings, stores the length of each string into strLen and
	 * then calls the method average to find the average length of all the
	 * strings.
	 */
	public static void main(String[] args){
		final int numOfString = (int) (Math.pow(10,6));
		int[] strLen = new int[numOfString];
		ArrayList<String> arrlst = new ArrayList<String>(numOfString);

		for (int i = 0 ; i < numOfString ; i++){
			arrlst.add(i, Words.strGenerator());
			strLen[i] = (arrlst.get(i)).length();
		}
		System.out.printf("average string length = %.1f\n",
					Words.average(strLen));

	}
}

