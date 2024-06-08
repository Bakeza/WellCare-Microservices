package com.wellcare.Comment.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wellcare.Comment.Service.Assemblers.CommentModelAssembler;
import com.wellcare.Comment.Service.Storage.StorageService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.wellcare.Comment.Service.Repositories")
public class CommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentServiceApplication.class, args);
	}
	
	@Bean
    public CommentModelAssembler commentModelAssembler() {
        return new CommentModelAssembler();
    }

}
