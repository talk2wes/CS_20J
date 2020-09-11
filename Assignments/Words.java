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
		StringBuilder str = new StringBuilder();
	
		/*
		int a = 0;
		int RAND_MAX = (int) 'Z', RAND_MIN = (int) 'A';
		Random rng = new Random();
		a = Math.abs(rng.nextInt() % (RAND_MAX - RAND_MIN + 1)) + RAND_MIN;
		*/
		//Generate a random number between ascii values of A and Z
		RandomNum num = new RandomNum();
		int a = num.Randomize('A', 'Z');

		str.append((char) a);	
		System.out.printf("value of a = %c\n", a);
		return (str);
	}

	public static void main(String[] args){
		int num_of_string = (int) (Math.pow(10,6));
		ArrayList<String> arrlst = new ArrayList<String>(1000);
		for (int i = 0 ; i < 200 ; i++){
			Words new_str = new Words();
		}
		System.out.printf("Number of string = %d\n", num_of_string);
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
