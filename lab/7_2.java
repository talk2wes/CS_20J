/**
 * This is chapter 7 problem 2 from the java textbook
 */
class Message
{
	private String	text;

	//returns the text field
	public String	toString()
	{
		return(text);	
	}

	public void	setString(String newMsgTxt)
	{
		text = newMsgTxt;
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
		String temp = this.text + recipientContactNo;
		return (temp);
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
	public static void main(String args[])
	{
		System.out.println("Hello java");
	}
}	
