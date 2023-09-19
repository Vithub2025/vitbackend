package com.vitg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan("com.vitg")
public class VitgApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitgApiApplication.class, args);
	}

}
