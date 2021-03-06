package com.james.cache.redpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.apache.catalina.tribes.util.UUIDGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StopWatch;

import com.james.cache.basic.Basic;
import com.james.cache.utils.JedisUtils;

/**
 * 多线程模拟用户抢红包
 */
public class GetRedPack {
	// 抢红包的方法
	static public void getHongBao() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(Basic.threadCount);// 20 //发枪器
		String luaScript = getLuaSciprt();//获取lua脚本
		JedisUtils jedisUtils = new JedisUtils(Basic.ip, Basic.port, Basic.auth);
		String scriptHash = jedisUtils.scriptLoad(luaScript);//生成lua脚本sha值
;		for (int i = 0; i < Basic.threadCount; i++) { // 20线程
			Thread thread = new Thread() {
				public void run() {
					// 拿到jedis连接
					JedisUtils jedis = new JedisUtils(Basic.ip, Basic.port, Basic.auth);
					while (true) {

						// 模拟一个用户ID使用UUID XXXX
						String userid = UUID.randomUUID().toString();

						// 抢红包 eval 可以直接调用我们LUA脚本里的业务代码 object ={rid_1:1, money:9, userid:001}
//						Object object = jedis.eval(Basic.getHongBaoScript, 4, Basic.hongBaoPoolKey,
//								Basic.hongBaoDetailListKey, Basic.userIdRecordKey, userid);
						
						Object object = jedis.evalsha(scriptHash, 4, Basic.hongBaoPoolKey,
								Basic.hongBaoDetailListKey, Basic.userIdRecordKey, userid);

						if (null != object) {
							System.out.println("用户ID号：" + userid + " 抢到红包的详情是 " + object);
						} else {
							if (jedis.llen(Basic.hongBaoPoolKey) == 0) {
								break;
							}
						}
					}
					latch.countDown();
				}
			};
			thread.start();

		}
		latch.await();
	}

	static String getLuaSciprt() {
		// 读取lua脚本
		Resource getRedLuaRes = new ClassPathResource("get-red2.lua");
		String path = "";
		String luaScript = "";
		try {
			path = getRedLuaRes.getFile().getPath();
			System.out.println("path:" + path);
			String encoding = "UTF-8";
			File file = new File(path);
			Long filelength = file.length();
			byte[] filecontent = new byte[filelength.intValue()];
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
			luaScript = new String(filecontent, encoding);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return luaScript;
	}

}
