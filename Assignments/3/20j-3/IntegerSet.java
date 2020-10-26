// partial definition for Integer set Class
// add member functions but don't add any 
// additional member variables
// this goes in your IntegerSet.java file:

import java.util.*;
import java.lang.*;


public class IntegerSet{
	private final static int MAXSETVALUE = 1000;
	private boolean data[];
	public static int getMaxSetValue(){ return MAXSETVALUE; }
	// other member functions here
	IntegerSet(int ... a)
	{
		data = new boolean[MAXSETVALUE + 1];
		for (int i : a)
		{
			//TESTING
			System.out.println("Insert element: " + i);
			this.insertElement(i);
		}

	}

	public void deleteElement(int i)
	{
		if (i >= 0 && i <= MAXSETVALUE && data != null)
			data[i] = false;
	}

	public void insertElement(int i)
	{
		if ( i >= 0 && i <= MAXSETVALUE && data != null)
			data[i] = true;
	}


	public static void main(String args[])
	{
		
    		Random rng = new Random();
    		rng.setSeed(0);
    		System.out.println("Hello world");
		IntegerSet set1 = new IntegerSet(3 , 5 );
		IntegerSet set2 = new IntegerSet( 89, 8, -4);
		set1.toString();
		set2.toString();
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder("");
		boolean firstElementPrinted = false;

		if (data == null)
			return (s.toString());
		s.append("{");
		for (int i = 0; i <= MAXSETVALUE; i++)
		{
			if (data[i] == true)
			{
				if (firstElementPrinted)
					s.append(", ");
				s.append(i);
				firstElementPrinted = true;
			}
		}
		s.append("}");

		//TESTING
		System.out.println("testing toString:" + s.toString());
		return (s.toString());
	}

    /*
    IntegerSet is1, is2, is3;
    is1 = new IntegerSet();
    is2 = new IntegerSet(1,2,5);
    is3 = new IntegerSet();
    
    System.out.println("CS20j Integer Sets");
    System.out.println("<put your name and email here>");
    is1.insertElement(2);    is1.insertElement(4);
    is1.insertElement(2);    is1.insertElement(3);
    is1.insertElement(5);    is1.insertElement(7);
    is1.deleteElement(3);    is1.deleteElement(7);
    is1.deleteElement(9);    
    
    for(int i=0; i < (is3.getMaxSetValue()*0.10); i++)
	is3.insertElement( (int) Math.round(rng.nextDouble()*is3.getMaxSetValue()));
    System.out.print("is3 (random): ");
    System.out.println (is3.toString());
    
    is3.unionOf(is1,is2);
    System.out.print("is3 (union): ");
    System.out.println(is3.toString());
    
    is3.intersectionOf(is1,is2);
    System.out.print("is3 (intersection): ");
    System.out.println(is3.toString());
    
    if (is3.equals(is3))
	System.out.println("1: is3 == is3");
    else
	System.out.println("1: is3 != is3");
    
    if (is3.equals(is2))
	System.out.println("2: is3 == is2");
    else
	System.out.println("2: is3 != is2");
    
    if (is1.hasElement(5) ){
	System.out.println("3: is1 has 5");
    } else {
	System.out.println("3: is1 does not have 5");
    }
    if (is1.hasElement(7) ){
	System.out.println("4: is1 has 7");
    } else {
	System.out.println("4: is1 does not have 7");
    }
    */
}

