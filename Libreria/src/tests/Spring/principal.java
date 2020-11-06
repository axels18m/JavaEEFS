package tests.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class principal 
{
	public static void main(String[] args)
	{
		principal p = new principal();
		p.testAppContext();
	}
	
	public void testMessage()
	{
		message msg = messageFactory.getMessage();
		msg.hola();
	}
	
	public void testAppContext()
	{
		ApplicationContext factory = new FileSystemXmlApplicationContext("applicationContext.xml");
		message msg = (message) factory.getBean("messageHTML");
		msg.hola();
	}
}
