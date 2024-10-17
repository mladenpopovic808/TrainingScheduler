package com.example.demo.pack;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //"idegas" je ime rute,nista ne znaci bukv,mozes sta oces da stavis
                // "/api je prefiks servisa koji gadjamo, proveri app.properties servisa kojeg gadjas
                //i stavi prefiks ovde
                .route("idegas", r -> r.path("/userService/**")
                        .uri("http://localhost:8080/bracala/glava/glava/majmun"))
                        //odavde gleda samo port,nista ga drugo ne zanima lol
                        //tako da,samo port stavi i nista vise
                .route("ruta2", r -> r.path("/scheduleService/**")
                        .uri("http://localhost:8081/bracala/glava/glava/majmun"))

                .build();
    }
}



