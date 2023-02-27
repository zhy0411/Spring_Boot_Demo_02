package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.Corporation;
import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.impl.CorporationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CorporationController {

    @Autowired
    private CorporationServiceImpl service;

    @RequestMapping(value = "/corporation",method = RequestMethod.POST)
    public JsonResult select(){
        Corporation corporation=service.select();
        if(corporation==null){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }else {
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(corporation);
        }
    }
}
