package br.com.lordoftests.config;

import br.com.lordoftests.service.GuerraService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class GuerraServiceConfig {

    @Bean
    public GuerraService guerraService() {
        return new GuerraService();
    }
}
