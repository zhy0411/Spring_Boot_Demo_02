package SpringBoot_Demo_02.controller;

import generator.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AdminController{
    @Autowired
    private AdminServiceImpl service;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String id,String password){
        if(id==""||password==""){
            return "用户名密码不能为空";
        }

        if (service.login(id,password)){
            return "hello"+id;
        }
        return "用户名或密码错误";
    }
}
