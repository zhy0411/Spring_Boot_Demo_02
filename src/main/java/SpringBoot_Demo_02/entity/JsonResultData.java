package SpringBoot_Demo_02.entity;

import SpringBoot_Demo_02.exception.MSG;

public class JsonResultData extends JsonResult{
    // 默认成功方法
    public static JsonResult success() {
        return new JsonResult(MSG.SUCCESS.getCode(), MSG.SUCCESS.getMessage(), MSG.SUCCESS.getSuccess(),"");
    }
    // 自定义成功数据方法
    public static JsonResult success(Object data) {
        return new JsonResult(MSG.SUCCESS.getCode(), MSG.SUCCESS.getMessage(), MSG.SUCCESS.getSuccess(),data);
    }

    // 自定义成功数据、消息方法
    public static JsonResult success(String message, Object data) {
        return new JsonResult(MSG.SUCCESS.getCode(), message, MSG.SUCCESS.getSuccess(),data);
    }

    // 默认失败方法
    public static JsonResult error() {
        return new JsonResult(MSG.ERROR.getCode(), MSG.ERROR.getMessage(), MSG.ERROR.getSuccess(),"");
    }

    // 自定义枚举消息方法
    public static JsonResult error(MSG msg) {
        return new JsonResult(msg.getCode(), msg.getMessage(), msg.getSuccess(),"");
    }

    // 自定义失败消息方法
    public static JsonResult error(String message) {
        return new JsonResult(MSG.ERROR.getCode(), message, MSG.ERROR.getSuccess(),"");
    }

    // 自定义失败消息、数据方法
    public static JsonResult error(String message, Object data) {
        return new JsonResult(MSG.ERROR.getCode(), message, MSG.ERROR.getSuccess(),data);
    }
    // 自定义失败消息(枚举)、数据方法
    public static JsonResult error(MSG msg, Object data) {
        return new JsonResult(msg.getCode(), msg.getMessage(), msg.getSuccess(),data);
    }
}
