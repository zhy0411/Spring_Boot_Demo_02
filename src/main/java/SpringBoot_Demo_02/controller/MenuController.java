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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuController {

    @Autowired
    private HingeServiceImpl hingeService;

    @Autowired
    private SlideServiceImpl slideService;

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public JsonResult GetMenu(){
        HashMap map=menuService.read();
        if(map.isEmpty()){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(map);
    }


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public JsonResult AlterMenu(String[] s){
        boolean b=menuService.write(s);
        if(b){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(MSG.SUCCESS);
    }



//    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    public JsonResult GetList(){
//        List<Hinge> hinges= hingeService.FindByAll();
//        List<Slide> slides=slideService.SelectAll();
//        List<List<String>> list=new ArrayList<>();
//        List<String> stringList=new ArrayList<>();
//        for (int i = 0; i < hinges.size(); i++) {
//            stringList.add(hinges.get(i).getName());
//        }
//        list.add(stringList);
//        stringList=new ArrayList<>();
//        for (int i = 0; i < slides.size(); i++) {
//            stringList.add(hinges.get(i).getName());
//        }
//        list.add(stringList);
//        if(list.size()==0){
//            MyException.display(MSG.ERROR);
//            return JsonResultData.error(MSG.ERROR);
//        }else {
//            MyException.display(MSG.SUCCESS);
//            return JsonResultData.success(list);
//        }
//    }



}
