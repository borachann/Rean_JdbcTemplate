package com.rean.bootstrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.rean.configuration.ServletConfiguration;

public class Bootstrap implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext container){
		AnnotationConfigWebApplicationContext servletcontext = new AnnotationConfigWebApplicationContext();
		servletcontext.register(ServletConfiguration.class);
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("springServlet", new DispatcherServlet(servletcontext));
		dispatcher.addMapping("/");
	}
}