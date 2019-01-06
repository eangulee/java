package com.james.cache.services;

import java.util.List;
import java.util.Map;

public interface ShopService {
	  public void updateToken(String token, String user, String item);
	  public String checkToken(String token);
	  public Long addToCart(String token, String item, int count);
	  public String genOrderId(String item,float money);
	  public boolean appendToUser(String user,String orderId);
	  public List<Map<String,String>> getAllOrdersByUser(String user);
	  public long hlen(String key);
	  public Map<String,String> hgetAll(String key);
	  public boolean removeOldTokens(long limit);
}
