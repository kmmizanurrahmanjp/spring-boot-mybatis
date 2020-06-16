package xyz.mizan.mybatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(Swagger2Config.class);
	
	@Autowired
    private Environment environment;
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage(environment.getProperty("controller.package")))
            .paths(PathSelectors.regex(environment.getProperty("swagger.path")))
            .build()
            .apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(environment.getProperty("swagger.title"))
            .description(environment.getProperty("swagger.description"))
            .contact(new Contact(environment.getProperty("swagger.contact.company"), environment.getProperty("swagger.contact.website"), environment.getProperty("swagger.contact.mail")))
            .license(environment.getProperty("swagger.license"))
            .licenseUrl(environment.getProperty("swagger.licenseURL"))
            .version(environment.getProperty("swagger.version"))
            .build();
    }
}
