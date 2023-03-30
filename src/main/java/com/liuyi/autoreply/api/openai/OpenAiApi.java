package com.liuyi.autoreply.api.openai;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;

import com.liuyi.autoreply.api.openai.model.CreateCompletionRequest;
import com.liuyi.autoreply.api.openai.model.CreateCompletionResponse;
import com.liuyi.autoreply.common.ErrorCode;
import com.liuyi.autoreply.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * OpenAi 接口
 * <a href="https://platform.openai.com/docs/api-reference">参考文档</a>
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 **/
@Service
public class OpenAiApi {

    /**
     * 补全
     *
     * @param request
     * @param openAiApiKey
     * @return
     */
    public CreateCompletionResponse createCompletion(CreateCompletionRequest request, String openAiApiKey) {
        if (StringUtils.isBlank(openAiApiKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未传 openAiApiKey");
        }
        String url = "https://api.openai.com/v1/chat/completions";
        String json = JSONUtil.toJsonStr(request);
        System.out.println(openAiApiKey);
        System.out.println(request);
        System.out.println(json);
        String result = HttpRequest.post(url)
                .header("Authorization", "Bearer " + openAiApiKey)
                .header("Content-Type", "application/json")
                .body(json)
                .execute()
                .body();
        return JSONUtil.toBean(result, CreateCompletionResponse.class);
    }
}
