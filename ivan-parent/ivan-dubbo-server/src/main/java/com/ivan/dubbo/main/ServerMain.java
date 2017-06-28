package com.ivan.dubbo.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: ServerMain
 * @Description:启动类
 * @author zhoulibo
 * @date 2016年8月19日 下午2:57:05
 */
public class ServerMain {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-registry.xml","spring-mybatis.xml"});
		System.out.println("开始启动······");
		context.start();
		System.out.println("end······");
		System.in.read(); // 按任意键退出
	}
}
