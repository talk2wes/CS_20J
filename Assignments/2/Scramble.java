import java.util.Vector;
import java.lang.String;
import java.util.Scanner;

//Here we go again haha


class Scramble
{	

	public static Vector<String> str2vec(Scanner s)
	{
		Vector<String> words = new Vector<String>();
		//Scanner s = new Scanner(System.in);
		String input = "";
		boolean done = false;
		while (!done)
		{
			try {
				input = s.next();
				//System.out.println(input);
				words.add(input);
				System.out.println("Words added = " + words.get(words.size() - 1));
			}
			catch (Exception e){
				done = true;
				s.close();
			}
		}
		return (words);
	}

	public static void main(String[] args) 
	{

		//Read the input from standard input 
		Scanner s = new Scanner(System.in);
		Vector<String> words = new Vector<String>();
		words = str2vec(s);
		System.out.println(words.toString());
		/*
		String input = "";
		boolean done = false;
		while (!done)
		{
			try {
				input = s.next();
				System.out.println(input);
				//System.out.println("Next() = \t" + s.hasNext());
			}
			catch (Exception e){
				done = true;
				s.close();
			}
		}
		System.out.println("LOOP TERMINATED"); 			//TESTING 
		*/
	}
}
