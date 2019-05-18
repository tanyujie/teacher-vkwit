package org.easymis.vkwit.teacher.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
@EnableFeignClients(basePackages = "org.easymis.vkwit")
@ComponentScan(basePackages = "org.easymis.vkwit")
public class TeacherWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherWebApplication.class, args);
	}

}
