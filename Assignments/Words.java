/*	Wesley Johanson
	wjohanso
	talk2wes@gmail.com
	Words.java
	Programming Assignment #1 Part 1

	Status: WRITE THE STATUS HERE BEFORE TURNING IN!!!!!!!
*/




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
import java.util.Arraylist;

public class Words{
	private String str_gen;
	ArrayList<String> arrlst = new ArrayList<String>();
	
	private ArrayList<String>(int num_of_string){
		
	}


	public static void main(String[] args){
		int num_of_string = Math.pow(10,6);
		/*
		if (args.length > 0)
			System.out.println(args[0]);	
		*/
		
	}
}
