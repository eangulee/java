package cn.enjoy.memcached;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Future;

import net.rubyeye.xmemcached.HashAlgorithm;
import net.spy.memcached.ConnectionFactoryBuilder.Locator;
import net.spy.memcached.DefaultConnectionFactory;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.MemcachedConnection;
import net.spy.memcached.internal.GetFuture;
import net.spy.memcached.internal.OperationFuture;
import net.spy.memcached.spring.MemcachedClientFactoryBean;

import org.junit.Test;


public class SpymemcachedTest{

	@Test
	public void test1() {
		try {
			// 建立MemcachedClient 实例,并指定memcached服务的IP地址和端口号
			MemcachedClient mc = new MemcachedClient(new InetSocketAddress("192.168.30.10", 11211));

			// 将key值，过期时间(秒)和要缓存的对象set到memcached中
			// 使用了Futrue模式支持来异步
			Future<Boolean> b = mc.set("a1", 90000, "a");
			mc.set("a2", 90000, "a2");
			mc.set("a3", 90000, "a3");
			mc.set("a4", 90000, "a4");
			if (b.get().booleanValue() == true) {
				Object obj = mc.get("a1");
				System.out.println(obj);
				mc.shutdown();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			// 建立MemcachedClient 实例,并指定memcached服务的IP地址和端口号
			MemcachedClient mc = new MemcachedClient(new InetSocketAddress("192.168.30.10", 11211));
			// 将key值，过期时间(秒)和要缓存的对象set到memcached中
			// 使用了Futrue模式支持来异步
			OperationFuture<Boolean> flush = mc.flush();
			if(flush.get().booleanValue()==false){
				System.out.println("清空缓存失败");
				return;
			}
			Future<Boolean> b = mc.add("a", 900, "a");
			if (b.get().booleanValue() == true) {
				Object obj = mc.get("a");
				System.out.println(obj);
				mc.shutdown();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try {
			// 建立MemcachedClient 实例,并指定memcached服务的IP地址和端口号
			MemcachedClient mc = new MemcachedClient(
					new InetSocketAddress("192.168.30.10", 11211),
					new InetSocketAddress("192.168.30.10", 11212),
					new InetSocketAddress("192.168.30.10", 11213));
			// 将key值，过期时间(秒)和要缓存的对象set到memcached中
			// 使用了Futrue模式支持来异步
			OperationFuture<Boolean> flush = mc.flush();
			if(flush.get().booleanValue()==false){
				System.out.println("清空缓存失败");
				return;
			}
			Future<Boolean> aa = mc.add("a", 900, "aa");
			if (aa.get().booleanValue() == true) {
				GetFuture<Object> asyncGet = mc.asyncGet("a");
				if(asyncGet.get()!=null) {
					System.out.println("asyncGet:"+asyncGet.get());
				}
			}
			Future<Boolean> bb = mc.add("b", 900, "bb");
			if (bb.get().booleanValue() == true) {
				Object obj = mc.get("b");
				System.out.println("get"+obj);
				mc.shutdown();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
