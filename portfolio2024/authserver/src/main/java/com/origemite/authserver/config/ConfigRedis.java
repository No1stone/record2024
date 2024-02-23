package com.origemite.authserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
@EnableRedisRepositories("com.origemite.authserver.data.redis.repo")
public class ConfigRedis implements CachingConfigurer {

    /**
     * @EnableCaching 캐싱 기능을 사용
     * @Cacheable(value="test") 캐싱을 추가하는 메소드에 붙힌다.
     * @CacheEvict(value="test") 캐싱을 처리하고 캐쉬를 삭제할 메소드에 붙힌다.
     * @CachePut(value="test") 캐싱을 처리하고 캐쉬를 수정할 메소드에 붙힌다.
     * @Cachㅑㅜㅎ(value="test") 여러개를 처리할때 사용한다.
     */

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(host, port);
        return redisConnectionFactory;
    }

//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer() {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(redisConnectionFactory());
//        container.addMessageListener(messageListenerAdapter(), topic());
//        return container;
//    }

//    @Bean
//    public MessageListenerAdapter messageListenerAdapter(){
//        return new MessageListenerAdapter(new RedisMessgeStringSubscriber());
//    }

    /*

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("ch01");
    }
 */
//    @Override
//    public CacheManager cacheManager() {
//        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
//
//            @Override
//            protected Cache createConcurrentMapCache(final String name) {
//                return new ConcurrentMapCache(name,
//                        CacheBuilder.newBuilder()
//                                .expireAfterWrite(30*7, TimeUnit.MINUTES)
////                                .maximumSize(100)
//                                .build().asMap(), false);
////            캐시빌더 구글 구아바스펙.
//            }
//        };
//        return cacheManager;
//    }

    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofSeconds(60*60*24*7))
                .computePrefixWith(CacheKeyPrefix.simple())
                .serializeKeysWith(
                        RedisSerializationContext.SerializationPair
                                .fromSerializer(new StringRedisSerializer()))

                .serializeValuesWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));


        // 캐시키 별 default 유효시간 설정
//        Map<String, RedisCacheConfiguration> cacheConfiguration = new HashMap<>();
//        cacheConfiguration.put("jusoBuild",RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(60*60*24*7)));

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(configuration)
//                .withInitialCacheConfigurations(cacheConfiguration)
                .build();
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }

}
