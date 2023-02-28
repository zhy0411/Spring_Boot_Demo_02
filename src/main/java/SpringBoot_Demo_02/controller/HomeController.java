package SpringBoot_Demo_02.controller;

import SpringBoot_Demo_02.entity.JsonResult;
import SpringBoot_Demo_02.entity.JsonResultData;
import SpringBoot_Demo_02.exception.MSG;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class HomeController {

    @RequestMapping(value = "/putImg1",method = RequestMethod.POST)
    public JsonResult putImg1(MultipartFile img){
        if(img==null){
            return JsonResultData.error(MSG.ERROR);
        }
        File file = new File(ImageUtil.getNewImagePath("home/img1",img.getOriginalFilename()));
        boolean state = ImageUtil.saveImage(img, file);
        if(state) {
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/deleteImg1",method = RequestMethod.POST)
    public JsonResult deleteImg1(String img){
        if(img==null || img==""){
            return JsonResultData.error(MSG.ERROR);
        }
        File file=new File("/opt/dome/Spring_Boot_Demo_02/img/home/img1/"+img);
        if(file.delete()) {
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }


    @RequestMapping(value = "/updateImg1",method = RequestMethod.POST)
    public JsonResult updateImg1(String path,MultipartFile img){
        String s1 = deleteImg1(path).toString();
        String s2 = putImg1(img).toString();
        if(s1.equals("操作成功") && s2.equals("操作成功")){
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/putImg2",method = RequestMethod.POST)
    public JsonResult putImg2(MultipartFile img){
        if(img==null){
            return JsonResultData.error(MSG.ERROR);
        }
        File file = new File(ImageUtil.getNewImagePath("home/img2",img.getOriginalFilename()));
        boolean state = ImageUtil.saveImage(img, file);
        if(state) {
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }

    @RequestMapping(value = "/deleteImg2",method = RequestMethod.POST)
    public JsonResult deleteImg2(String img){
        if(img==null || img==""){
            return JsonResultData.error(MSG.ERROR);
        }
        File file=new File("/opt/dome/Spring_Boot_Demo_02/img/home/img2/"+img);
        if(file.delete()) {
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }


    @RequestMapping(value = "/updateImg2",method = RequestMethod.POST)
    public JsonResult updateImg2(String path,MultipartFile img){
        String s1 = deleteImg1(path).toString();
        String s2 = putImg1(img).toString();
        if(s1.equals("操作成功") && s2.equals("操作成功")){
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            return JsonResultData.error(MSG.ERROR);
        }
    }
}
