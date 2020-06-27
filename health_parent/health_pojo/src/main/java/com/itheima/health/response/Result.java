package com.itheima.health.response;

import com.itheima.health.response.constant.CodeConstant;
import lombok.Data;

/**
 * 响应的实体类
 */
@Data
public class Result {

    private String code;
    private String message;
    private boolean fiag;

    private Object data;

    public Result() {

    }

    public Result(String code, String message, boolean fiag) {
        this.code = code;
        this.message = message;
        this.fiag = fiag;
    }

    public Result(String code, String message, boolean fiag, Object data) {
        this.code = code;
        this.message = message;
        this.fiag = fiag;
        this.data = data;
    }

    /**
     * 执行成功,构造方法
     */
    public Result(Object data) {
        this.code = CodeConstant.SUCCESS;
        this.fiag = true;
        this.data = data;
    }

    /**
     * 执行失败的构造
     */
    public Result(String code, String message) {
        this.code = code;
        this.message = message;
        this.fiag = false;
    }

}
