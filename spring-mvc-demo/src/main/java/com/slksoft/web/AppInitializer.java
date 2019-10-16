package com.slksoft.web;

import java.beans.AppletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.slksoft.cfg.AppConfig;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// create the spring container
		AnnotationConfigWebApplicationContext ctx;
		ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		// create the dispatcher-servlet and pass spring container
		ServletRegistration.Dynamic servlet;
		servlet = servletContext.addServlet("s1", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		// map dispatcher-servlet to "/"

	}

}

