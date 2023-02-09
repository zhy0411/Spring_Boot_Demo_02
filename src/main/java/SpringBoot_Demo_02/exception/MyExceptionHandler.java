package SpringBoot_Demo_02.exception;
//<!--            <groupId>io.springfox</groupId>-->
//<!--            <artifactId>springfox-swagger2</artifactId>-->
//<!--            <version>2.9.2</version>-->
//<!--        </dependency>-->

import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public JsonResult returnCustomException(CustomException e) {
        e.printStackTrace();
        return JsonResultData.error(e.getResponseEnum());
    }

    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public JsonResult returnCustomException(ParamsException e) {
        return JsonResultData.error(e.getResponseEnum(),e.getData());
    }

    // 除零异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public JsonResult arithmeticException(ArithmeticException e) {
        e.printStackTrace();
        return JsonResultData.error(MSG.SYSTEM_ARITHMETIC_BY_ZERO);
    }

    // 空指针
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public JsonResult nullException(NullPointerException e) {
        e.printStackTrace();
        return JsonResultData.error(MSG.SYSTEM_NULL_POINTER);
    }

    // 数组越界
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public JsonResult arrayIndexException(ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        return JsonResultData.error(MSG.SYSTEM_INDEX_OUT_OF_BOUNDS);
    }

    // 未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult unknown(Exception e) {
        e.printStackTrace();
        return JsonResultData.error(MSG.SYSTEM_OPERATION_ERROR);
    }

}
