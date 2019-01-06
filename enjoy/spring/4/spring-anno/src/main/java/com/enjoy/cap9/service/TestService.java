package com.enjoy.cap9.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enjoy.cap9.dao.TestDao;

@Service
public class TestService {
//	@Qualifier("testDao2")
//	@Autowired//(required=false)
	//效果是一样的,与Autowired一样可以装配bean
	//1,不支持Primary功能
	//2,不支持Autowired false
	@Resource//(name="testDao2")//支持按bean名字和不指定按类型注入，不支持空，jsr250规范，不依赖spring,支持Primary功能
//	@Inject//需导入javax.inject包，按类型注入，不支持空，jsr330规范，不依赖spring，支持Primary功能
	private TestDao testDao;
	
	public void println(){
		System.out.println(testDao);
	}
}
