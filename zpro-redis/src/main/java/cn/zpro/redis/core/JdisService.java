package cn.zpro.redis.core;


import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectOutput;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.TreeMap;


/**
 * @author zhanggl
 */
public class JdisService {
    static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();

    private Jedis jedis;

    public Jedis getReidsConn(){
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("116.196.94.14", 6379);
        return jedis;
    }


    private void setObj(Object o) throws Exception {

    }

    public static void main(String[] args) {

    }


}
