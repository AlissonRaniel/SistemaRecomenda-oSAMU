package br.com.cesed.facisa.si.tcc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationSRSWebService extends SpringBootServletInitializer{
	
	public static void main (final String[] args){
		SpringApplication.run(ApplicationSRSWebService.class, args);
	}
	
}
