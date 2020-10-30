// Wesley Johanson	Pengo: wjohanso		Talk2wes@gmail.com
// Filename: IntegerSet.java
// Assignment 3: IntegerSet

import java.util.*;
import java.lang.*;

/**
 * The Class IntegerSet will store a mathematical set of numbers from 0 to 
 * MAXSETVALUE. The Class provides common set operations such as union and 
 * intersections.
 */
public class IntegerSet
{
	private final static int MAXSETVALUE = 1000; //largest set value allowed
	private boolean data[]; 			//data to hold set
	public static int getMaxSetValue(){ return MAXSETVALUE; }

	//Default Constructor, creates an empty set
	IntegerSet(int ... a)
	{
		data = new boolean[MAXSETVALUE + 1];
		for (int i : a)
			this.insertElement(i);
	}

	//Removes an element from the set
	public void	deleteElement(int i)
	{
		if (i >= 0 && i <= MAXSETVALUE)
			data[i] = false;
	}

	//Adds an element to the set
	public void	insertElement(int i)
	{
		if ( i >= 0 && i <= MAXSETVALUE)
			data[i] = true;
	}

	//Finds the union set of seta & setb. Assigns the set to the object 
	//the method was envoked on. 
	public void	unionOf(IntegerSet seta, IntegerSet setb)
	{
		//Treat null objects as empty sets, as description states.
		if (seta == null)
			seta = new IntegerSet();
		if (setb == null)
			setb = new IntegerSet();
		//Do nothing if both parameters are the same as 'this' object
		if (data == seta.data && data == setb.data)
			return;
		for (int i = 0; i <= MAXSETVALUE; i++)
		{
			if (seta.data[i] == true || setb.data[i] == true)
				this.data[i] = true;
			else
				this.data[i] = false;
		}
	}

	//Finds the intersection set of seta & setb. Assigns the set to the
	//object the method was envoked on. 
	public void	intersectionOf(IntegerSet seta, IntegerSet setb)
	{
		//Treat null objects as empty sets, as description states.
		if (seta == null)
			seta = new IntegerSet();
		if (setb == null)
			setb = new IntegerSet();
		//Do nothing if both parameters are the same as 'this' object
		if (data == seta.data && data == setb.data)
			return;
		for (int i = 0; i <= MAXSETVALUE; i++)
		{
			if (seta.data[i] == true && setb.data[i] == true)
				this.data[i] = true;
			else
				this.data[i] = false;
		}
	}

	//Returns the set using standard curly brace notation as a string
	// e.g. {x1, x2, ..., xn}
	public String	toString()
	{
		StringBuilder	s = new StringBuilder("");
		boolean		firstElemAppended = false;

		s.append("{");
		for (int i = 0; i <= MAXSETVALUE; i++)
		{
			if (data[i] == true)
			{
				if (firstElemAppended)
					s.append(", ");
				s.append(i);
				firstElemAppended = true;
			}
		}
		s.append("}");
		return (s.toString());
	}
	
	//Returns true if set is equivalent to the object envoked on
	public boolean	equals(IntegerSet other)
	{
		if (other == null)
			other = new IntegerSet();
		for (int i = 0; i <= MAXSETVALUE; i++)
			if (this.data[i] != other.data[i])
				return (false);
		return(true);
	}

	//Returns true if parameter is an element of the set
	public boolean	hasElement(int i)
	{
		if (i < 0 || i > MAXSETVALUE)
			return false;
		if (data[i] == true)
			return true;
		return false;
	}
}
