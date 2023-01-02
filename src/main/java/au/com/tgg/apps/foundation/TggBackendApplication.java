package au.com.tgg.apps.foundation;

import au.com.tgg.apps.foundation.util.AzureAppConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableConfigurationProperties({AzureAppConfigProperties.class})
public class TggBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TggBackendApplication.class, args);

    }

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }

}
