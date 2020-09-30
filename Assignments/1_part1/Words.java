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
	 * This will store the randomly generated string output from the
	 * strGenerator function.
	 */
	StringBuilder str;	
	
	/**
	 * This stores a randomly generated string into private member variable
	 * str.
	 */
	public Words(){
		str = strGenerator();
	}
	
	/**
	 * This outputs a randomly generated string of capital letters, with
	 * minimum length of 1. All letters have equal pseudo-random chance of
	 * being selected (1/26). Once the first letter is choosen, there is a
	 * probability (p=1/27) that a letter or end of string will be choosen.
	 * 
	 * @return	str	Randomly generated string
	 */
	StringBuilder strGenerator(){
		RandomNum num = new RandomNum();
		int a = num.randomize('A', 'Z');
		StringBuilder str = new StringBuilder();
		str.append((char) a);
		while (a != 'Z' + 1){
			a = num.randomize('A', 'Z' + 1);
			if (a != 'Z' + 1){
				str.append((char) a);
			}
		}
		return (str);
	}

	/**
	 * This calculated the average length of all of the strings stored in 
	 * the int array named nums.
	 * 
	 * @param 	nums	int array that stores the length of each string
	 * @return		the average length of all string lengths
	 */
	double average(int[] nums){
		double total = 0;
		for (int i = 0; i < nums.length; i++){
			total += nums[i];
		}
		return ( total / nums.length);
	}

	/**
	 * Given the parameter NUM_STRING, the loop generates the specified
	 * number of strings, stores the length of each string into strLen and
	 * then calls the method average to find the average length of all the
	 * strings.
	 */
	public static void main(String[] args){
		final int numOfString = (int) (Math.pow(10,6));
		int[] strLen = new int[numOfString];

		ArrayList<String> arrlst = new ArrayList<String>(numOfString);
		for (int i = 0 ; i < numOfString ; i++){
			Words newStr = new Words();
			arrlst.add(newStr.str.toString());
			strLen[i] = (arrlst.get(i)).length();
		}
		Words mean = new Words();
		double average = mean.average(strLen);
		System.out.printf("average string length = %.1f\n", average);
	}
}

class RandomNum{
	/**
	 * This is the randomly generated number that will be returned.
	 */
	public int num;

	/**
	 * This generates a random number within the range: [min, max].
	 * (inclusive of the boundaries)
	 * 
	 * @param	min	the beginning of the range
	 * @param	max	the end of the range
	 * @return	num	the randomly generated number
	 */
	int randomize(int min, int max){
		Random rng = new Random();
		int num;
		num = Math.abs(rng.nextInt() % (max - min + 1)) + min;
		return (num);
	}
}
