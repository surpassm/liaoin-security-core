package com.liaoin.security.core.validate.bean;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * @author mc
 * @version 1.0v
 * redis存储的内容必须序列化
 */
@Data
public class ValidateCode implements Serializable {

    private String code;

    private LocalDateTime expireTime;

	public ValidateCode(){}

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
