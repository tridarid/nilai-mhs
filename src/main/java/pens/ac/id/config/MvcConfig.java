package pens.ac.id.config;

/**
 * Created by tridarid on 05/12/16.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("/home/home");
        registry.addViewController("/").setViewName("/home/home");

        registry.addViewController("/nilai-edit").setViewName("/nilai/nilai-edit");
        registry.addViewController("/nilai-input").setViewName("/nilai/nilai-input");
        registry.addViewController("/nilai-list").setViewName("/nilai/nilai-list");

        registry.addViewController("/login").setViewName("/login/login");
    }
}
