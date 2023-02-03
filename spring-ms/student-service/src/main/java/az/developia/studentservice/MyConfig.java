package az.developia.studentservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(value = "limits-service")
@Data
public class MyConfig {
private String min;
private String max;
}
