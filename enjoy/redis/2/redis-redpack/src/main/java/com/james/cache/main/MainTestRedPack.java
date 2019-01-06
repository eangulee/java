package com.james.cache.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSONObject;
import com.james.cache.redpack.GenRedPack;
import com.james.cache.redpack.GetRedPack;
import com.james.cache.utils.JedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.util.JedisURIHelper;


/**
 * @author 作者：作者： jing lee
 * @version 创建时间：2019年1月4日 上午11:02:11 
 * @description 说明：
 *
 */
public class MainTestRedPack {

	public static void main(String[] args) throws InterruptedException {
		
		GenRedPack.genHongBao();//初始化红包
		
		GetRedPack.getHongBao();//从红包池抢红包
		
		
		//		TestPython();
	}

	
	
	/**
	 * @author 作者：作者： jing lee
	 * @version 创建时间：2019年1月4日 上午11:03:38 
	 * @description 说明：
	 *
	 */
	private static void TestPython() {
		int a = 18;
		int b = 23;
		try {
//			String rootPath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
			Resource pythonRes = new ClassPathResource("test.py");
			String path = pythonRes.getFile().getPath();
			System.out.println("path:" + path);

			String[] args = new String[] { "python", path, String.valueOf(a), String.valueOf(b) };
			Process proc = Runtime.getRuntime().exec(args);// 执行py文件

			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}