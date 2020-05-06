package edu.tute.academicEarlyWarningManagementSystem.Bean.configretion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class BeanConfiguration {

    private static Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);


    @Bean
    public JedisPool redisPoolFactory() {
        JedisPool pool = null;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        pool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 1000, null);
        return pool;
    }


}
