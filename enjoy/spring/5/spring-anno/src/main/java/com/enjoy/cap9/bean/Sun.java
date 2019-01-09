package com.enjoy.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sun {
	private Moon moon;
	
	public Sun(Moon moon){
		this.moon = moon;
		System.out.println("..Constructor................"+this.moon.toString());
	}
	public Moon getMoon() {
		return moon;
	}

	
	public void setMoon(Moon moon) {
		this.moon = moon;
	}

	@Override
	public String toString() {
		return "Sun [moon=" + moon + "]";
	}
}
