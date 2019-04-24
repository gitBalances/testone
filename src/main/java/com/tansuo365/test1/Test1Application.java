package com.tansuo365.test1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * https://www.cnblogs.com/ukzq/
 */
@EnableCaching
@SpringBootApplication
@MapperScan(value = {"com.tansuo365.test1.mapper"})
//@ComponentScan(basePackages = {"com.tansuo365.test1.service","com.tansuo365.test1.config.shiro"})
public class Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }

}

