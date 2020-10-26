class q3
{
	public static double (double d, double m1, double m2)
	{
		double force = 0;
		force = G * m1 * m2 / (d * d);

		return (force);	
	}
	
	public void	add(int x)
	{
		if (size < capacity)
		{
			data[size++] = x;
		}
	}




	
	public static void main(String[] args)
	{

	}
}
