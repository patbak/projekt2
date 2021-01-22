package com.example.projekt;

import com.example.projekt.model.Material;
import com.example.projekt.model.User;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@SpringBootApplication
@EnableSwagger2
public class ProjektApplication {



	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);
	}





}
