package cn.enjoy.memcached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext-cache.xml" })
public class SpringMemcachedTest{
	
	@Autowired
	private SimpleCacheManager cacheManager;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test1(){
		try {
			Cache cache = cacheManager.getCache("memcached");
			cache.put("zhangsan", "abc");
			ValueWrapper wrapper = cache.get("zhangsan");
			System.out.println("get zhangsan from cache=" + wrapper.get().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			//UserService必须由spring管理(初始化),否则cache注解无法生效
			Object value = userService.queryByName("lisi");
			System.out.println(value);
			
			Cache cache = cacheManager.getCache("memcached");
			ValueWrapper wrapper = cache.get("lisi");
			if(wrapper!=null){
				System.out.println("get lisi from cache=" + wrapper.get().toString());
			}else{
				System.out.println("get lisi from cache=null");
			}
			
			userService.deleteByName("lisi");
			wrapper = cache.get("lisi");
			if(wrapper!=null){
				System.out.println("get lisi from cache=" + wrapper.get().toString());
			}else{
				System.out.println("get lisi from cache=null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public  void test3() {
		Object value1 = userService.queryById("ID2");
		System.out.println(value1);
		Object value2 = userService.queryById("ID2");
		System.out.println(value2);
	}
	
	@Test
	public void test4(){
		try {
			//UserService必须由spring管理(初始化),否则cache注解无法生效
			Object value2 = userService.queryById("ID2");
			Object value3 = userService.queryById("ID3");
			Object value4 = userService.queryById("ID4");
			
			Cache cache = cacheManager.getCache("memcached");
			ValueWrapper wrapper2 = cache.get("ID2");
			ValueWrapper wrapper3 = cache.get("ID3");
			ValueWrapper wrapper4 = cache.get("ID4");
			if(wrapper2!=null){
				System.out.println("get ID2 from cache=" + wrapper2.get().toString());
			}else{
				System.out.println("get ID2 from cache=null");
			}
			if(wrapper3!=null){
				System.out.println("get ID3 from cache=" + wrapper3.get().toString());
			}else{
				System.out.println("get ID3 from cache=null");
			}
			if(wrapper4!=null){
				System.out.println("get ID4 from cache=" + wrapper4.get().toString());
			}else{
				System.out.println("get ID4 from cache=null");
			}
			
			//清空
			userService.deleteAll();
			
			wrapper2 = cache.get("ID2");
			wrapper3 = cache.get("ID3");
			wrapper4 = cache.get("ID4");
			if(wrapper2!=null){
				System.out.println("get ID2 from cache=" + wrapper2.get().toString());
			}else{
				System.out.println("get ID2 from cache=null");
			}
			if(wrapper3!=null){
				System.out.println("get ID3 from cache=" + wrapper3.get().toString());
			}else{
				System.out.println("get ID3 from cache=null");
			}
			if(wrapper4!=null){
				System.out.println("get ID4 from cache=" + wrapper4.get().toString());
			}else{
				System.out.println("get ID4 from cache=null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
