package com.fdm.soloproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.fdm.soloproject2.security.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)		// SPRING SECURITY
public class SoloProject2Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(SoloProject2Application.class, args);
	}

}
