package tests.Spring;

import java.util.Properties;

public class messageFactory 
{
	public static message getMessage() 
	{
		Properties properties = new Properties();
		message msg = null;
		
		try {
			
			/* Load the file where the file path is */
			properties.load(principal.class.getResourceAsStream("message.properties")); 
			String type = properties.getProperty("type");
			if (type.equals("html"))
			{
				msg = new messageHtml();
			} else {
				msg = new messagePlano();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
}
