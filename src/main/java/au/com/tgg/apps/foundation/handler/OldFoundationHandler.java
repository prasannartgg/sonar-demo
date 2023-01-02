package au.com.tgg.apps.foundation.handler;
import au.com.tgg.apps.foundation.model.Brand;
import au.com.tgg.apps.foundation.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OldFoundationHandler {

    private final BrandService brandService;

    @Autowired
    public OldFoundationHandler(BrandService brandService) {
        this.brandService = brandService;
    }

    public Mono<ServerResponse> findBrand(ServerRequest request){
        String brandCode=  request.pathVariable("brandCode");
        Brand brand = brandService.getBrand(brandCode);
        return ServerResponse.ok().body(Mono.just(brand),
                /*.onErrorResume(e -> {
                    if(e instanceof TggApiRuntimeException) {
                        return Mono.error(e);
                    }
                    return null;
                }),*/
        Brand.class);
    }

    public Mono<ServerResponse> findAllBrand(ServerRequest serverRequest) {
        List<Brand> allBrands = brandService.getAllBrands();
        return ServerResponse.ok().body(Mono.just(allBrands), Brand.class);
    }

    public Mono<ServerResponse> findAllBrandByPage(ServerRequest serverRequest) {
        String page = serverRequest.queryParam("page").orElse("0");
        String size = serverRequest.queryParam("size").orElse("5");
        String sort = serverRequest.queryParam("sort").orElse("brandCode");
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size), Sort.by(sort));
        Page<Brand> pagedBrands = brandService.getBrandPage(pageable, serverRequest.queryParams());
        return ServerResponse.ok().body(Mono.just(pagedBrands), Brand.class);
    }
}
