/**
 * 
 */
package com.blueharvest.account.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author Parantap Mathur
 *
 */
@Configuration
public class MVCController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/createAccountRequest").setViewName("createAccountRequest");
        registry.addViewController("/openAccount").setViewName("openAccount");
    }

}