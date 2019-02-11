package cn.enjoy.memcached;

import java.util.concurrent.TimeoutException;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.google.code.ssm.providers.CacheException;

public class MemCacheUtils implements Cache {

	//Cache的实际操作类
	private com.google.code.ssm.Cache cache;

	public com.google.code.ssm.Cache getCache() {
		return cache;
	}

	public void setCache(com.google.code.ssm.Cache cache) {
		this.cache = cache;
	}
	
	//缓存管理器名称
	public String getName() {
		return this.cache.getName();
	}

	//NativeCache管理对象
	public Object getNativeCache() {
		return this.cache;
	}
	
	//读取缓存
	public ValueWrapper get(Object key) {
		Object object = null;
		try {
			object = this.cache.get((String) key, Object.class);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return (object != null ? new SimpleValueWrapper(object) : null);
	}

	//添加或修改缓存
	public void put(Object key, Object value, int secondes) {
		try {
			this.cache.set((String) key, secondes, value, Object.class);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	//添加或修改缓存,默认1小时
	public void put(Object key, Object value) {
		try {
			this.cache.set((String) key, 60 * 60, value, Object.class);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	//删除缓存
	public void evict(Object key) {
		try {
			this.cache.delete((String) key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	//清空所有
	public void clear() {
		try {
			this.cache.flush();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	//获取指定类型缓存
	public <T> T get(Object key, Class<T> type) {
		T object = null;
		try {
			object = this.cache.get((String) key, type);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return object;
	}

	//如果key存在则添加,不存在则不添加
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return null;
	}

}
