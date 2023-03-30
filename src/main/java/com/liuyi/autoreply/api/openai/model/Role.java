package com.liuyi.autoreply.api.openai.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {

    private String role;
    private String content;
}