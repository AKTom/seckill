package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

/**
 * @Author Jeanva He
 * @Date
 */
@Component
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private JedisPool jedispool = null;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;

    @PostConstruct
    public void init() {
        jedispool = new JedisPool(host, port);
    }

    public Seckill getSeckill(long seckillId) {
        try {
            Jedis jedis = jedispool.getResource();
            try {
                String key = "seckill:"+seckillId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //get bytes -> Object
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    return seckill;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill) {
        //set Object -> bytes[]
        try {
            Jedis jedis = jedispool.getResource();
            try {
                String key = "seckill:"+seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
