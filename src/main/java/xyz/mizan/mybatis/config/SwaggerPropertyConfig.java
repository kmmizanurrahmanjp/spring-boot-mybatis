package xyz.mizan.mybatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:META-INF/properties/swagger.properties")
})
public class SwaggerPropertyConfig {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SwaggerPropertyConfig.class);
	
	
	//code here
}
