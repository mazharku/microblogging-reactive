/**
 * 
 */
package com.mazhar.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author mazhar
 *
 * Mar 24, 2021
 */
@Configuration
public class SwaggerConfig {
	public static final String DEFAULT_PATH = "/api/.*";
	private final String DESCRIPTION = "Microblog reactive  Api documentation";
	private final String VERSION = "1.0.1";

	@Bean
	public Docket swaggerSpringfoxDocket() {

		Contact contact = new Contact("Microblog-reactive", "", "mazhar.shapnil@gmail.com");

		ApiInfo apiInfo = new ApiInfo("Microblog-reactive", DESCRIPTION, VERSION, "", contact, "", "", new ArrayList<>());

		Docket docket = new Docket(DocumentationType.OAS_30).pathMapping("/").apiInfo(apiInfo).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(Pageable.class)
				.ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).useDefaultResponseMessages(false);

		docket = docket.select().paths(regex(DEFAULT_PATH)).build();
		return docket;
	}

}
