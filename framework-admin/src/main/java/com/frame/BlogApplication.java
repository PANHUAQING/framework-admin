package com.frame;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: BlogApplication
 * @Description: springboot 启动类
 * @author panhuaqing
 * @date 2018年7月26日 下午11:00:27
 *
 */
@SpringBootApplication
@ServletComponentScan
// 启动事务
@EnableTransactionManagement
@ImportResource("classpath:config/springboot-transaction.xml")
// 持久层扫描路径
//@MapperScan("com.frame.*.mapper") 在mapper文件上家@Mapper 注解可替代
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
