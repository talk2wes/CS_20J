/*	Wesley Johanson
	wjohanso
	talk2wes@gmail.com
	Words.java
	Programming Assignment #1 Part 1

	Status: WRITE THE STATUS HERE BEFORE TURNING IN!!!!!!!
*/

/*	


/*	
generates random strings and store them in an ArrayList<String>
number of strings is given by a final int, defined in main
set that int to one million
only output of the program is the average length of the generated strings 
	(format to exactly one decimal place)
define/use a function that returns a random string according to this criteria:

strings always length of one or greater
strings of uppercase letters only
first letter: roughly equal (1/26) of picking any letter A-Z (1/27 after the 
	first)
each letter after that 1/27 chance of ending the string, otherwise a letter 
	(26/27) as above
comment the program (and follow the) project guidelines (Links to an external 
	site.) (Links to an external site.)
program name must be exactly Words.java
*/
import java.util.ArrayList;
import java.util.Random; 
import java.lang.Math;
import java.lang.StringBuilder;

public class Words{
	// Has one member variable that holds the randomly generated string
	StringBuilder str;	
	public Words(){
		str = str_generator();
	}
	
	/*
	public int randNumGen(int min, int max){
		int RAND_MAX = max, RAND_MIN = min;
		Random rng = new Random();
			
		return (Math.abs(rng.nextInt() % (RAND_MAX - RAND_MIN + 1)) + RAND_MIN);
	}
	*/

	StringBuilder str_generator(){
		StringBuilder str = new StringBuilder();
		int a = 0;
		int RAND_MAX = (int) 'Z', RAND_MIN = (int) 'A';
		RandomNum rand = new RandomNum('A','Z');
		Random rng = new Random();
			
		a = Math.abs(rng.nextInt() % (RAND_MAX - RAND_MIN + 1)) + RAND_MIN;
		//a = rand.num;	
		str.append((char) a);	
		RAND_MAX++;
		//while (a != (int) 'Z' + 1){
		//}			
		System.out.printf("value of a = %c\n", a);
		return (str);
	}

	// Main Function 
	public static void main(String[] args){
		int num_of_string = (int) (Math.pow(10,6));
		ArrayList<String> arrlst = new ArrayList<String>(1000);
		for (int i = 0 ; i < 200 ; i++){
			Words new_str = new Words();
			//System.out.printf("%s\n", new_str.str);
		}
		System.out.printf("Number of string = %d\n", num_of_string);
	}
	
}
class RandomNum{
	public int num;
	public RandomNum(int min, int max){
		Random rng = new Random();
		int num;
		num = Math.abs(rng.nextInt() % (max - min + 1)) + min;
	}
}
