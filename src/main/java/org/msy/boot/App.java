package org.msy.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"org.msy.boot.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(org.msy.boot.App.class, args);
    }


}
