package com.eangulee.springdemo.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MainFilter implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		AnnotationMetadata ann = metadataReader.getAnnotationMetadata();
		System.out.println("AnnotationMetadata:"+ann.getClassName());
		Resource resource = metadataReader.getResource();
		System.out.println("Resource:"+resource.getURL());
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		System.out.println("ClassMetadata:"+classMetadata.getClassName());
		System.out.println("---------------------------------------------");
		String className =classMetadata.getClassName();
		if(className.contains("Controller"))
			return true;		
		return false;
	}

}
