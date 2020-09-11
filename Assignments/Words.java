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
		RandomNum num = new RandomNum();
		int a = num.Randomize('A', 'Z');
		StringBuilder str = new StringBuilder();
		str.append((char) a);
		while (a != 'Z' + 1){
			a = num.Randomize('A', 'Z' + 1);
			if (a != 'Z' + 1){
				str.append((char) a);
			}
		}
		return (str);
	}
	double Average(int[] nums){
		double total = 0;
		for (int i = 0; i < nums.length; i++){
			total += nums[i];
		}
		return ( total / nums.length);
	}

	public static void main(String[] args){
		final int num_of_string =  (int) (Math.pow(10,6));
		int[] str_len = new int[num_of_string];

		ArrayList<String> arrlst = new ArrayList<String>(1000);
		for (int i = 0 ; i < num_of_string ; i++){
			Words new_str = new Words();
			String temp_str = new_str.str.toString();
			str_len[i] = temp_str.length();	
		}
		Words mean = new Words();
		double average = mean.Average(str_len);
		System.out.printf("Average string length = %.1f\n", average);
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
