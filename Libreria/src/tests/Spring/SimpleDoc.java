package tests.Spring;

public class SimpleDoc extends Document
{
	public void print(String message)
	{
		System.out.println("Header official document");
		System.out.println(message);
		System.out.println("Body of official document");
	}
}
