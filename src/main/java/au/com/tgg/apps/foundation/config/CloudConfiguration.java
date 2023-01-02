package au.com.tgg.apps.foundation.config;


import au.com.tgg.apps.foundation.util.AzureCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfiguration {

    @Bean
    public AzureCredentials azureCredentials() {
        return new AzureCredentials();
    }
}
