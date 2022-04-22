package com.eric.redisdemo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;



//@Configuration
public class JedisPoolFactory {
//    @Value("${spring.redis.host}")
//    private String host;
//  @Value("${spring.redis.port}")
//  private int port;
//  @Value("${spring.redis.timeout}")
//  private int timeout;
//  @Value("${spring.jedis.pool.max-active}")
//  private int maxActive;
//  @Value("${spring.jedis.pool.min-idle}")
//  private int minIdle;
//  @Value("${spring.jedis.pool.max-idle}")
//  private int maxIdle;
//  @Value("${spring.jedis.password}")
//  private String password;
//
//  @Bean
//  public JedisPool generateJedisPoolFactory() {
//      JedisPoolConfig poolConfig = new JedisPoolConfig();
//      poolConfig.setMaxTotal(maxActive);
//      poolConfig.setMaxIdle(maxIdle);
//      poolConfig.setMinIdle(minIdle);
//
//      // 连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
//      poolConfig.setBlockWhenExhausted(Boolean.TRUE);
//     // JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout);
//      // 若设置了Redis密码，请调用如下构造函数
//         System.out.println(host+":"+port+":"+timeout+":"+password);
//          JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password,1);
//          return jedisPool;
//
//  }
}
