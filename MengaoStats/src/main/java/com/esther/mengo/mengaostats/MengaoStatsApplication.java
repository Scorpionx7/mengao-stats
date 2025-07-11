package com.esther.mengo.mengaostats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MengaoStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MengaoStatsApplication.class, args);
	}

}
