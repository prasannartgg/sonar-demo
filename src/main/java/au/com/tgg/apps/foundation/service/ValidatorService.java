package au.com.tgg.apps.foundation.service;

import reactor.core.publisher.Mono;

public interface ValidatorService {
    Mono<String> validateJson(String jsonString);
}
