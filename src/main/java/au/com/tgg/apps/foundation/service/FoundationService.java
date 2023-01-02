package au.com.tgg.apps.foundation.service;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import reactor.core.publisher.Mono;

public interface FoundationService {

    Mono<String> serviceBusProcessor(String request);
    ResponseDTO processJsonPayload(String request);
//    ResponseDTO insertPayload(String entityName, String request) throws Exception;
    ResponseDTO updatePayload(String entityName, String request) throws Exception;
    ResponseDTO deletePayload(String entityName, String request) throws Exception;
}
