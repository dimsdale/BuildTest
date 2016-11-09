package ua.sdo.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ua.sdo.BuildTestApplication;
import ua.sdo.service.BuildService;
import ua.sdo.service.InviteBuildService;
import ua.sdo.service.UserService;
import ua.sdo.service.implementation.BuildServiceImpl;
import ua.sdo.service.implementation.InviteBuildServiceImpl;
import ua.sdo.service.implementation.UserServiceImpl;

import java.util.concurrent.TimeUnit;
@Configuration
@EnableWebMvc
@ComponentScan("ua.sdo")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = BuildTestApplication.class)
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Bean(name = "userService")
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
