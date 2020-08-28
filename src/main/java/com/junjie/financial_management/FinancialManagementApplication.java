package com.junjie.financial_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//接口需要使用这个配置扫描到 IOC 容器里面
@MapperScan(value = "com.junjie.financial_management.mapper")
@SpringBootApplication
public class FinancialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialManagementApplication.class, args);
	}

}
