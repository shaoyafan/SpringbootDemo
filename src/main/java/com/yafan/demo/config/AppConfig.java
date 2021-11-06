package com.yafan.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/04/21:55
 * @Description:
 */

@Configuration
public class AppConfig {

    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl();
    }

}
