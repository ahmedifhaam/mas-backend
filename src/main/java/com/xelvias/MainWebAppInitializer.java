package com.xelvias;

import com.xelvias.configs.WebSecurityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;

//public class MainWebAppInitializer {
public class MainWebAppInitializer
        implements WebApplicationInitializer {
    private static final String TMP_FOLDER = "/tmp";
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        root.scan("com.xelvias");
        servletContext.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("mvc",new DispatcherServlet(new GenericWebApplicationContext()));

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,MAX_UPLOAD_SIZE,
                MAX_UPLOAD_SIZE*2,MAX_UPLOAD_SIZE/2);

        appServlet.setMultipartConfig(multipartConfigElement);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");

        servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");

    }


}
