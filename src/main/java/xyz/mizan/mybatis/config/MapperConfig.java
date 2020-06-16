package xyz.mizan.mybatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Configuration
@ImportResource({"classpath*:/META-INF/mybatis/application-context-mybatis.xml"})
public class MapperConfig {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(MapperConfig.class);

}
