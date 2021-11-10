package com.revature.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


 /*Java doc comments start with a slash and TWO astericks and
 end with a single asterick and a slash. Placed before declratation of a public class filed method or constructor.
 It goes before any annotations. It can include descriptive text. It can contain HTML markup for fancy formatting.
 Don't use heading tags though.
 Special doc tags provide specific information used by Javadoc with similar syntax to annotations i.e.
 @author, @version, @param*/

/**
 * Java doc comments for Application class. The Application class contains the main method for the RevCare app.
 * It also contains the CorsFilter bean.
 * @author Dan Felleman batch
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.revature.Spring") // look for components/stereotypes
@EnableJpaRepositories("com.revature.Spring.repositories") //tells spring where to find our repos so hibernate can do its work
@EntityScan("com.revature.Spring.models")
public class Application {

	/**
	 * main method. The main method calls the SpringApplication to launch the Spring Java app.
	 * @param args The main method required String parameter.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * CorsFilter method. Filter to handle CORS pre-flight requests and intercept CORS simple and actual
	 * requests with a CorsProcessor, and to update the response.
	 */
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}









