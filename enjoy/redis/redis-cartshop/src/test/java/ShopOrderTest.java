
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.cache.services.ShopService;
import com.james.cache.utils.JedisUtils;

import org.junit.runners.MethodSorters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopOrderTest {

	@Resource(name = "shopServiceImpl")
	private ShopService shopService;
	
	@Test
	public void orderTest() throws InterruptedException {
		String userId = "user:1";
		// 生成多个订单信息
		for (int i = 1; i <= 3; i++) {
			String orderId = shopService.genOrderId("iphon" + i, 1000.99f * i);
			shopService.appendToUser(userId, orderId);//添加到用户订单队列			
		}
		
		System.out.println("查询用户所有订单信息");
		System.out.println("用户："+userId+"所有信息：");
		List<Map<String, String>> allOrders = shopService.getAllOrdersByUser(userId);
		for(Map<String,String> map:allOrders) {
			System.out.println("----------------------------------------------");
			for(Map.Entry<String, String> kvp:map.entrySet()) {
				System.out.println(kvp.getKey()+":"+kvp.getValue());
			}
		}		
	}

}