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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    @RequestMapping(value = "/insertCorporation",method = RequestMethod.POST)
    public JsonResult insert(Corporation corporation){
        if(corporation==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        corporation.setUrl("/opt/dome/Spring_Boot_Demo_02/img/corporation");
        if (service.Insert(corporation)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/deleteCorporation",method = RequestMethod.POST)
    public JsonResult delete(String name){
        if(name==null || name.equals("")){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if (service.Delete(name)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/updateCorporation",method = RequestMethod.POST)
    public JsonResult update(Corporation corporation){
        if(corporation==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if (service.Update(corporation)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/addCorporationImg",method = RequestMethod.POST)
    public Boolean addCorporationImg(MultipartFile mfile, String url){
        if(mfile == null) {
            return false;
        }
        File file = new File(ImageUtil.getNewImagePath1(url,mfile.getOriginalFilename()));
        boolean state = ImageUtil.saveImage(mfile, file);
        if(state) {
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/deleteCorporationImg",method = RequestMethod.POST)
    public JsonResult deleteCorporationImg(String img){
        if(img==null || img==""){
            return JsonResultData.error(MSG.ERROR);
        }
        File file=new File("/opt/dome/Spring_Boot_Demo_02/img/corporation/"+img);
        if(file.delete()) {
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }

}
