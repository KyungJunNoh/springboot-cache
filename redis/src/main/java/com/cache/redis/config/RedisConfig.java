package com.cache.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    /**
     * Redis 를 연결하기 위한 팩토리 메소드 Bean
     * RedisStandaloneConfiguration 클래스를 이용하여 redis 설정정보를 기반으로 연결을 함
     * @apiNote https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/connection/RedisStandaloneConfiguration.html
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

}
