package com.dexburger.configuration;

import java.util.Collections;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dexburger.prices.IngredientsPrices;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { ApplicationConfig.BASE_PACKAGE })
@EnableConfigurationProperties(IngredientsPrices.class)
public class ApplicationConfig {
	
	public static final String BASE_PACKAGE = "com.dexburger";
	public static final String PREFIX = "/api/v1";
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping(PREFIX + "/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
						.allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build()
				.apiInfo(apiInfo()).tags(new Tag("Cardapio", ""), new Tag("Pedidos", ""));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("DexBurgerAPI", "DexBurgerAPI", "1.0", "", ApiInfo.DEFAULT_CONTACT,
				"MIT License", "https://mit-license.org", Collections.emptyList());
	}
	
}
