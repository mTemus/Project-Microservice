package com.example.group4.ebikus.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class LoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration() {
		FilterRegistrationBean registrationBean =
				new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
