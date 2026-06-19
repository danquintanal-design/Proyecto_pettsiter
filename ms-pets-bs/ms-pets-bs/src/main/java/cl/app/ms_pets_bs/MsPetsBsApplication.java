package cl.app.ms_pets_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPetsBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPetsBsApplication.class, args);
	}

}
