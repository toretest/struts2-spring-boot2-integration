package com.amdexa.example.structs2.config;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

/**
 * https://struts.apache.org/getting-started/hello-world-using-struts2#step-3---create-the-view-helloworldjsp
 */
@Configuration
public class Struts2Configuration implements WebMvcConfigurer {

    private static final String[] STRUTS_RESOURCE_LOCATIONS = {"classpath:/template/"};

    @Bean
    public FilterRegistrationBean<Filter> filterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new StrutsPrepareAndExecuteFilter());
        registration.addUrlPatterns("*.html");
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registration.setName("StrutsPrepareAndExecuteFilter");
        return registration;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/struts/**")
                .addResourceLocations(STRUTS_RESOURCE_LOCATIONS);
    }

}
