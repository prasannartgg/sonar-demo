package au.com.tgg.apps.foundation.config;

import au.com.tgg.apps.foundation.handler.FoundationHandler;
import au.com.tgg.apps.foundation.handler.UtilHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration(proxyBeanMethods = false)
public class RouterConfig {

    private final UtilHandler utilHandler;

    private final FoundationHandler foundationHandler;

    @Autowired
    public RouterConfig(UtilHandler utilHandler, FoundationHandler foundationHandler) {
        this.utilHandler = utilHandler;
        this.foundationHandler = foundationHandler;
    }


    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return route().GET("/", utilHandler::healthCheck,
                        ops -> ops.operationId("healthCheck").summary("Health Check")
                                .response(responseBuilder().responseCode("200").description("Healthy").implementation(String.class)))
                .build()
                .and(route().PUT("/api/foundation/crud", foundationHandler::foundation,
                                ops -> ops.operationId("foundation-api").summary("Insert/Update records in Foundation DB by PUT Request")
//                                        .parameter(parameterBuilder().in(ParameterIn.PATH).name("brandCode").description("Brand Code"))
                                        .requestBody(org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder().implementation(String.class))
                                        .response(responseBuilder().responseCode("200").description("successful operation"))
                        ).build()
                        .and(route().PUT("/api/foundation/JSONMsgValidator", foundationHandler::validateJson,
                                ops -> ops.operationId("json-msg-validator").summary("Validate JSON for Foundation")
//                                        .parameter(parameterBuilder().in(ParameterIn.PATH).name("brandCode").description("Brand Code"))
                                        .response(responseBuilder().responseCode("200").description("successful operation"))
                        ).build()))
                .and(route().PUT("/api/foundation/JSONMsgValidator", foundationHandler::validateJson,
                        ops -> ops.operationId("json-msg-validator").summary("Validate JSON for Foundation")
//                                        .parameter(parameterBuilder().in(ParameterIn.PATH).name("brandCode").description("Brand Code"))
                                .response(responseBuilder().responseCode("200").description("successful operation"))
                ).build());
    }
}
