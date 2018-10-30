package com.chengxuunion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.chengxuunion.**.dao")
@ComponentScan("com.chengxuunion")
@EnableScheduling
public class MySpringBootServletInitializer8090 extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MySpringBootServletInitializer8090.class);
    }
	
	public static void main(String[] args) {
        SpringApplication.run(MySpringBootServletInitializer8090.class, args);
    }
	
}
