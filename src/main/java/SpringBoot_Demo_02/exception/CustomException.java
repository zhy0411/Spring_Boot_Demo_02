package SpringBoot_Demo_02.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private MSG responseEnum;

    public CustomException(MSG responseEnum) {
        super("具体异常信息为：" + responseEnum.getMessage());
        this.responseEnum = responseEnum;
    }

    public MSG getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(MSG responseEnum) {
        this.responseEnum = responseEnum;
    }

}
