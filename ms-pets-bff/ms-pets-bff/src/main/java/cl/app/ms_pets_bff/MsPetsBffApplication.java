package cl.app.ms_pets_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPetsBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPetsBffApplication.class, args);
	}

}
