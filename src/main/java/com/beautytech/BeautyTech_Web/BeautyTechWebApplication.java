package com.beautytech.BeautyTech_Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BeautyTechWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyTechWebApplication.class, args);
	}

}
