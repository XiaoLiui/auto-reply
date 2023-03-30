package com.liuyi.autoreply.controller;

import com.liuyi.autoreply.answerer.OpenAiAnswerer;
import com.liuyi.autoreply.pojo.vo.ChatVO;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @PostMapping("/openai")
    public String openai(@RequestBody ChatVO chatVO) {
        OpenAiAnswerer openAiAnswerer = new OpenAiAnswerer();
        return openAiAnswerer.doAnswer(chatVO.getPrompt());
    }
}
