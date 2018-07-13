package com.zwh.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zwh.**.mapper")
public class ZwhStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZwhStoreApplication.class, args);
	}
}
