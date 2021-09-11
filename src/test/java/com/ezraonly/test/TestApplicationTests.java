package com.ezraonly.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestApplication.class})// 指定启动类
class TestApplicationTests {

    @Test
    void contextLoads() {
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 功能描述:
     * 〈〉
     *  -Xms1536M -Xmx1536M -Xmn512M -Xss256K -XX:SurvivorRatio=6 -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=256M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly
     * @Author:lwy
     * @Date: 2021/9/11 18:09
     */
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10000; i++) {
            String result = restTemplate.getForObject("http://localhost:8080/user/process", String.class);
            Thread.sleep(1000);
        }
    }
}
