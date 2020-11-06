package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class Action 
{
	static String className = Action.class.getPackage().getName();
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
	public static Action getAction(String type)
	{
		Action action = null;
		try {
			action = (Action) Class.forName(className + "." + type + "Action").newInstance();
		} catch (InstantiationException e) {
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return action;
	}
	
	public Object getBean(String name, HttpServletRequest request)
	{
		/* Spring factory for web app. Load once the xml file  */
		WebApplicationContext factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return factory.getBean(name);
	}
}
