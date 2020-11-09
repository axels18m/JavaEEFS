package tests.Spring;

public class OfficialDoc extends Document
{
	public void print(String message)
	{
		System.out.println("<official>Header official document</official>");
		System.out.println("<official>" + message + "</official>");
		System.out.println("<official>Body of official document</official>");
	}
}
