package in.sm.main.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener 
{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context created.....");
		
		List<Todo> list = new ArrayList<>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", list);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}	
}
