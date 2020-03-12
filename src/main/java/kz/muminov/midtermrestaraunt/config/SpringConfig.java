package kz.muminov.midtermrestaraunt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.muminov.midtermrestaraunt")
@PropertySource("application.properties")
public class SpringConfig {
}
