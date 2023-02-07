package SpringBoot_Demo_02.exception;

public class MyException {
    public static void display(MSG responseEnum) {
        throw new CustomException(responseEnum);
    }

    public static void display(MSG responseEnum, Object data) {
        throw new ParamsException(responseEnum, data);
    }
}
