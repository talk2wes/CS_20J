import java.util.*;
import java.lang.*;

public class IntegerSet
{
	private final static int MAXSETVALUE = 1000;
	private boolean data[];
	public static int getMaxSetValue(){ return MAXSETVALUE; }

	IntegerSet(int ... a)
	{
		data = new boolean[MAXSETVALUE + 1];
		for (int i : a)
			this.insertElement(i);
	}

	public void	deleteElement(int i)
	{
		if (i >= 0 && i <= MAXSETVALUE)
			data[i] = false;
	}

	public void	insertElement(int i)
	{
		if ( i >= 0 && i <= MAXSETVALUE)
			data[i] = true;
	}

	public void	unionOf(IntegerSet seta, IntegerSet setb)
	{
		//protect against segfault and self-reference
		if (seta == null)
			seta = new IntegerSet();
		if (setb == null)
			setb = new IntegerSet();
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

	public void	intersectionOf(IntegerSet seta, IntegerSet setb)
	{
		//protect against segfault and self-reference
		if (seta == null)
			seta = new IntegerSet();
		if (setb == null)
			setb = new IntegerSet();
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

	public String	toString()
	{
		StringBuilder	s = new StringBuilder("");
		boolean		firstElemAppended = false;

		if (data == null)
			return (s.toString());
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
	
	public boolean	equals(IntegerSet other)
	{

		if (other == null)
			other = new IntegerSet();
		for (int i = 0; i <= MAXSETVALUE; i++)
			if (this.data[i] != other.data[i])
				return (false);
		return(true);
	}

	public boolean	hasElement(int i)
	{
		if (i < 0 || i > MAXSETVALUE)
			return false;
		if (data[i] == true)
			return true;
		return false;
	}
}

