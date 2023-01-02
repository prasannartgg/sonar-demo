package au.com.tgg.apps.foundation.handler;

import au.com.tgg.apps.foundation.util.AzureAppConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UtilHandler {

    private final AzureAppConfigProperties properties;

    @Autowired
    public UtilHandler(AzureAppConfigProperties properties) {
        this.properties = properties;
    }

    public Mono<ServerResponse> healthCheck(ServerRequest request){
        return ServerResponse.ok().body(Mono.just(properties.getMessage()),String.class);
    }
}
