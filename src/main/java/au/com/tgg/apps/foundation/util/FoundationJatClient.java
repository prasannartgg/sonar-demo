package au.com.tgg.apps.foundation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
public class FoundationJatClient {

    private final WebClient webClient;
    private static final Logger LOGGER = LogManager.getLogger(FoundationJatClient.class);
    private final Environment env;

    @Autowired
    public FoundationJatClient(Environment env) {
        this.env = env;
        this.webClient = WebClient.builder().baseUrl(this.env.getProperty("foundation-api.url")).defaultHeaders(httpHeaders -> {
            httpHeaders.set("Ocp-Apim-Subscription-Key", this.env.getProperty("foundation-api.header-key"));
        }).build();
    }

    public Mono<Object> refreshMerchClassCache(BigInteger merchClazz) {
        return this.evictCache("merchClass", merchClazz.toString())
                .then(this.webClient.get().uri(
                uriBuilder -> uriBuilder
                        .path("/api/merch-class/class/{clazz}")
                        .build(merchClazz.toString())
        )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class));
    }

    public Mono<Object> refreshCache(String cache, String key,  String path) {
        return this.evictCache(cache, key)
                .then(this.webClient.get().uri(
                        uriBuilder -> uriBuilder
                                .path("/api/"+path)
                                .build()
                )
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(Object.class));
    }

/*    public Mono<Object> refreshCache(String tableName, String key, String path, String queryParam1, String queryParam2) {
        return this.evictCache(tableName, key)
                .then(this.webClient.get().uri(
                        uriBuilder -> uriBuilder
                                .path("/api/"+path)
                                .build(queryParam1, queryParam2)
                )
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(Object.class));
    }*/



//    public Mono<Object> refreshMerchDepsCache(String merchDeps) {
//        return this.evictCache("merchDeps", merchDeps)
//                .then(this.webClient.get().uri(
//                        uriBuilder -> uriBuilder
//                                .path("/api/merch-deps/dept/{dept}")
//                                .build(merchDeps)
//                )
//                        .accept(MediaType.APPLICATION_JSON)
//                        .retrieve()
//                        .bodyToMono(Object.class));
//    }
//
//    public Mono<Object> refreshMerchSubclassCache(String subclass) {
//        return this.evictCache("merchSubclass", subclass)
//                .then(this.webClient.get().uri(
//                        uriBuilder -> uriBuilder
//                                .path("/api/merch-subclass/subclass/{subclass}")
//                                .build(subclass)
//                )
//                        .accept(MediaType.APPLICATION_JSON)
//                        .retrieve()
//                        .bodyToMono(Object.class));
//    }

    public Mono<Boolean> evictCache(String cache, String key) {
        Mono<Boolean> response = this.webClient.delete().uri(
                uriBuilder -> uriBuilder
                        .path("/api/redis-key/{table}/{id}")
                        .build(cache, key)
        )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Boolean.class);
        return response;
    }
}
