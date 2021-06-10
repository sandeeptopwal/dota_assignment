package com.eshopbox.dota;

import com.eshopbox.dota.feignClient.DotaApiFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.eshopbox")
@Slf4j
public class DotaApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(DotaApplication.class);

		Environment environment = application.run(args).getEnvironment();

		log.info("\n----------------------------\n\t" +
				"Application access URL : http://localhost:{}{}swagger-ui.html \n----------------------------",environment.getProperty("server.port"),environment.getProperty("server.servlet.context-path"));
	}

}
