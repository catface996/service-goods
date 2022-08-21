package com.catface.goods;

import com.catface.common.util.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author by catface
 * @date 2020/12/13
 */
@Slf4j
@EnableFeignClients(basePackages = {
        "com.catface.rss.api"
})
@SpringBootApplication(
        scanBasePackages = {"com.catface"}
)
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
        log.info("GoodsApplication start success!");
        System.out.println("GoodsApplication start success!");
        System.out.println(EnvUtil.getSwaggerUrl());
        System.out.println(EnvUtil.getDocUrl());
    }
}
