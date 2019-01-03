package com.eangulee.springdemo.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.eangulee.springdemo.model.Tiger;

public class EanguleeImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean flag = registry.containsBeanDefinition("getCat");
		if (flag) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Tiger.class);
			registry.registerBeanDefinition("tiger", rootBeanDefinition);
		}
	}
}
