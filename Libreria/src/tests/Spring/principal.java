package tests.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class principal 
{
	public static void main(String[] args)
	{
		principal p = new principal();
		//p.testAppContext();
		p.testDocuments();
	}
	
	public void testMessage()
	{
		message msg = messageFactory.getMessage();
		msg.hola();
	}
	
	public void testAppContext()
	{
		ApplicationContext factory = new FileSystemXmlApplicationContext("applicationContext.xml");
		message msg = (message) factory.getBean("messageHtml");
		msg.hola();
		
		message msg2 = (message) factory.getBean("messagePlano");
		msg2.hola();
	}
	
	public void testDocuments()
	{
		Document doc = new OfficialDoc();
		doc.print("official document");
		doc = new SimpleDoc();
		doc.print("simple doc");
	}
}
