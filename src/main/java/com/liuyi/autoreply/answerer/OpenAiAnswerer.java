package com.liuyi.autoreply.answerer;

import com.liuyi.autoreply.answerer.Answerer;
import com.liuyi.autoreply.api.openai.OpenAiApi;
import com.liuyi.autoreply.api.openai.model.CreateCompletionRequest;
import com.liuyi.autoreply.api.openai.model.CreateCompletionResponse;
import com.liuyi.autoreply.api.openai.model.Role;
import com.liuyi.autoreply.config.OpenAiConfig;
import com.liuyi.autoreply.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OpenAi 回答者
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Slf4j
public class OpenAiAnswerer implements Answerer {

    private final OpenAiApi openAiApi = SpringContextUtils.getBean(OpenAiApi.class);

    private final OpenAiConfig openAiConfig = SpringContextUtils.getBean(OpenAiConfig.class);

    @Override
    public String doAnswer(String prompt) {
        ArrayList<Role> message = new ArrayList<>();
        CreateCompletionRequest request = new CreateCompletionRequest();
        message.add(Role.builder().role("user").content(prompt).build());
        request.setPrompt(prompt);
        request.setModel(openAiConfig.getModel());
        request.setTemperature(0);
        request.setMax_tokens(1024);
        request.setMessages(message);
        CreateCompletionResponse response = openAiApi.createCompletion(request, openAiConfig.getApiKey());
        List<CreateCompletionResponse.ChoicesItem> choicesItemList = response.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletionResponse.ChoicesItem::getText)
                .collect(Collectors.joining());
        log.info("OpenAiAnswerer 回答成功 \n 答案：{}", answer);
        return answer;
    }
}
