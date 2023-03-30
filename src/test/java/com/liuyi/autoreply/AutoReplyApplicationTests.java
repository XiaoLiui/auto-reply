package com.liuyi.autoreply;

import com.liuyi.autoreply.answerer.OpenAiAnswerer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoReplyApplicationTests {

    @Test
    void contextLoads() {
        OpenAiAnswerer openAiAnswerer = new OpenAiAnswerer();
        String answer = openAiAnswerer.doAnswer("你好");
        System.out.println(answer);
    }

}
