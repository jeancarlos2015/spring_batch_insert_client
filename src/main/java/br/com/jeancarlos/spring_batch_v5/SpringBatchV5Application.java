package br.com.jeancarlos.spring_batch_v5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchV5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchV5Application.class, args);
	}

}
