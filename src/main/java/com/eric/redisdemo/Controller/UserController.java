package com.eric.redisdemo.Controller;

import com.eric.redisdemo.config.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private JedisUtil jedisUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // http://localhost:8087/wiener/user/testRedisSave?id=1090330
    @RequestMapping("/testRedisSave")
    public String testRedisSave() {
//        try {
//            long id = 1;
//            jedisUtil.del("userId:" + id);
//            jedisUtil.set("userId:" + id, "测试地址是 " + UUID.randomUUID().toString());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "保存成功";
//        ValueOperations ops=redisTemplate.opsForValue();
//        ops.set("name","zhangshan");
//        return  ops.get("name").toString();
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        ops.set("alibaba","jack-ma");
        return  ops.get("alibaba");
    }
    // http://localhost:8087/wiener/user/testRedisGet?id=1090330
    @RequestMapping("/testRedisGet")
    public String testRedisGet() {
//        String id="1";
//        String myStr= jedisUtil.get("userId:"+ id);
//        if(!StringUtils.isEmpty(myStr)) {
//            return myStr;
//        }
        return null;
    }
}