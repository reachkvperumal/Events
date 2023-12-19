package com.kv.events.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

//@Configuration
public class TomcatConfig {

    //server.tomcat.max-threads=250
    //  @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
        return (factory) -> {
            factory.addConnectorCustomizers((connector) -> {
                //            connector.setAttribute("maxThreads", "300");
                //            connector.setAttribute("minSpareThreads", "50");
                // Add other customizations as needed
            });
        };
    }
}
