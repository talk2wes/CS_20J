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

	public static void main(String[] args){
		int num_of_string = 20; //  (int) (Math.pow(10,6));
		int[] str_len = new int[num_of_string];

		ArrayList<String> arrlst = new ArrayList<String>(1000);
		for (int i = 0 ; i < num_of_string ; i++){
			Words new_str = new Words();
			System.out.printf("new string = %s\n", new_str.str);
			String temp_str = new_str.str.toString();
			str_len[i] = temp_str.length();	
			System.out.printf("length: \t%d\n",str_len[i]);
		}
		System.out.printf("Number of strings = %d\n", num_of_string);
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
