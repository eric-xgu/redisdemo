package com.eric.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisdemoApplicationTests {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void op() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("user", "name", "eric");
        ops.get("user", "name");
        Map<String, String> map = new HashMap<>();
        //map.put("tempture","37");
        map.put("age", "18");
        ops.putAll("user", map);
        List<String> keys = new ArrayList<>();
        keys.add("name");
        keys.add("age");
        List user = ops.multiGet("user", keys);
        user.forEach(System.out::println);
        Map<String, String> en = ops.entries("user");
        en.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "----" + e.getValue());
        });
        //ops.delete("user","name","age");
        ListOperations ops1 = redisTemplate.opsForList();
        ops1.leftPush("name", "eric1");
        ops1.rightPush("name", "name");
        ops1.leftPush("name", "eric1", "jack");
        ops1.rightPush("name", "lilei");
        List list = ops1.range("name", 0, 3);
        list.forEach(System.out::println);
        long size = ops1.size("name");
        System.out.println(size);
        ops1.remove("name", 1, "name");
        ops1.leftPop("name");

        SetOperations set = redisTemplate.opsForSet();
        String[] arr = new String[]{"aa", "bb", "cc", "dd"};
        set.add("sss", "aa", "bb", "cc", "dd");
        set.add("sss", arr);

        redisTemplate.opsForZSet().add("zSet", "aaa", 1);
        redisTemplate.opsForZSet().add("zSet", "bbb", 2);
        redisTemplate.opsForZSet().add("zSet", "ccc", 3);

        ZSetOperations.TypedTuple<String> objectTypedTuple1 = new DefaultTypedTuple<>("eee", 9.6);
        ZSetOperations.TypedTuple<String> objectTypedTuple2 = new DefaultTypedTuple<>("fff", 1.5);
        ZSetOperations.TypedTuple<String> objectTypedTuple3 = new DefaultTypedTuple<>("ggg", 7.4);
        Set<ZSetOperations.TypedTuple<String>> typles = new HashSet<>();
        typles.add(objectTypedTuple1);
        typles.add(objectTypedTuple2);
        typles.add(objectTypedTuple3);
        redisTemplate.opsForZSet().add("zSet", typles);
        Set set1=redisTemplate.opsForZSet().range("zSet",0,4);
        set1.forEach(System.out::println);
        redisTemplate.opsForZSet().size("zSet");
        redisTemplate.opsForZSet().remove("zSet","eee","fff");

        ValueOperations ops2=redisTemplate.opsForValue();
        ops2.set("core",30,30, TimeUnit.SECONDS);
        long expire=redisTemplate.getExpire("core");
        System.out.println(expire);

    }


    @Test
    public  void initconn(){
        Jedis jedis=new Jedis("192.168.2.139",6379);
        jedis.auth("root");
        //选择数据库
        jedis.select(0);
        String pong=jedis.ping();
        System.out.println(pong);
        jedis.set("name","zs");
        String name =jedis.get("name");
        System.out.println(name);
        if(jedis!=null){
            jedis.close();
        }
    }
    @Test
    public void jespool(){
        JedisPool jedisPool=new JedisPool(new JedisPoolConfig(),"192.168.2.139",6379,10000,"root");
        Jedis jedis=jedisPool.getResource();
        jedis.select(0);
        String pong=jedis.ping();
        System.out.println(pong);
        jedis.set("name","zs1");
        String name =jedis.get("name");
        System.out.println(name);
    }

}
