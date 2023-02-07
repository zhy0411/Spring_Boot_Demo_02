package SpringBoot_Demo_02.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MSG {
    // TODO 20xxx 基础消息
    SUCCESS(20000,"操作成功",true),
    ERROR(20001,"操作失败",false),

    // TODO 30xxx 身份证认证
    LOGIN_ERROR(30000,"账号或密码错误",false),
    USER_STATUS_ERROR(30001,"账号被停用",false),
    SMS_CODE_ERROR(30002,"短信验证码错误",false),
    VERIFY_CODE_ERROR(30002,"验证码错误",false),

    // TODO 40xxx 基础业务错误
    UPDATE_USER_INFO_ERROR(40000,"更新用户详情失败",false),
    UPDATE_USER_PASSWORD_ERROR(40001,"更新密码失败",false),
    OLD_PASSWORD_ERROR(40002,"旧密码错误",false),
    REPEAT_PASSWORD_ERROR(40003,"确认密码不一致",false),
    UPDATE_USER_AVATAR_ERROR(40004,"更新用户头像失败",false),
    ACCOUNT_EXIST_ERROR(40006,"账号已被使用",false),
    MOBILE_EXIST_ERROR(40007,"手机号已被使用",false),
    UPLOAD_FILE_ERROR(40008,"上传文件失败",false),
    UPLOAD_FILE_SUFFIX_ERROR(40009,"不支持该文件类型",false),
    UPLOAD_FILE_SIZE_ERROR(40010,"上传文件大小不合法",false),
    READ_FILE_ERROR(40011,"解析文件错误",false),
    READ_TEMPLATE_ERROR(40012,"上传文件模板不合法",false),
    SMS_WAIT_ERROR(40013,"短信发送太快了~请稍后再试",false),
    SMS_UPPER_LIMIT_ERROR(40014,"今天发送短信已上限",false),
    PARAMS_ERROR(40015,"参数不合法",false),

    // TODO 50xxx 基础系统错误
    SYSTEM_INDEX_OUT_OF_BOUNDS(50000, "系统错误，数组越界！",false),
    SYSTEM_ARITHMETIC_BY_ZERO(50001, "系统错误，无法除零！",false),
    SYSTEM_NULL_POINTER(50002, "系统错误，空指针！",false),
    SYSTEM_NUMBER_FORMAT(50003, "系统错误，数字转换异常！",false),
    SYSTEM_PARSE(50004, "系统错误，解析异常！",false),
    SYSTEM_IO(50005, "系统错误，IO输入输出异常！",false),
    SYSTEM_FILE_NOT_FOUND(50006, "系统错误，文件未找到！",false),
    SYSTEM_CLASS_CAST(50007, "系统错误，类型强制转换错误！",false),
    SYSTEM_PARSER_ERROR(50008, "系统错误，解析出错！",false),
    SYSTEM_DATE_PARSER_ERROR(50009, "系统错误，日期解析出错！",false),

    // TODO 51xxx 未知系统错误
    SYSTEM_ERROR(51000, "系统繁忙，请稍后再试！",false),
    SYSTEM_OPERATION_ERROR(51001, "操作失败，请重试或联系管理员",false),
    SYSTEM_ERROR_ZUUL(51002, "请求系统过于繁忙，请稍后再试！",false);

    // 响应码
    private Integer code;
    // 响应消息
    private String message;
    // 是否成功
    private Boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
