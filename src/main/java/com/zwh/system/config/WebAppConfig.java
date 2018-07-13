package com.zwh.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zwh.system.filter.LoginInterceptor;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Value("${file.uploadFolder}")//文件上传虚拟路径
	private String path;
	
	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
		
		interceptorRegistration.addPathPatterns("/web/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("file:" + path);
		super.addResourceHandlers(registry);
	}

	
}
