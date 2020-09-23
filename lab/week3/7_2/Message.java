class Message
{
	protected String	text;

	//returns the text field
	public String	toString()
	{
		return(text);	
	}

	public void	setString(String newMsgTxt)
	{
		text = newMsgTxt;
	}

	public static void main(String args[])
	{
		System.out.println("Hello java");

		Email fromJosh = new Email();

	}
}


class SMS extends Message
{
	private String	recipientContactNo;

	void		setRecipientContactNo(String newRecContNo)
	{
		recipientContactNo = newRecContNo;
	}

	String		getRecipientContactNo()
	{
		return (recipientContactNo);
	}

	//I think this is what they want for the concat of the two "text fields"
	public String	toString()
	{
		return (text + recipientContactNo);
	}

}

class Email extends Message
{
	private String		sender;
	private String		reciever;
	private String		subject;

	public String		toString()
	{
		return (sender + reciever + subject + text);
	}
	
}	
