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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SlideController {
    @Autowired
    private SlideServiceImpl service;

    @RequestMapping(value = "/SelectAll",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectAll(){
        List<Slide> list= service.SelectAll();
        if(list.size()==0){
            MyException.display(MSG.ERROR);
            return JsonResultData.error(MSG.ERROR);
        }
        MyException.display(MSG.SUCCESS,list);
        return JsonResultData.success(list);
    }

    @RequestMapping(value = "/SelectById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectById(String id){
        Slide slide= service.SelectById(id);
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectByName",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByName(String name){
        Slide slide= service.SelectByName(name);
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectBySection",method = RequestMethod.POST)
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

    @RequestMapping(value = "/SelectByLoads",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByLoads(String load){
        List<Slide> slide= service.SelectByLoads(load);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectBySpecifications",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectBySpecifications(String specifications){
        List<Slide> slide= service.SelectBySpecifications(specifications);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectByMaterial",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByMaterial(String material){
        List<Slide> slide= service.SelectByMaterial(material);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectByCharacteristic",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByCharacteristic(String characteristic){
        List<Slide> slide= service.SelectByCharacteristic(characteristic);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/SelectByApplication",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByApplication(String application){
        List<Slide> slide= service.SelectByApplication(application);
        if(slide.size()==0){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        MyException.display(MSG.SUCCESS,slide);
        return JsonResultData.success(slide);
    }

    @RequestMapping(value = "/InsertSlide",method = RequestMethod.POST)
//    @ResponseBody
    public JsonResult InsertSlide(Slide slide){
        if(slide==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        slide.setId(LocalDateTime.now().toString());
        File file=new File("/opt/dome/Spring_Boot_Demo_02/img/"+slide.getId());
        if(!file.exists()){
            file.mkdirs();
            slide.setUrl(file.toString());
        }
        if(service.InsertSlide(slide)){
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success();
        }else {
            MyException.display(MSG.SYSTEM_PARSE);
            return JsonResultData.error(MSG.SYSTEM_PARSE);
        }
    }


    @RequestMapping("/addArticle")
    public Boolean addArticle(MultipartFile mfile,String url){
        if(mfile == null) {
            return false;
        }
        //获取后缀
        String suffixName = ImageUtil.getImagePath(mfile);
        //获取新的文件名
        String newFileName = ImageUtil.getNewFileName(suffixName);
        //保存图片
        File file = new File(ImageUtil.getNewImagePath1(url,newFileName));
        boolean state = ImageUtil.saveImage(mfile, file);
        if(state) {
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/Delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult Delete(String id){
        if (id==""||id==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        Slide s = service.SelectById(id);
        if(s==null){
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
        if(service.DeleteById(id)){
            File file=new File(s.getUrl());
            System.out.println(s.getUrl());
            deleteAllFiles(file);
            MyException.display(MSG.SUCCESS);
            return JsonResultData.success(MSG.SUCCESS);
        }else {
            MyException.display(MSG.PARAMS_ERROR);
            return JsonResultData.error(MSG.PARAMS_ERROR);
        }
    }


    public static void deleteAllFiles(File file){
        //通过file对象获取File数组
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            //测试此抽象路径名表示的文件是否是一个标准文件。
            if (f.isFile()){
                //是文件就删除
                f.delete();
            }else{
                //是一个文件夹，递归删除里面的文件
                deleteAllFiles(f);
                //最后删除文件夹
                f.delete();
            }
        }
        //循环结束后只剩最后一个空文件夹，删除
        file.delete();
    }



    @RequestMapping(value = "/SelectByAll",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult SelectByAll(String s){
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
