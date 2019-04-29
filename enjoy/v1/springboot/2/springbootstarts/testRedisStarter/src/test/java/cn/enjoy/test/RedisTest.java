package cn.enjoy.test;

import cn.enjoy.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Resource
    private Jedis jedis;


    @Test
    public  void test() {
        jedis.set("enjoy","enjoy");
        String enjoy = jedis.get("enjoy");
        System.out.println(enjoy);
    }

}

