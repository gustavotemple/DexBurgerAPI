package com.dexburger.configurations;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
@ComponentScan(basePackages = { SwaggerConfiguration.BASE_PACKAGE })
public class SwaggerConfiguration {
	
	public static final String BASE_PACKAGE = "com.dexburger";
	
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
