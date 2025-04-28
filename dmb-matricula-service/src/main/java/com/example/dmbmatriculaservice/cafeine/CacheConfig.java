package com.example.dmbmatriculaservice.cafeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching  // Habilita la caché en Spring
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        // Crear el manager de caché utilizando Caffeine
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        // Configuración de la caché (tiempo de expiración, tamaño máximo)
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)  // Expira después de 60 minutos
                .maximumSize(1000));  // Tamaño máximo de la caché
        return cacheManager;
    }
}
