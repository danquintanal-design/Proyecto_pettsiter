package com.pettsitter.ms_appointments_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAppointmentsBsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsAppointmentsBsApplication.class, args);
	}
}
