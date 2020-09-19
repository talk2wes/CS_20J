


class Message()
{
	private String	text;

	//returns the text field
	public string	toString()
	{
		return(text);	
	}

	public void	setString(string newMsgTxt)
	{
		text = newMsgTxt;
	}
	
}


class SMS extends Message
{
	private int	recipientContactNo;

	void		setRecipientContactNo(int newRecContNo)
	{
		recipientContactNo = newRecContNo;
	}

	int		getRecipientContactNo(void)
	{
		return (recipientContactNo);
	}
}
