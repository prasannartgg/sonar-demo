package au.com.tgg.apps.foundation.handler;

import au.com.tgg.apps.foundation.dto.ItemLocCostDTO;
import au.com.tgg.apps.foundation.external.AppSvcsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppSvcHandler {

    private final AppSvcsClient appSvcsClient;

    @Autowired
    public AppSvcHandler(AppSvcsClient appSvcsClient) {
        this.appSvcsClient = appSvcsClient;
    }

    public Mono<ServerResponse> findProductsByMerch(ServerRequest request){
        String dep =  request.queryParam("dep").orElse("");
        String clas =  request.queryParam("class").orElse("");
        String subclass =  request.queryParam("subclass").orElse("");
        String brand =  request.queryParam("brand").orElse("");
        String prod =  request.queryParam("prod").orElse("");
        String locn =  request.queryParam("locn").orElse("");

        Map<String,String> parameters = new HashMap<>();
        parameters.put("dep", dep);
        parameters.put("class", clas);
        parameters.put("subclass", subclass);
        parameters.put("brand", brand);
        parameters.put("prod", prod);
        parameters.put("locn", locn);

        return ServerResponse.ok().body(appSvcsClient.getItemLocCostDto(parameters).map(p -> p.getData()),
                new ParameterizedTypeReference<List<ItemLocCostDTO>>() {
        });
    }
}
