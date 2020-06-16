package xyz.mizan.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class BootstrapApplication {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(BootstrapApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
	}

}
