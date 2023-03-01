package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.Hinge;
import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.impl.HingeServiceImpl;
import SpringBoot_Demo_02.service.impl.MenuServiceImpl;
import SpringBoot_Demo_02.service.impl.SlideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class MenuController {

    @Autowired
    private HingeServiceImpl hingeService;

    @Autowired
    private SlideServiceImpl slideService;

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public JsonResult GetMenu(){
        HashMap map=menuService.read();
        if(map.isEmpty()){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(map);
    }

    /***
     * 添加menu方法：数组下标0 写一级目录
     *             数组下标1 写需要添加二级目录名称
     * @param s
     * @return
     */
    @RequestMapping(value = "/addSecondMenu",method = RequestMethod.POST)
    public JsonResult addSecondMenu(String[] s){
        boolean b=menuService.write2(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }

    //添加、删除、修改1         删除、修改2

    @RequestMapping(value = "/addFirstMenu",method = RequestMethod.POST)
    public JsonResult addFirstMenu(String s){
        boolean b=menuService.write1(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }


    @RequestMapping(value = "/alterSecondMenu",method = RequestMethod.POST)
    public JsonResult alterSecondMenu(String[] s){
        boolean b=menuService.alter2(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }


    @RequestMapping(value = "/alterFirstMenu",method = RequestMethod.POST)
    public JsonResult alterFirstMenu(String[] s){
        boolean b=menuService.alter1(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }


    @RequestMapping(value = "/deleteSecondMenu",method = RequestMethod.POST)
    public JsonResult deleteSecondMenu(String[] s){
        boolean b=menuService.delete2(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }


    @RequestMapping(value = "/deleteFirstMenu",method = RequestMethod.POST)
    public JsonResult deleteFirstMenu(String s){
        boolean b=menuService.delete1(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }



}
