package com.liang.redis;
import java.util.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by liang on 16/5/12.
 */
public class redis {


    public static void start()
    {

    }

    public static void main(String[] args) {
      //  Jedis jedis = new Jedis("localhost");


        JedisPool pool;
        Jedis jedis;
        pool = new JedisPool(new JedisPoolConfig(),"127.0.0.1");
        jedis = pool.getResource();
        jedis.set("name","minxr");//向key-->name中放入了value-->minxr
        jedis.set("Sting" ,"2");
        jedis.set("name" , "2");
        

        System.out.println(jedis.get("String"));//执行结果：minxr

    }
}
