package com.su.springboot.app.company.setting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableEurekaClient
@EntityScan({"com.su.springboot.app.commons.models.entity"})
@EnableJpaAuditing
@SpringBootApplication
public class SpringbootServiceCompanySettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCompanySettingApplication.class, args);
	}

}
