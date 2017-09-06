package com.imaginatio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//import com.imaginatio.service.serviceImpl.UserDetailsServiceImpl;


//@Configuration
//@EnableWebMvc
//@ComponentScan("com.imaginatio")
//public class WebAppConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
//
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setSuffix(".jsp");
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }

    //  @Bean
    //  public UserDetailsService userDetailsService() {
    //     return new UserDetailsServiceImpl();
    // }
//}





