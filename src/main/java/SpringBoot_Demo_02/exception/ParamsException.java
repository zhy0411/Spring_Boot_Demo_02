package SpringBoot_Demo_02.exception;

public class ParamsException extends RuntimeException{
    private MSG responseEnum;

    private Object data;

    public ParamsException(MSG responseEnum,Object data) {
        this.responseEnum = responseEnum;
        this.data = data;
    }

    public MSG getResponseEnum() {
        return responseEnum;
    }

    public Object getData() {
        return data;
    }
}
