/*	Wesley Johanson
	wjohanso
	talk2wes@gmail.com
	Words.java
	Programming Assignment #1 Part 1

	Status: WRITE THE STATUS HERE BEFORE TURNING IN!!!!!!!
*/

import java.util.ArrayList;
import java.util.Random; 
import java.lang.Math;
import java.lang.StringBuilder;

public class Words{
	StringBuilder str;	
	public Words(){
		str = str_generator();
	}

	StringBuilder str_generator(){
	
		//Generate a random number between ascii values of A and Z
		RandomNum num = new RandomNum();
		int a = num.Randomize('A', 'Z');
		//Make that the start of the string
		StringBuilder str = new StringBuilder();
		str.append((char) a);
		//System.out.printf("The first letter is : '%s' from '%c'\n", str.toString(), a);
		//System.out.printf("Str_generator: \t\t\t%c", a);
		while (a != 'Z' + 1){
			a = num.Randomize('A', 'Z' + 1);
			if (a != 'Z' + 1){
				str.append((char) a);
				//System.out.printf("%c", (char) a);
			}
		}
		//System.out.printf("\nStringBuilder return: \t%s\n\n", str.toString());
		return (str);
	}
	/*	
	int Average(int[] nums){
		int total = 0;
		for (int i = 0; i < nums.length; i++){
			total += nums[i];
			System.out.printf("Total = %d\n",total);
		}
		return ( total / nums.length);
	}
	*/	
	double Average(int[] nums){
		double total = 0;
		for (int i = 0; i < nums.length; i++){
			total += nums[i];
			//System.out.printf("Total = %d\n",total);
		}
		
		return ( total / nums.length);
	}

	public static void main(String[] args){
		int num_of_string =  (int) (Math.pow(10,6));
		int[] str_len = new int[num_of_string];

		ArrayList<String> arrlst = new ArrayList<String>(1000);
		for (int i = 0 ; i < num_of_string ; i++){
			Words new_str = new Words();
			//System.out.printf("new string = %s\n", new_str.str);
			String temp_str = new_str.str.toString();
			str_len[i] = temp_str.length();	
			//System.out.printf("length: \t%d\n",str_len[i]);
		}
		/*
		Words mean = new Words();
		int average = mean.Average(str_len);
		System.out.printf("Average = %d\n", average);
		*/
		Words mean = new Words();
		double average = mean.Average(str_len);
		//System.out.printf("Average = %.2f\n", average);

		System.out.printf("Number of strings = %d \n", num_of_string);
		//System.out.printf("Average length: %d\n", new_str.Average(str_len));
	}
	
}

class RandomNum{
	public int num;
	int Randomize(int min, int max){
		Random rng = new Random();
		int num;
		num = Math.abs(rng.nextInt() % (max - min + 1)) + min;
		return (num);
	}
}
