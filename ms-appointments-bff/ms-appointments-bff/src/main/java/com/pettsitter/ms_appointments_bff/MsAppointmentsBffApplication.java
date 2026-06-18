package com.pettsitter.ms_appointments_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAppointmentsBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAppointmentsBffApplication.class, args);
	}
}
