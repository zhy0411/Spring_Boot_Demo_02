package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.Admin;
import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController{
    @Autowired
    private AdminServiceImpl service;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String id, String password){//JsonResult返回json格式
        if(id==""||password==""){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
//            return "用户名密码不能为空";
        }

        if (service.login(id,password)){
            String s="hello"+id;
            MyException.display(MSG.SUCCESS,s);
            return JsonResultData.success(s);
        }
        MyException.display(MSG.LOGIN_ERROR);
        return JsonResultData.error(MSG.LOGIN_ERROR);
//        return "用户名或密码错误";
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public JsonResult updatePassword(Admin admin){
        if(admin==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if (service.updatePassword(admin)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
    }


}
