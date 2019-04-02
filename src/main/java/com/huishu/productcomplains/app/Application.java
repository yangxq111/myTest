package com.huishu.productcomplains.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.jmx.support.RegistrationPolicy; 

/**
 * Created by gzg on 2017/8/29
 */
@Configuration
@ComponentScan("com.huishu")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.huishu.productcomplains.model")
@EnableJpaRepositories(basePackages = "com.huishu.productcomplains.repository")
@EnableScheduling
@MapperScan("com.huishu.productcomplains.mapper")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING) 
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("pickcar project start success");
	}
}


