package com.liang.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;
/**
 * Created by liang on 16/5/12.
 */
public class redis_test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfullygitgi");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());


        //Redis Java String(字符串) 实例
        jedis.set("w3ckey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }
    }
    JedisPool pool;
    Jedis jedis;

    @Test
    public void setUp()
    {
        pool = new JedisPool(new JedisPoolConfig(),"127.0.0.1");
        jedis = pool.getResource();
    }

    /**
     * Redis存储初级的字符串
     * CRUD
     */
    @Test
    public void testBasicString(){
        //-----添加数据----------
        jedis.set("name","minxr");//向key-->name中放入了value-->minxr
        System.out.println(jedis.get("name"));//执行结果：minxr

        //-----修改数据-----------
        //1、在原来基础上修改
        jedis.append("name","jarorwar");   //很直观，类似map 将jarorwar append到已经有的value之后
        System.out.println(jedis.get("name"));//执行结果:minxrjarorwar

        //2、直接覆盖原来的数据
        jedis.set("name","闵晓荣");
        System.out.println(jedis.get("name"));//执行结果：闵晓荣

        //删除key对应的记录
        jedis.del("name");
        System.out.println(jedis.get("name"));//执行结果：null

        /**
         * mset相当于
         * jedis.set("name","minxr");
         * jedis.set("jarorwar","闵晓荣");
         */
        jedis.mset("name","minxr","jarorwar","闵晓荣");
        System.out.println(jedis.mget("name","jarorwar"));

    }

    /**
     * jedis操作Map
     */
    @Test
    public void testMap(){
        Map<String,String> user=new HashMap<String,String>();
        user.put("name","minxr");
        user.put("pwd","password");
        jedis.hmset("user",user);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name");
        System.out.println(rsmap);

        //删除map中的某个键值
//        jedis.hdel("user","pwd");
        System.out.println(jedis.hmget("user", "pwd")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数1
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  [pwd, name]
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value  [minxr, password]

        Iterator<String> iter=jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }

    }

    /**
     * jedis操作List
     */
    @Test
    public void testList(){
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework",0,-1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet(){
        //添加
        jedis.sadd("sname","minxr");
        jedis.sadd("sname","jarorwar");
        jedis.sadd("sname","闵晓荣");
        jedis.sadd("sanme","noname");
        //移除noname
        jedis.srem("sname","noname");
        System.out.println(jedis.smembers("sname"));//获取所有加入的value
        System.out.println(jedis.sismember("sname", "minxr"));//判断 minxr 是否是sname集合的元素
        System.out.println(jedis.srandmember("sname"));
        System.out.println(jedis.scard("sname"));//返回集合的元素个数
    }


    @Test
    public void testAll()
    {
        setUp();
        testBasicString();
        testMap();
        testList();testSet();
    }

    @Test
    public void test()
    {
        setUp();
        testBasicString();
        testMap();
        testList();testSet();
        Set keys = jedis.keys("*");//列出所有的key，查找特定的key如：redis.keys("foo")
        Iterator t1=keys.iterator() ;
        while(t1.hasNext()){
            Object obj1=t1.next();
            System.out.println(obj1);
        }
    }
}
