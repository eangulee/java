package cn.enjoy.memcached;

import java.util.Date;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.schooner.MemCached.MemcachedItem;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcachedJavaClientTest {

	private SockIOPool pool;
	private MemCachedClient mc; 

	@Before
	public void initPool(){
		//设置mc服务器
		String[] servers = { "192.168.30.10:11211","192.168.30.10:11212", "192.168.30.10:11213" };
		// 创建一个Socked连接池实例
		pool = SockIOPool.getInstance();
		// 向连接池设置服务器和权重
		pool.setServers(servers);
		//设置读取超时时间
		pool.setSocketTO(3000*10);
		//设置连接超时时间,0不超时
		pool.setSocketConnectTO(0);
		//生存检查
		pool.setAliveCheck(true);

		pool.initialize();

		//pool.setHashingAlg();
		
		System.out.println("建立与MC的连接..");
		//创建客户端

		mc = new MemCachedClient();


	}
	
	@After
	public void destroy(){
		//pool.shutDown();
		System.out.println("断开与MC的连接..");
	}
	
	@Test
	public void test_add(){
		//清除所有
		mc.flushAll();
		

		//添加
		boolean flag = mc.add("a", "a");
		System.out.println("add a=a "+flag);
		flag = mc.add("b", "b");
		System.out.println("add b=b "+flag);
		flag = mc.add("c", "c");
		System.out.println("add c=c "+flag);
		flag = mc.add("c", "c1");
		System.out.println("add c=c1 "+flag);
		
		//获取数据
		Object a = mc.get("a");
		Object b = mc.get("b");
		Object c = mc.get("c");
		System.out.println("get a="+a);
		System.out.println("get b="+b);
		System.out.println("get c="+c);
	}
	
	@Test
	public void test_set(){
		//清除所有
		mc.flushAll();
		
		//添加
		boolean flag = mc.set("a", "a");
		System.out.println("set a=a "+flag);
		flag = mc.set("b", "b");
		System.out.println("set b=c "+flag);
		flag = mc.add("c", "c");
		System.out.println("add c=c "+flag);
		flag = mc.set("c", "c1");
		System.out.println("set c=c1 "+flag);
		
		//获取数据
		Object a = mc.get("a");
		Object b = mc.get("b");
		Object c = mc.get("c");
		System.out.println("get a="+a);
		System.out.println("get b="+b);
		System.out.println("get c="+c);
	}
	
	@Test
	public void test_prepend(){
		//清除所有
		mc.flushAll();
		
		//添加
		boolean flag = mc.set("a", "a");
		System.out.println("set a=a "+flag);
		flag = mc.prepend("a", "pre_");
		System.out.println("prepend a=pre_ "+flag);
		mc.add("b", "bbb");
		flag = mc.prepend("b", "pre_");
		System.out.println("prepend b=pre_ "+flag);
		
		//获取数据
		Object a = mc.get("a");
		Object b = mc.get("b");
		Map<String, Object> multi = mc.getMulti(new String[]{"a","b"});
		System.out.println(multi);
	}
	
	@Test
	public void test_append(){
		//清除所有
		mc.flushAll();
		
		//添加
		boolean flag = mc.set("a", "a");
		System.out.println("set a=a "+flag);
		flag = mc.append("a", "_append");
		System.out.println("prepend a=_append "+flag);
		flag = mc.append("b", "_append");
		System.out.println("prepend b=_append "+flag);
		
		//获取数据
		Object a = mc.get("a");
		Object b = mc.get("b");
		System.out.println("get a="+a);
		System.out.println("get b="+b);
	}
	
	@Test
	public void test_expiry() throws Exception{
		//清除所有
		mc.flushAll();
		
		//添加(带过期时间)
		boolean flag = mc.add("a", "a", new Date(1000));
		System.out.println("add a=a 1000 "+flag);
		flag = mc.set("b", "b", new Date(2000));
		System.out.println("set b=b 2000 "+flag);
		
		//立即获取数据
		Object a = mc.get("a");
		Object b = mc.get("b");
		System.out.println("get a="+a);
		System.out.println("get b="+b);
				
		//延迟3s
		Thread.sleep(3000);
		
		//3s后获取数据
		a = mc.get("a");
		b = mc.get("b");
		System.out.println("after 3s get a="+a);
		System.out.println("after 3s get b="+b);
	}
	

}
