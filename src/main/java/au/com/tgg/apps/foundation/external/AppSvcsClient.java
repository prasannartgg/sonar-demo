package au.com.tgg.apps.foundation.external;

import au.com.tgg.apps.foundation.dto.ProductsByMerchDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.Map;

@Service
public class AppSvcsClient {

    private final WebClient webClient;

    public AppSvcsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api-npd.thegoodguys.com.au/dev/appsvcs/").build();
    }

    public Mono<ProductsByMerchDTO> getItemLocCostDto(Map<String, String> parameters) {
        return productsByMerch(parameters);
    }

/*    public Mono<List<String>> getItems(Map<String, String> parameters) {
        return Mono.just(productsByMerch(parameters).getData().stream().map(ItemLocCostDTO::getItemId).collect(Collectors.toList()));
    }*/

    private Mono<ProductsByMerchDTO> productsByMerch(Map<String, String> parameters) {
        Mono<ProductsByMerchDTO> items = this.webClient.get().uri(
                uriBuilder -> uriBuilder
                        .path("/productsbymerch")
                        .queryParam("dep", parameters.get("dep"))
                        .queryParam("class", parameters.get("class"))
                        .queryParam("subclass", parameters.get("subclass"))
                        .queryParam("brand", parameters.get("brand"))
                        .queryParam("prod", parameters.get("prod"))
                        .queryParam("locn", parameters.get("locn"))
                        .build()
        )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductsByMerchDTO.class);
        return items;
    }

}
