package Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Wanghj
 * @Package Redis
 * @date 2021/4/12 14:12
 */
public class multiTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 如果设置了密码，需要认证
        //jedis.auth("password");
        System.out.println( jedis.ping());  //查看是否连通
        jedis.flushDB();
        Transaction multi = jedis.multi();

        try {
            multi.set("name","zhangsan");
            int i=1/0;
            multi.set("name1", "lisi");
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();
        } finally {
            System.out.println( jedis.get("name"));
            System.out.println( jedis.get("name1"));
        }

    }
}
