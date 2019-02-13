package com.xelvias.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.xelvias"})
public class WebConfig extends WebMvcConfigurerAdapter { //for spr version > 5 we can use WebMvcConfugurer interface

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/sample");
        registry.addViewController("/login.html");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");

        return bean;
    }

    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets**")
                .addResourceLocations("/WEB-INF/view/angular/dist/assets");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/");
        registry.addResourceHandler("/*.png")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/WEB-INF/view/angular/dist/angular/index.html");
    }


}
