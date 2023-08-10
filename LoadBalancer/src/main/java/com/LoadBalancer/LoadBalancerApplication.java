package com.LoadBalancer;

import com.LoadBalancer.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Documentation", description = "All User API for CRUD Operation"))
public class LoadBalancerApplication
{
	@Autowired
	private  static UserRepository userRepository;
	public static void main(String[] args)
	{
		SpringApplication.run(LoadBalancerApplication.class, args);

	}


}
