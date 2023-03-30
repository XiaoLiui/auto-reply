package com.liuyi.autoreply.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Knife4j 接口文档配置
 * <a href="https://doc.xiaominfo.com/knife4j/documentation/get_start.html">官方文档</a>
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Configuration
@Profile({"dev", "test"})
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("接口文档")
                        .description("yu-auto-reply")
                        .version("1.0"));
    }
}