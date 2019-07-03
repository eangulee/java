package com.eangulee.springdemo.config;

import java.util.Date;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.eangulee.springdemo.utils.DateUtil;
import com.eangulee.springdemo.utils.DateUtils;

public class MorningCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		Date currentDateTime = DateUtil.getCurrentDateTime();
		String h = DateUtil.getHour(currentDateTime);
		int hour = Integer.parseInt(h);
		System.out.println("current hour:"+h);
		if(hour < 12)
			return true;
		return false;
	}
}
