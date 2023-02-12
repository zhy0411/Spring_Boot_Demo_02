package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.exception.MSG;
import SpringBoot_Demo_02.exception.MyException;
import SpringBoot_Demo_02.service.impl.SlideServiceImpl;
import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SlideController {
    @Autowired
    private SlideServiceImpl service;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectAll(){
        List<Slide> list= service.SelectAll();
        if(list.size()==0){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS,list);
        return JsonResultData.success(list);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectById(String id){
        Slide slide= service.SelectById(id);
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByName(String name){
        Slide slide= service.SelectByName(name);
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectBySection(String section){
        List<Slide> slide= service.SelectBySection(section);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByLoads(String load){
        List<Slide> slide= service.SelectByLoads(load);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectBySpecifications(String specifications){
        List<Slide> slide= service.SelectBySpecifications(specifications);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByMaterial(String material){
        List<Slide> slide= service.SelectByMaterial(material);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByCharacteristic(String characteristic){
        List<Slide> slide= service.SelectByCharacteristic(characteristic);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByApplication(String application){
        List<Slide> slide= service.SelectByApplication(application);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insertSlide(Slide slide){
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if(service.InsertSlide(slide)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success();
        }else {
            MyException.display(MSG.SYSTEM_PARSE);
            return JsonResultData.error(MSG.SYSTEM_PARSE);
        }
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByAll(String s){
        if(s==""){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        List<Slide> slide= new ArrayList<>();
        slide.add(service.SelectByName(s));
        slide.addAll(service.SelectBySection(s));
        slide.addAll(service.SelectByApplication(s));
        slide.addAll(service.SelectByMaterial(s));
        slide.addAll(service.SelectByCharacteristic(s));
        slide.addAll(service.SelectBySpecifications(s));
        slide.addAll(service.SelectByLoads(s));
        if(slide.size()==0){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS);
        return JsonResultData.success(slide);
    }

}
