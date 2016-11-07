package ua.sdo.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ua.sdo.model.InviteBuild;
import ua.sdo.service.BuildService;
import ua.sdo.service.InviteBuildService;
import ua.sdo.service.UserService;
import ua.sdo.service.implementation.BuildServiceImpl;
import ua.sdo.service.implementation.InviteBuildServiceImpl;
import ua.sdo.service.implementation.UserServiceImpl;

import java.util.concurrent.TimeUnit;

public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Bean()
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public BuildService buildService(){
        return new BuildServiceImpl();
    }

    @Bean
    public InviteBuildService inviteBuildService(){
        return new InviteBuildServiceImpl();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        return factory;
    }

    @Bean
    public UrlBasedViewResolver setViewResolver(){
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
