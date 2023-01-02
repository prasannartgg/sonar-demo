package au.com.tgg.apps.foundation.config;

import au.com.tgg.apps.foundation.handler.AppSvcHandler;
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

    private final AppSvcHandler appSvcHandler;

    @Autowired
    public RouterConfig(UtilHandler utilHandler, FoundationHandler foundationHandler, AppSvcHandler appSvcHandler) {
        this.utilHandler = utilHandler;
        this.foundationHandler = foundationHandler;
        this.appSvcHandler = appSvcHandler;
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

//                .and(route().GET("/api/brand/{brandCode}", foundationHandler::findBrand,
//                        ops -> ops.operationId("brand-brand-code").summary("Find Brand By Brand Code")
//                                .parameter(parameterBuilder().in(ParameterIn.PATH).name("brandCode").description("Brand Code"))
//                                .response(responseBuilder().responseCode("200").description("successful operation").implementation(Brand.class)))
//                        .build())
//                /*.and(route().GET("/api/brands", foundationHandler::findAllBrand,
//                        ops -> ops.operationId("brands").summary("Get Brand List")
//                                .response(responseBuilder().responseCode("200").description("successful operation").implementationArray(Brand.class)))
//                        .build())*/
//                .and(route().GET("/api/brands", foundationHandler::findAllBrandByPage,
//                        ops -> ops.operationId("brands").summary("Get Brand Page")
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("page").description("Page number (default 0)"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("size").description("Number of items per page (default(5)"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("sort").description("Sort list (default brandCode)"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("brandCode").description("Brand Code, can pass multiple params, checks if code contains %brandCode%"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("brandName").description("Brand Name contains %brandName%"))
//                                .response(responseBuilder().responseCode("200").description("successful operation").implementationArray(Brand.class)))
//                        .build())
//                .and(route().GET("/api/products", appSvcHandler::findProductsByMerch,
//                        ops -> ops.operationId("product-merch").summary("Calls appsvc API to get List of products per store based on parameter inputs")
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("dep").description("Department Code"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("class").description("Class Code"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("subclass").description("Subclass Code"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("brand").description("Brand Code"))
//                                .parameter(parameterBuilder().required(false).in(ParameterIn.QUERY).name("prod").description("Prod Nbr"))
//                                .parameter(parameterBuilder().required(true).in(ParameterIn.QUERY).name("locn").description("locn nbr"))
//                                .response(responseBuilder().responseCode("200").description("successful operation").implementationArray(ItemLocCostDTO.class)))
//                        .build());

      /*  return RouterFunctions.route()
                .GET("/",utilHandler::healthCheck)
                .GET("/api/brand/{brandCode}",foundationHandler::findBrand)
                .GET("/api/brand/",foundationHandler::findAllBrand)
                .GET("/api/products",appSvcHandler::findProductsByMerch)
                .build();

                        parameters.put("dep", dep.get());
        parameters.put("class", clas.get());
        parameters.put("subclass", subclass.get());
        parameters.put("brand", brand.get());
        parameters.put("prod", prod.get());
        parameters.put("locn", locn.get());*/
    }
}
