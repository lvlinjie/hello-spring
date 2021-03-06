package com.spdb.lvlj.doamin.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;

import java.lang.reflect.Method;


/**
 * 缓存主要有几个要实现的类：其一就是CacheManager缓存管理器；
 * 其二就是具体操作实现类；
 * 其三就是CacheManager工厂类（这个可以使用配置文件配置的进行注入，也可以通过编码的方式进行实现）；
 * 其四就是缓存key生产策略（当然Spring自带生成策略，但是在Redis客户端进行查看的话是系列化的key,
 * 对于我们肉眼来说就是感觉是乱码了，这里我们先使用自带的缓存策略）。
 */
@Configuration
@EnableCaching
public class RedisCacheConfig  extends CachingConfigurerSupport {


    /**
     *缓存管理器.
     *@param redisTemplate
     *@return
     */
    @Bean
    public CacheManager cacheManager (RedisTemplate<?,?> redisTemplate) {
        CacheManager cacheManager =new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

    /**
     *redis模板操作类,类似于jdbcTemplate的一个类;
     *
     *虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
     *
     *这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
     *
     *自己的缓存类，比如：RedisStorage类;
     *
     *@param factory :通过Spring进行注入，参数在application.properties进行配置；
     *@return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,String>redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(factory);

        //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
        //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
        //或者JdkSerializationRedisSerializer序列化方式;
//           RedisSerializer<String>redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
//           redisTemplate.setKeySerializer(redisSerializer);
//           redisTemplate.setHashKeySerializer(redisSerializer);

        return redisTemplate;
    }

/*
    */
/**
     * 哈希模板
     * @param redisTemplate
     * @return
     *//*


    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }
*/

    /**
     * string 模板
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }*/

   /* *//**
     * 列表模板
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }*/

  /*  *//**
     * set模板
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }*/

    /*@Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }*/
    /**
     * 生成key的策略
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        System.out.println("RedisCacheConfig.keyGenerator()");
        return new KeyGenerator(){
                     @Override
                     public Object generate(Object o, Method method, Object... objects) {
                // This willgenerate a unique key of the class name, the method name
                //and allmethod parameters appended.
                StringBuilder sb =new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("keyGenerator=" +sb.toString());
                return sb.toString();
            }
        };
    }
}
