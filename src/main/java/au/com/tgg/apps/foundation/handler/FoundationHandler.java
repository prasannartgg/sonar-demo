package au.com.tgg.apps.foundation.handler;

import au.com.tgg.apps.foundation.service.FoundationService;
import au.com.tgg.apps.foundation.service.impl.ValidatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class FoundationHandler {

    private final FoundationService foundationService;
    private final ValidatorServiceImpl validatorService;

    @Autowired
    public FoundationHandler(FoundationService foundationService, ValidatorServiceImpl validatorService) {
        this.foundationService = foundationService;
        this.validatorService = validatorService;
    }

    public Mono<ServerResponse> foundation(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(String.class)
                .flatMap(reqBody -> foundationService.serviceBusProcessor(reqBody))
                .flatMap(respBody -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(respBody)));
    }


    public Mono<ServerResponse> validateJson(ServerRequest serverRequest) {
        // receive SB
        recieveServiceBusMsgs(serverRequest);
        // receive SB
        return serverRequest.bodyToMono(String.class)
                .flatMap(reqBody -> validatorService.validateJson(reqBody))
                .flatMap(respBody -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(respBody)));

//        Mono<String> requestMono = serverRequest.bodyToMono(String.class);
//        Mono<String> mapped = requestMono//.map(name -> name)
//                .doOnSuccess(s -> {
//                    System.out.println(s);
//                    validatorService.validateJson(s);
//                });
//        return ServerResponse.ok().body(mapped, String.class);
    }

    public Mono<String> recieveServiceBusMsgs(ServerRequest serverRequest) {
        try {
            ServiceBusHandler.receiveMessages();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just("success");
    }


}